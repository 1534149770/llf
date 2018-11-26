package com.baizhi.entity;

public class FileParam {
	private String url;
	private String oldName;
	private String newName;
	public FileParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the oldName
	 */
	public String getOldName() {
		return oldName;
	}
	/**
	 * @param oldName the oldName to set
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	/**
	 * @return the newName
	 */
	public String getNewName() {
		return newName;
	}
	/**
	 * @param newName the newName to set
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public FileParam(String url, String oldName, String newName) {
		super();
		this.url = url;
		this.oldName = oldName;
		this.newName = newName;
	}
	
}
