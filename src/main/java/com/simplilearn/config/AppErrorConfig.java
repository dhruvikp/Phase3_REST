package com.simplilearn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class AppErrorConfig {


	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String exceptionHandler() {
		return "Internal Error occurred , please contact administrator";
	}
	
}
