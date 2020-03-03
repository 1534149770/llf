package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.llf.dto.AlbumDto;

@RestController
@RequestMapping("/Album")
public class AlbumController {

	@Resource(name="albumService")
	private AlbumService service;
	
	@RequestMapping("findAllAlbumByPage")
	public AlbumDto findAllAlbumByPage(int page,int rows){
		return service.findAllAlbumByPage(page, rows);
	}
	
	@RequestMapping("addAlbum")
	public String addAlbum(Album album,HttpSession session,MultipartFile file) throws IllegalStateException, IOException{
		ServletContext ctx = session.getServletContext();
		String realPath = ctx.getRealPath("/images");
		
		File descFile = new File(realPath + "/" + file.getOriginalFilename());
		file.transferTo(descFile);
		
		String cover = file.getOriginalFilename();
		album.setCover(cover);
		
		System.out.println("album.title="+album.getTitle());
		System.out.println("album.publishDate="+album.getPublishDate());
		
		service.addAlbum(album);
		return "redirect:/showAlbum.jsp"; 
	}
	
	@RequestMapping("findAll")
	public List<Album> findAll(){
		return service.findAllAlbum();
	}
	
}
