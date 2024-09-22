package com.empl.mgr.dto;

import java.util.Date;

public class EmployeesEmolumentDto {
	
	private long emoId;//记录编号
	private long emId; // 员工ID
	private String name; // 员工姓名
	private int emState;//员工类型
	private long deptId;//部门ID
	private String department; // 所属部门
	private String position; // 所属职位
	private String identity; // 身份证号
	private int salary;//薪酬
	private Date timestamp;
	
	
	
	public EmployeesEmolumentDto(long emoId, long emId, String name,
			int emState, long deptId, String department, String position,
			String identity, int salary, Date timestamp) {
		super();
		this.emoId = emoId;
		this.emId = emId;
		this.name = name;
		this.emState = emState;
		this.deptId = deptId;
		this.department = department;
		this.position = position;
		this.identity = identity;
		this.salary = salary;
		this.timestamp = timestamp;
	}





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





	public int getSalary() {
		return salary;
	}





	public void setSalary(int salary) {
		this.salary = salary;
	}





	public Date getTimestamp() {
		return timestamp;
	}





	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
	


	


	
	
	
	
	
	
	
	

}
