package com.herro.entity;

//@Component
//@Table(name = "greeting") //don't need
public class Greeting {

    private final long id; //not Long
    private final String name;
    private final String template;
    private final String body;

    //long from Atomic in controller:
    public Greeting(long id, String name) {

        this.id = id;
        this.template = "{ That punk wants to make your day, " + name + "! }";
        this.name = name;
        this.body = "\r\n{ Data object return from GET request :: Refresh & ID number persists }{ Customizable :: /restgreeting?name=YOURNAME }";
    }

    //    @Id
    public Long getId() {
        return id;
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO) //already fed Atomic id
    }

    public String getTemplate() {
        return template;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
//        return " // Custom JSON POJO return from a GET request\nRefresh and note ID increment persisting\nCustomizable: /restgreeting?name=YOURNAME ";
        return body;
    }
}