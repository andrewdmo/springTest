package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
    
}