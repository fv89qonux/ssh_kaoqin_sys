package com.empl.mgr.dto;

import java.util.Date;

public class NoteDto {
	
	private long id;
	private String creator;
	private String title;
	private String content;
	private Date createTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public NoteDto() {
		super();
	}
	public NoteDto(long id,  String title, String content, String creator, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.createTime = createTime;
	}
	
	
	
	
	
	
	
	
	

}
