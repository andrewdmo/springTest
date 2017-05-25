package com.herro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PsController {

    @RequestMapping(value = {"/paleodemo", "/psindex", "/ps"})
    public String paleodemo() {
        return "ps/psindex";
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

    @ExceptionHandler
    //add URL request query feedback later:
    public String error() {
        return "error";
    }
}