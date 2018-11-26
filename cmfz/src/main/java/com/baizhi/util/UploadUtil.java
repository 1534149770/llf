package com.baizhi.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.FileParam;



public class UploadUtil {
	public static final String File="FILE";
	public static final String IMG="IMG";
	public static FileParam addFile(MultipartFile multipartFile ,HttpServletRequest request,String type){
		String projectPath = request.getSession().getServletContext().getRealPath("/");
		File file =new File(projectPath);
		String webappsPath = file.getParent();
		File uploadPath;
		String url=null;
		if(type.equals(File)){
			uploadPath = new File(webappsPath+"/audio");
			url="/audio";
		}else{
			uploadPath = new File(webappsPath+"/upload");
			url="/upload";
		}
		if(!uploadPath.exists()){
			uploadPath.mkdir();
		}
		
		String oldFilename = multipartFile.getOriginalFilename();
		String extension = FilenameUtils.getExtension(oldFilename);
		UUID uuid =UUID.randomUUID();
		String newName = uuid.toString();
		newName = newName + "."+extension;
		try{
			multipartFile.transferTo(new File(uploadPath.getPath(),newName));
		}catch(IOException e){
			e.printStackTrace();
		}
		return new FileParam(url+"/"+newName,oldFilename,newName);
	}
}
