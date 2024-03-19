package com.estsoft.blogjpa.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/user")
	public String signup(AddUserRequest request){
		userService.save(request);
		return "redirect:/login";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		new SecurityContextLogoutHandler().logout(request,response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/login";
	}
}
