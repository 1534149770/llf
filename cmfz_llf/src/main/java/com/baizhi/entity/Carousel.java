package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;


public class Carousel {
	private Integer id;
	private String title;
	private String descript;
	private String imgPath;
	private Integer status;
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	public Carousel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carousel(Integer id, String title, String descript, String imgPath,
			Integer status, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.descript = descript;
		this.imgPath = imgPath;
		this.status = status;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
