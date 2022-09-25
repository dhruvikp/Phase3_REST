package com.simplilearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@GetMapping("/calculate1")
	public Integer calculate() {
		int a = 6;
		int b = 0;
		int res = 0;

		res = a / b;

		return res;
	}
}