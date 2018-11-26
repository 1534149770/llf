package com.baizhi.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(User user){
		User nuser = service.findUserByUsernamePassword(user);
		if(user!=null){
			return "yes";
		}
		return "no";
	}
	
	@RequestMapping("register")
	@ResponseBody
	public String register(User user){
		service.addUser(user);
		return "yes";
	}

	@RequestMapping("findAllUser")
	@ResponseBody
	public List<User> findAllUser(){
		return service.findAllUser();
	}
}
