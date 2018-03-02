package com.herro.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String error(Exception e, Model model) {
        model.addAttribute("exception", e);
        System.out.println("Error: " + e);
//        System.out.println(model);
        return "error?main";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @RequestMapping("/404")
    public String notFound() {
        return "404";
    }

    //add URL request query feedback later

}