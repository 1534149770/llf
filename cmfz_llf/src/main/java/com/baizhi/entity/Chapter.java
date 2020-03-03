package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Chapter {
	private Integer id;
	private String title;
	private Double size;
	private Integer duration;//时长
	private String downloadPath;
	@JSONField(format="yyyy-MM-dd")
	private Date uploadDate;
	private Integer album_id;
	
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chapter(Integer id, String title, Double size, Integer duration,
			String downloadPath, Date uploadDate, Integer album_id) {
		super();
		this.id = id;
		this.title = title;
		this.size = size;
		this.duration = duration;
		this.downloadPath = downloadPath;
		this.uploadDate = uploadDate;
		this.album_id = album_id;
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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}
	
	
}
