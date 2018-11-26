package com.baizhi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Album {
	private Integer id;
	private String title;
	private String cover;//封面
	private Integer count;
	private String autor;
	private String broadCast;//朗读者
	@JSONField(format="yyyy-MM-dd")
	private Date publishDate;
	private String brief;
	private Integer score;
	private List<Chapter> children = new ArrayList<Chapter>();
	
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(Integer id, String title, String cover, Integer count,
			String autor, String broadCast, Date publishDate, String brief,
			Integer score, List<Chapter> children) {
		super();
		this.id = id;
		this.title = title;
		this.cover = cover;
		this.count = count;
		this.autor = autor;
		this.broadCast = broadCast;
		this.publishDate = publishDate;
		this.brief = brief;
		this.score = score;
		this.children = children;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getBroadCast() {
		return broadCast;
	}

	public void setBroadCast(String broadCast) {
		this.broadCast = broadCast;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<Chapter> getChildren() {
		return children;
	}

	public void setChildren(List<Chapter> children) {
		this.children = children;
	}
	
	
	
}
