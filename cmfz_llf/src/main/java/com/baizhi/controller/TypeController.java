package com.baizhi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Type;
import com.baizhi.service.TypeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Type")
public class TypeController {

	@Resource(name="typeService")
	private TypeService service;
	
	@RequestMapping("/findAll")
	public List<Type> findAll(){
		return service.findAll();
	}
}
