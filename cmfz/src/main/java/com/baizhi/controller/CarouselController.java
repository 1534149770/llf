package com.baizhi.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.baizhi.aop.LogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import com.llf.dto.CarouselDto;

@Controller
@RequestMapping("/Carousel")
public class CarouselController {

	@Resource(name="carouselService")
	private CarouselService service;
	
	@RequestMapping("/addCarousel")
	public String addCarousel(Carousel carousel,HttpSession session,MultipartFile file) throws IllegalStateException, IOException{
		ServletContext ctx = session.getServletContext();
		String realPath = ctx.getRealPath("/images");
		
		File descFile = new File(realPath + "/" + file.getOriginalFilename());
		file.transferTo(descFile);
		
		String img_name = file.getOriginalFilename();
		
		carousel.setImgPath(img_name);
		service.addCarousel(carousel);
		return "redirect:/showCarousel.jsp";
	}
	
	@RequestMapping("/modifyCarousel")
	public String modifyCarousel(Carousel carousel){
		System.out.println("carouselTitle="+carousel.getTitle()+"carouselStatus="+carousel.getStatus());
		service.modifyCarousel(carousel);
		return "redirect:/showCarousel.jsp";
	}
	
	@RequestMapping("findCarouselByPage")
	@ResponseBody
	public CarouselDto findCarouselByPage(int page,int rows){
		return service.findAllCarouselByPage(page, rows);
	}
	
	@RequestMapping("/removeCarousel")
	public String removeCarousel(int id){
		service.removeCarousel(id);
		return "redirect:/showCarousel.jsp";
	}
}
