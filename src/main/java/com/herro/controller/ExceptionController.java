//package com.herro.controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////@RequestMapping(value = "/error")
//@ControllerAdvice
//public class ExceptionController {
//
//
//    @ExceptionHandler
//    @GetMapping(value = "/error")
//    public String error(Exception e, Model model) {
//        model.addAttribute("exception", e);
//        System.out.println("Error: " + e);
////        System.out.println(model);
////        return "error?main";
//        return "error";
////        return error();
//    }
//
//
////    @RequestMapping("/error")
////    public String error() {
////        return "error";
////    }
//
//    @RequestMapping("/403")
//    public String accessDenied() {
//        return "403";
//    }
//
//    @RequestMapping("/404")
//    public String notFound() {
//        return "404";
//    }
//
//    //add URL request query feedback later
//
//}