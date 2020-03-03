package com.baizhi.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.llf.dto.GuruDto;

@RestController
@RequestMapping("/Guru")
public class GuruController {

	@Resource(name="guruService")
	private GuruService service;
	
	@RequestMapping("/addGuru")
	public String addGuru(Guru guru,HttpSession session,MultipartFile file) throws IllegalStateException, IOException{
		ServletContext ctx = session.getServletContext();
		String realPath = ctx.getRealPath("/images");
		
		File descFile = new File(realPath + "/" + file.getOriginalFilename());
		file.transferTo(descFile);
		
		String img_name = file.getOriginalFilename();
		
		guru.setProfile(img_name);
		service.addGuru(guru);
		return "redirect:/showGuru.jsp";
	}
	
	@RequestMapping("/modifyGuru")
	public String modifyGuru(Guru guru){
		service.modifyGuru(guru);
		return "redirect:/showGuru.jsp";
	}
	
	@RequestMapping("findGuruByPage")
	public GuruDto findGuruByPage(int page,int rows){
		return service.findAllGuruByPage(page, rows);
	}
	
	@RequestMapping("/removeGuru")
	public String removeGuru(int id){
		service.removeGuru(id);
		return "redirect:/showGuru.jsp";
	}
}
