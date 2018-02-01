package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "name", required = false, defaultValue = "Andy Moretz") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    // maybe change name later for protection:
    // GET/POST/model handled in SecConfig
    @RequestMapping("/login")
    public String login(@RequestParam(value = "param", required = false) String param, Model model) {
//        model.addAttribute("param", param);
        return "login";
    }

    //secured:
    @RequestMapping(value = {"/usersecurespace", "/user/usersecurespace"}) //user** ??
    public String usersecurespace(@RequestParam(value = "param", required = false) String redirect, Model model) {
//        model.addAttribute("redirect", redirect);
        return "user/usersecurespace";
    }

    @RequestMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @RequestMapping(value = {"/mvcgreeting", "/mvcgreeting.html"})
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

    @RequestMapping("/lovin")
    public String lovin(@RequestParam(value = "param", required = false) String param, Model model) {
        return "oddrod/lovin";
    }

    @RequestMapping("/oddrod")
    public String oddrodd() {
        return "oddrod/oddrod";
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