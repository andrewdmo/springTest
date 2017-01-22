package howdy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mvcController {

    @RequestMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Wirl") String name, Model
        model) {
        model.addAttribute("name", name);
        return "index";
    }


    @RequestMapping("/mvcgreeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Wirl") String name, Model model) {
        model.addAttribute("name", name);
        return "mvcgreeting";
    }

    //    @RequestMapping("")
    @ExceptionHandler
    //add URL request feedback later:
    public String error() {
        return "error";
    }

}
