package com.herro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class DualController {

    @RequestMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Pilgrim") String name, Model
        model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/mvcgreeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Pilgrim") String name, Model model) {
        model.addAttribute("name", name);
        return "mvcgreeting";
    }

    @RequestMapping(value = {"/paleodemo", "/psindex"})
    public String paleodemo() {
        return "psindex";
    }

    @RequestMapping("/psabout")
    public String psabout() {
        return "psabout";
    }

    @RequestMapping("/psarchives")
    public String psarchives() {
        return "psarchives";
    }

    @RequestMapping("/psblog")
    public String psblog() {
        return "psblog";
    }

    @RequestMapping("/pscontact")
    public String pscontact() {
        return "pscontact";
    }

    @RequestMapping("/psportfolio")
    public String psportfolio() {
        return "psportfolio";
    }

    @RequestMapping("/moviesql")
    public String moviesql() {
        return "moviesql";
    }

    @RequestMapping("/rockps")
    public String rockps() {
        return "rockps";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }


    @RestController
    public class restController {

        private static final String template = "That punk wants to make your day, %s!";
        private final AtomicLong counter = new AtomicLong();

        @RequestMapping(path = "/restgreeting", method = RequestMethod.GET)
        public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Harry") String name, String description) {
            //ID increases by one every request:
            return new Greeting(counter.incrementAndGet(),
                String.format(template, name)/*, description*/);
        }
    }
}