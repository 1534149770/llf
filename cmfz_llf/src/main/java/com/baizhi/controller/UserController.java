package com.baizhi.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("login")
	public String login(User user){
		User nuser = service.findUserByUsernamePassword(user);
		if(user!=null){
			return "yes";
		}
		return "no";
	}
	
	@RequestMapping("register")
	public String register(User user){
		service.addUser(user);
		return "yes";
	}

	@RequestMapping("findAllUser")
	public List<User> findAllUser(){
		return service.findAllUser();
	}
}
