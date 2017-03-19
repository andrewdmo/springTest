package com.herro;

//import org.springframework.stereotype.Component;
//
//@Component
public class Greeting {

    private final long id;
    private final String content;

    Greeting(long id, String content/*, String description*/) {
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
        return " **** This is a sample JSON data return from a RESTful request.  Refresh and note the ID increment persisting.  Customize by adding a parameter: /restgreeting?name=YOURNAME **** ";
    }
}