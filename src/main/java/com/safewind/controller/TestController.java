package com.safewind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.safewind.service.TestService;
@Controller

public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("hello")
	public String MyJsp(Model model){
		
		model.addAttribute("message", testService.getMessage());
		
		return "MyJsp";
	}
}
