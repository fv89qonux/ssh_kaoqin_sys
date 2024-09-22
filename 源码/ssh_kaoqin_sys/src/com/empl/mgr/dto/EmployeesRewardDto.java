package com.empl.mgr.dto;

import java.util.Date;

public class EmployeesRewardDto {
	
	private long id; // 奖惩ID
	private long emId;//员工ID
	private String name; // 员工姓名
	private int emState;//员工类型
	private long deptId;//部门ID
	private String department; // 所属部门
	private String position; // 所属职位
	private String identity; // 身份证号
	
	private int type;//奖惩：1降，2惩
	private String title;//奖惩名称
	private String amount;//奖惩金额
	private String content;//奖惩内容
	private String creator;//创建者
	private String createTime;//创建时间
	private Date timestamp;
	
	
	
	
	public EmployeesRewardDto() {
		super();
	}
	
	
	public EmployeesRewardDto(long id, long emId, String name, int emState, long deptId, String department,
			String position, String identity, int type, String title, String amount, String content, String creator,
			String createTime,Date timestamp) {
		super();
		this.id = id;
		this.emId = emId;
		this.name = name;
		this.emState = emState;
		this.deptId = deptId;
		this.department = department;
		this.position = position;
		this.identity = identity;
		this.type = type;
		this.title = title;
		this.amount = amount;
		this.content = content;
		this.creator = creator;
		this.createTime = createTime;
		this.timestamp = timestamp;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
