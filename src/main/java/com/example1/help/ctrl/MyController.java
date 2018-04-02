package com.example1.help.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping(value="/welcome",method=RequestMethod.POST)
	public String welcomeMsg() {
		return "Welcome to spring boot app";
	}

}
