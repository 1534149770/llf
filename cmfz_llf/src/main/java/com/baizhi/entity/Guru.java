package com.baizhi.entity;

public class Guru {
	private Integer id;
	private String name;
	private String profile;
	private String brief;
	private String status;
	public Guru() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Guru(Integer id, String name, String profile, String brief,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.brief = brief;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
