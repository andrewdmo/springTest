package com.herro.entity;

//import org.springframework.stereotype.Component;
//
//@Component
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content/*, String description*/) {
        this.id = id;
        this.content = content;
//        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return " **** JSON data return from a RESTful GET request.  Refresh and note ID increment persisting.  Customize by adding a parameter: /restgreeting?name=YOURNAME **** ";
    }
}