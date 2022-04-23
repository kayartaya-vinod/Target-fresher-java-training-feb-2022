package com.targetindia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloController {
	
	public HelloController() {
		log.trace("HelloController() called");
	}

	
	// an example handler method to handle requests from browser
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		log.trace("HelloController.sayHello() called");
		
		String html = "<h1>Hello, world!</h1>";
		html += "<hr />";
		html += "<p>This output is coming from a Java Spring MVC Controller Object</p>";
		
		return html;
	}
}
