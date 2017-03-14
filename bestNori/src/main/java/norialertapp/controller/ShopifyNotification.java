package norialertapp.controller;
import norialertapp.entity.CatchHook;
import norialertapp.entity.LineItem;
import norialertapp.entity.Product;
import norialertapp.entity.Variant;
import norialertapp.repository.ProductRepo;
import norialertapp.repository.QtyTriggerRepo;
import norialertapp.service.OrderCreatedService;
import norialertapp.service.ShopifyService;
import norialertapp.service.TriggerMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by katherine_celeste on 10/5/16.
 */

@RestController
public class ShopifyNotification {

    @Autowired
    public OrderCreatedService orderCreatedService;

    @Autowired
    public ShopifyService shopifyService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    TriggerMailService triggerMailService;

    @Autowired
    QtyTriggerRepo qtyTriggerRepo;

    //Updates db if someone places or cancels an order
    @RequestMapping(path = "/order")
    public String caughtHook(@RequestBody CatchHook catchHook) throws MessagingException {

            List<LineItem> lineItems = catchHook.getLine_items();

            HashMap<Long, Integer> productIDs = new HashMap<>(); // create list of productID's from JSON order


            for (LineItem lineItem : lineItems) {
                Integer qty = lineItem.getQuantity(); // get qty from JSON order
                productIDs.put(lineItem.getProduct_id(), qty);
            }

            for (HashMap.Entry<Long, Integer> product : productIDs.entrySet()) { //iterate through HashMap and add products to list that

                // get current qty...in 3 simple steps:D
                Product a = productRepo.findOne(product.getKey());
                List<Variant> variant = a.getVariants();
                Integer qty = variant.get(0).getInventory_quantity();

                Integer updatedQty;

                // If order canceled, add qty back to db
                if(catchHook.getCancel_reason()!=null)
                {
                    updatedQty = qty + product.getValue();
                }
                else { //else if it's an order, then subtract qty to unpdate db
                    updatedQty = qty - product.getValue();
                }

                Product aProduct = productRepo.getOne(product.getKey());
                aProduct.getVariants().get(0).setInventory_quantity(updatedQty); // update Product with revised Qty

                // do comparison and see if you have to send out an email alert
                triggerMailService.triggerEmail(qtyTriggerRepo.findByProductId(product.getKey()).getQtyTrigger(),product.getKey());

                productRepo.save(aProduct);

            }

        return "";
    }


    // If someone manually updates inventory:
    @RequestMapping(path = "/products/update")
    public String caughtHook(@RequestBody Product product) throws MessagingException {

        //update qty in db first
        productRepo.save(product);

        // do comparison and see if you have to send out an email alert
        String qty = qtyTriggerRepo.findByProductId(product.getId()).getQtyTrigger();
        triggerMailService.triggerEmail(qty,product.getId());


        return "";
    }

    @RequestMapping(path = "/google79ef565d46e8d4f5.html")
    public String googleSiteVerify(HTML html) {
        return "google-site-verification: google79ef565d46e8d4f5.html";
    }
}
