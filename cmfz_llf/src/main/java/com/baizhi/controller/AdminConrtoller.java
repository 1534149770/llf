package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import validateutil.SecurityCode;
import validateutil.SecurityImage;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminConrtoller {

	@Resource(name="adminService")
	private AdminService service;
	
	String code = null;
	
	@RequestMapping("img")
	public void createImg(HttpSession session, HttpServletResponse response) throws IOException{
		code = SecurityCode.getSecurityCode();
		System.out.println(code);
		
		session.setAttribute("ServerCode", code);
		
		BufferedImage bi = SecurityImage.createImage(code);
		
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "png", out);
		
	}	
	
	@RequestMapping("/login")
	public String login(Admin admin,String clientCode,HttpSession session){
		System.out.println("username="+admin.getUsername());
		System.out.println("password="+admin.getPassword());
		
		Admin nAdmin = service.findAdminByUsernamePassword(admin);
		if(nAdmin!=null && code.equals(clientCode)){
			System.out.println("路过登录成功");
			session.setAttribute("admin", nAdmin);
			return "redirect:/layout.jsp";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("change")
	public String change(Admin admin){
		service.changeAdminPassword(admin);
		return "redirect:/login.jsp";
	}
}
