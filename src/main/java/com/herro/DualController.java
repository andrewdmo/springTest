package com.herro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class DualController {

    @RequestMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Visitor") String name, Model
        model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/mvcgreeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Clint") String name, Model model) {
        model.addAttribute("name", name);
        return "mvcgreeting";
    }

    @RequestMapping("/paleodemo")
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

    @RequestMapping("/movie_sql")
    public String movie_sql() {
        return "movie_sql";
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

        @RequestMapping("/restgreeting")
        public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Clint") String name) {
            //ID increases by one every request:
            return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        }
    }
}