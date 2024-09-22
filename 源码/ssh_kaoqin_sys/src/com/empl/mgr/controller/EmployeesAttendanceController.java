package com.empl.mgr.controller;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empl.mgr.annotation.SecureValid;
import com.empl.mgr.constant.MethodType;
import com.empl.mgr.controller.support.AbstractController;
import com.empl.mgr.dao.EmployeesAttendanceDao;
import com.empl.mgr.dto.EmployeesAttendanceDto;
import com.empl.mgr.dto.EmployeesInfoDto;
import com.empl.mgr.model.TeEmployeesAttendance;
import com.empl.mgr.service.EmployeesService;
import com.empl.mgr.support.JSONReturn;


@Scope
@Controller
@RequestMapping(value = "employees/attendance")
public class EmployeesAttendanceController extends AbstractController{
	
	@Autowired
	private EmployeesService employeesService;
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesAttendanceList")
	@SecureValid(code = "02001", desc = "获取考勤列表", type = MethodType.FIND)
	public JSONReturn findEmployeesAttendanceList(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesAttendanceList(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}

	@ResponseBody
	@RequestMapping(value = "findEmployeesAttendanceCount")
	@SecureValid(code = "02001", desc = "获取考勤分页", type = MethodType.FIND)
	public JSONReturn findEmployeesAttendanceCount(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesAttendanceCount(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesByDepartment")
	@SecureValid(code = "02001", desc = "根据部门获取员工", type = MethodType.FIND)
	public JSONReturn findEmployeesByDepartment(@RequestParam long department) {
		return employeesService.findEmployeesByDepartment(department);
	}
	
	@ResponseBody
	@RequestMapping(value = "addEmployeesAttendance")
	@SecureValid(code = "02001", desc = "保存考勤信息", type = MethodType.ADD)
	public JSONReturn addEmployeesAttendance(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesAttendance attendance = (TeEmployeesAttendance) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesAttendance.class);
		return employeesService.saveEmployeesAttendanceInfo(attendance,acctName(httpSession));
	}
	
	@ResponseBody
	@RequestMapping(value = "findAttendanceById")
	@SecureValid(code = "02001", desc = "获取考勤信息", type = MethodType.FIND)
	public JSONReturn findAttendanceById(@RequestParam long attenId) {
		
		return employeesService.findEmployeesAttendanceInfo(attenId);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "modifyAttendance")
	@SecureValid(code = "02001", desc = "修改考勤信息", type = MethodType.MODIFY)
	public JSONReturn modifyAttendance(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesAttendance attendance = (TeEmployeesAttendance) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesAttendance.class);
		return employeesService.modifyAttendanceInfo(attendance,acctName(httpSession));
	}
	
	
	@ResponseBody
	@RequestMapping(value = "deleteAttendance")
	@SecureValid(code = "02001", desc = "删除考勤信息", type = MethodType.DELETE)
	public JSONReturn deleteAttendance(@RequestParam long attenId,HttpSession httpSession) {
	
		return employeesService.deleteAttendanceInfo(attenId);
	}

}
