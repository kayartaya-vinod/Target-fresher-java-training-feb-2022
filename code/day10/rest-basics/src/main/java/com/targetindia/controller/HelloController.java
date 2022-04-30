package com.targetindia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping(produces = "text/plain")
    public String greetAsText(){
        return "Hello, and welcome to Spring boot training!";
    }

    @GetMapping(produces = "text/html")
    public String greetAsHtml(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <title>Hello, from spring boot</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Hello, from spring boot</h1>\n" +
                "        <hr />\n" +
                "        <p>Developed by Vinod for Target India.</p>\n" +
                "    </body>\n" +
                "</html>\n";
    }

    @GetMapping(produces = "application/json")
    public Map<String, Object> greetAsJson(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("message", "Hello, from spring boot!");
        map.put("timestamp", new Date());
        map.put("author-name", "Vinod Kumar");
        map.put("author-email", "vinod@vinod.co");
        return map;
    }
}
