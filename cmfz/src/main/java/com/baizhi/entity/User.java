package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private Integer id;
	private String phoneNum;
	private String username;
	private String password;
	private String sex;
	private String dharmaName;
	private String salt;
	private String sign;
	private String profile;
	private String province;
	private String city;
	private String status;
	@JSONField(format="yyyy-MM-dd")
	private Date registerTime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String phoneNum, String username, String password,
			String sex, String dharmaName, String salt, String sign,
			String profile, String province, String city, String status,
			Date registerTime) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.dharmaName = dharmaName;
		this.salt = salt;
		this.sign = sign;
		this.profile = profile;
		this.province = province;
		this.city = city;
		this.status = status;
		this.registerTime = registerTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDharmaName() {
		return dharmaName;
	}
	public void setDharmaName(String dharmaName) {
		this.dharmaName = dharmaName;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
}
