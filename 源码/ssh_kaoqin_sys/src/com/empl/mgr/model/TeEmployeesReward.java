package com.empl.mgr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "te_employees_reward")
public class TeEmployeesReward {
	
	private static final long serialVersionUID = 1L;
	private long id;
	
	private long emId;
	
	private int type;
	
	private String title;
	
	private String amount;
	
	private String content;
	
	private String creator;
	
	private String createTime;
	
	private Date timestamp;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Column(name = "emId")
	public long getEmId() {
		return emId;
	}

	public void setEmId(long emId) {
		this.emId = emId;
	}

	@Column(name = "type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}

	
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "createTime")
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "timestamp")
	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
