package com.herro.controller;

import com.google.gson.Gson;
import com.herro.entity.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController("/rest*")
public class RestfulController {

    //Id from server session, not client
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/restgreeting", method = RequestMethod.GET)
    private String restgreeting(@RequestParam(value = "name", defaultValue = "Harry", required = false) String name) {

        Gson g = new Gson();

        //ID increases by one every request and pulls from Greeting POJO:
        Greeting greeting = new Greeting(counter.incrementAndGet(), name);

//return g.toJson(greeting);

        return "{ ID :: \r\n" + greeting.getId() + " }" + greeting.getTemplate() + greeting.getBody();

        //old way, ugly String:
//            String.format(template, name));
    }
}