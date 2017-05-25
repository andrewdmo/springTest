package com.herro.controller;

import com.herro.entity.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestfulController {

    private static final String template = "That punk wants to make your day, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/restgreeting", method = RequestMethod.GET)
    public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Harry", required = false) String name, String description) {

        //ID increases by one every request and pulls from Greeting POJO:
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name, description));
    }
}
