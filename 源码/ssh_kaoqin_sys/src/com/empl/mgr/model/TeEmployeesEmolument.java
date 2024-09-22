package com.empl.mgr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "te_employees_salary")
public class TeEmployeesEmolument implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long emoId;
	private long emId;
	private int salary;
	private Date createTime;
	private String creator;
	private Date timestamp;
	
	/** default constructor */
	public TeEmployeesEmolument() {
		super();
	}

	/** full constructor */
	public TeEmployeesEmolument(long emoId, long emId, int salary,
			Date createTime, String creator, Date timestamp) {
		super();
		this.emoId = emoId;
		this.emId = emId;
		this.salary = salary;
		this.createTime = createTime;
		this.creator = creator;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "emoId", unique = true, nullable = false)
	public long getEmoId() {
		return emoId;
	}

	public void setEmoId(long emoId) {
		this.emoId = emoId;
	}
	
	
	public long getEmId() {
		return emId;
	}

	

	public void setEmId(long emId) {
		this.emId = emId;
	}

	@Column(name = "salary")
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "timestamp")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
