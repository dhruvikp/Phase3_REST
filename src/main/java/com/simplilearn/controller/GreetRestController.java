package com.simplilearn.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.model.Greet;

//@Controller

@RestController
public class GreetRestController {

	// @GetMapping("/greetMe")
	@RequestMapping(value = "/greetMe", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Greet greet() {
		Greet greet = new Greet();
		greet.setMessage("Hello world!");
		greet.setName("Dhruvik");
		return greet;
	}
}
