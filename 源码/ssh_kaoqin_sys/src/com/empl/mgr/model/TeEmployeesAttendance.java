package com.empl.mgr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "te_employees_attendance")
public class TeEmployeesAttendance implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long attenId;
	private long emId;
	private String atteTime;
	private String morning;
	private String afternoon;
	private Date createTime;
	private String creator;
	private Date timestamp;
	
	
	/** default constructor */
	public TeEmployeesAttendance() {
		super();
	}


	/** full constructor */
	public TeEmployeesAttendance(long attenId, long emId, String atteTime,
			String morning, String afternoon, Date createTime, String creator,
			Date timestamp) {
		super();
		this.attenId = attenId;
		this.emId = emId;
		this.atteTime = atteTime;
		this.morning = morning;
		this.afternoon = afternoon;
		this.createTime = createTime;
		this.creator = creator;
		this.timestamp = timestamp;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "attenId", unique = true, nullable = false)
	public long getAttenId() {
		return attenId;
	}


	public void setAttenId(long attenId) {
		this.attenId = attenId;
	}


	@Column(name = "emId")
	public long getEmId() {
		return emId;
	}


	public void setEmId(long emId) {
		this.emId = emId;
	}


	@Column(name = "atteTime")
	public String getAtteTime() {
		return atteTime;
	}


	public void setAtteTime(String atteTime) {
		this.atteTime = atteTime;
	}


	@Column(name = "morning")
	public String getMorning() {
		return morning;
	}


	public void setMorning(String morning) {
		this.morning = morning;
	}


	@Column(name = "afternoon")
	public String getAfternoon() {
		return afternoon;
	}


	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
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
