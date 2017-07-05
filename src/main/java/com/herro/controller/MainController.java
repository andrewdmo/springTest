package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model
        model) {
        model.addAttribute("name", name);
        return "index";
    }

    // change name later:
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    //secured:
    @RequestMapping(value = {"/usersecurespace", "/user/usersecurespace"})
    public String usersecurespace() {
        return "user/usersecurespace";
    }

    @RequestMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @RequestMapping("/mvcgreeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Pilgrim") String name, Model model) {
        model.addAttribute("name", name);
        return "mvcgreeting";
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

    @RequestMapping("/tiystyle")
    public String tiystyle() {
        return "tiystyle";
    }

    @RequestMapping("/nori")
    public String nori() {
        return "nori";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/animalshelter")
    public String animalshelter() {
        return "animalshelter";
    }

    @RequestMapping("/clojure")
    public String clojure() {
        return "clojure";
    }

//    Moved to ExceptionController:
//    @ExceptionHandler
//    //add URL request query feedback later:
//    public String error() {
//        return "error";
//    }

//moved to own class:
//    @RestController
//    public class restController {
//
//        private static final String template = "That punk wants to make your day, %s!";
//        private final AtomicLong counter = new AtomicLong();
//
//        @RequestMapping(path = "/restgreeting", method = RequestMethod.GET)
//        public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Harry", required = false) String name, String description) {
//            //ID increases by one every request:
//            return new Greeting(counter.incrementAndGet(),
//                String.format(template, name, description));
//        }
//    }
}