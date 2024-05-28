package com.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
@GetMapping("/")
	public String hello(HttpServletRequest req) {
		return "hello" + req.getSession().getId();
	}
@GetMapping("about")
public String about(HttpServletRequest req) {
	return "about"+req.getSession().getId();
}
}
