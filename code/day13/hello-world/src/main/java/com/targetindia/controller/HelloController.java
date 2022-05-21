package com.targetindia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public Map<String, Object> sayHello(){
        Map<String, Object> map =new HashMap<>();
        map.put("message", "Hello, World!");
        map.put("timestamp", new Date());
        return map;
    }
}
