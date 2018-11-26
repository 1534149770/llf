package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;

@Controller
@RequestMapping("/Chapter")
public class ChapterController {

	@Resource(name="chapterService")
	private ChapterService service;
	
	@RequestMapping("/addChapter")
	public String addChapter(Chapter chapter,HttpSession session,MultipartFile file) throws IllegalStateException, IOException{
		ServletContext ctx = session.getServletContext();
		String realPath = ctx.getRealPath("/sound");
		
		File descFile = new File(realPath + "/" + file.getOriginalFilename());
		file.transferTo(descFile);
		
		String downloadPath = file.getOriginalFilename();
		chapter.setDownloadPath(downloadPath);
		
		service.addChapter(chapter);
		return "redirect:/showAlbum.jsp";
	}
	
	@RequestMapping("downChapter")
	public @ResponseBody void fileDownload (String url,HttpSession session,HttpServletResponse response) throws IOException{
		String realPath = session.getServletContext().getRealPath("/sound");
		byte[] bs = FileUtils.readFileToByteArray(new File(realPath+"/"+url));
		// 设置 响应头信息
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(url, "utf-8"));
		
		// 使用输出流，往client输出
		ServletOutputStream out = response.getOutputStream();
		out.write(bs);
	}
}
