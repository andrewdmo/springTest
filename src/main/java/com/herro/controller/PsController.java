package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PsController {

    @RequestMapping(value = {"/paleodemo", "/psindex", "/ps"})
    public String paleodemo() {
        return "ps/psindex";
    }

    @RequestMapping("/psabout")
    public String psabout() {
        return "ps/psabout";
    }

    @RequestMapping("/psarchives")
    public String psarchives() {
        return "ps/psarchives";
    }

    @RequestMapping("/psblog")
    public String psblog() {
        return "ps/psblog";
    }

    @RequestMapping("/pscontact")
    public String pscontact() {
        return "ps/pscontact";
    }

    @RequestMapping("/psportfolio")
    public String psportfolio() {
        return "ps/psportfolio";
    }

//    @ExceptionHandler
//    //add URL request query feedback later:
//    public String error() {
//        return "error";
//    }
}