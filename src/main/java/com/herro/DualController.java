package com.herro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
//@EnableAutoConfiguration
public class DualController {

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

    //    @RequestMapping("/error")
    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }


    @RestController
    public class restController {

        private static final String template = "Herro, %s!";
        private final AtomicLong counter = new AtomicLong();

        @RequestMapping("/restgreeting")
        public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Wirl") String name) {
            //ID increases by one every request:
            return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        }
    }
}