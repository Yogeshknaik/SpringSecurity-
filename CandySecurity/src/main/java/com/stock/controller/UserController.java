package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Users;
import com.stock.service.JwtService;
import com.stock.service.dao.UserRepo;

@RestController
public class UserController {
	@Autowired
	private UserRepo repo;
	@Autowired
	private AuthenticationManager authoManage;
	@Autowired
	private JwtService jwtServic;
	
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(10);
	@PostMapping("reg")
	public Users regester(@RequestBody Users user) {
		// we can create new class in service layer if we needed
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return user;
	}
	@PostMapping("login")
	public String login(@RequestBody Users user) {
		Authentication authe=authoManage.authenticate(new UsernamePasswordAuthenticationToken
													(user.getUsername(), user.getPassword()));
		return authe.isAuthenticated()?jwtServic.generateToken(user.getUsername()):"fail";
	}

}
