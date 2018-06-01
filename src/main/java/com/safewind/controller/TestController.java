package com.safewind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.safewind.service.TestService;
@Controller

public class TestController {
//	@Autowired
//	private TestService testService;
//
	@RequestMapping("login")
	public String login(Model model){

		return "login";
	}
	@RequestMapping("myCount")
	public String myCount(Model model){

		return "myCount";
	}
	@RequestMapping("transfer")
	public String transfer(Model model){

		return "transfer";
	}



}
