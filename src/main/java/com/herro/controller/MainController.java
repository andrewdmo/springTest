package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(@RequestParam(value = "pic", required = false, defaultValue = "iframe") String param, Model model) {
        model.addAttribute("pic", param);
        System.out.println(param);
        return "index";
    }

//    @GetMapping("/index-static")
//    public String indexStatic(@RequestParam(value = "pic", required = false, defaultValue = "static") String param, Model model) {
//        model.addAttribute("pic", param);
//        System.out.println(param);
//        return "index";
//    }

    @ExceptionHandler
    @GetMapping(value = "/error")
    public String error(Exception e, Model model) {
        model.addAttribute("exception", e);
        System.out.println("Error: " + e);
//        System.out.println(model);
//        return "error?main";
        return "error";
//        return error();
    }

    //remove later:
//    @GetMapping("/index2*")
//    public String index2() {
//        return "index2";
//    }

    // maybe change name later for protection:
    // GET/POST/model handled in SecConfig
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/login-logout")
    public String loginLogout(Model model) {
        model.addAttribute("loginLogout", true);
        return "login";
    }

    @GetMapping("/login-redirect")
    public String loginRedirect(Model model) {
        model.addAttribute("loginRedirect", true);
        return "login";
    }

    //SECURE:
    @GetMapping(value = {"/usersecurespace", "/user/usersecurespace"}) //user** ??
    public String usersecurespace(@RequestParam(value = "param", required = false) String redirect, Model model) {
//        model.addAttribute("redirect", redirect);
        return "user/usersecurespace";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @GetMapping(value = {"/mvcgreeting", "/mvcgreeting.html"})
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Pilgrim") String
                               name, Model model) {
        model.addAttribute("name", name);
        return "mvcgreeting";
    }

    @GetMapping("/moviesql")
    public String moviesql() {
        return "moviesql";
    }

    @GetMapping("/rockps")
    public String rockps() {
        return "rockps";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/tiystyle")
    public String tiystyle() {
        return "tiystyle";
    }

    @GetMapping("/nori")
    public String nori() {
        return "nori";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/animalshelter")
    public String animalshelter() {
        return "animalshelter";
    }

    @GetMapping("/clojure")
    public String clojure() {
        return "clojure";
    }

//    @GetMapping("/lovin")
//    public String lovin(@RequestParam(value = "param", required = false) String param, Model model) {
//        return "oddrod/lovin";
//    }
//
//    @GetMapping("/oddrod")
//    public String oddrodd() {
//        return "oddrod/oddrod";
//    }


//moved to own class:
//    @RestController
//    public class restController {
//
//        private static final String template = "That punk wants to make your day, %s!";
//        private final AtomicLong counter = new AtomicLong();
//
//        @GetMapping(path = "/restgreeting", method = RequestMethod.GET)
//        public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Harry", required = false) String name, String description) {
//            //ID increases by one every request:
//            return new Greeting(counter.incrementAndGet(),
//                String.format(template, name, description));
//        }
//    }
}