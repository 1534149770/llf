package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

public class Type {
	private Integer id;
	private String title;
	private String url;
	private String iconCls;
	private Integer parent_id;
	private List<Type> types = new ArrayList<Type>();
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(Integer id, String title, String url, String iconCls,
			Integer parent_id, List<Type> types) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.iconCls = iconCls;
		this.parent_id = parent_id;
		this.types = types;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	
	
}
