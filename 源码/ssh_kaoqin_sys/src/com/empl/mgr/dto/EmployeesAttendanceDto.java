package com.empl.mgr.dto;

import java.util.Date;

public class EmployeesAttendanceDto {
	
	private long attenId;//记录编号
	private long id; // 员工ID
	private String name; // 员工姓名
	private int emState;//员工类型
	private long deptId;//部门ID
	private String department; // 所属部门
	private String position; // 所属职位
	private String identity; // 身份证号
	private String atteTime;
	private String morning;
	private String afternoon;
	private Date timestamp;
	
	
	public EmployeesAttendanceDto() {
		// TODO Auto-generated constructor stub
	}


	public EmployeesAttendanceDto(long attenId, long id, String name,
			int emState, long deptId, String department, String position,
			String identity, String atteTime, String morning, String afternoon,
			Date timestamp) {
		super();
		this.attenId = attenId;
		this.id = id;
		this.name = name;
		this.emState = emState;
		this.deptId = deptId;
		this.department = department;
		this.position = position;
		this.identity = identity;
		this.atteTime = atteTime;
		this.morning = morning;
		this.afternoon = afternoon;
		this.timestamp = timestamp;
	}


	public long getAttenId() {
		return attenId;
	}


	public void setAttenId(long attenId) {
		this.attenId = attenId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEmState() {
		return emState;
	}


	public void setEmState(int emState) {
		this.emState = emState;
	}


	public long getDeptId() {
		return deptId;
	}


	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getAtteTime() {
		return atteTime;
	}


	public void setAtteTime(String atteTime) {
		this.atteTime = atteTime;
	}


	public String getMorning() {
		return morning;
	}


	public void setMorning(String morning) {
		this.morning = morning;
	}


	public String getAfternoon() {
		return afternoon;
	}


	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	


	
	
	
	
	
	
	
	

}
