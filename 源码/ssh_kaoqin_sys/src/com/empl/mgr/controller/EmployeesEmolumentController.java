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
import com.empl.mgr.model.TeEmployeesAttendance;
import com.empl.mgr.model.TeEmployeesEmolument;
import com.empl.mgr.service.EmployeesService;
import com.empl.mgr.support.JSONReturn;

@Scope
@Controller
@RequestMapping(value = "employees/Emolument")
public class EmployeesEmolumentController extends AbstractController{
	
	@Autowired
	private EmployeesService employeesService;
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesEmolumentList")
	@SecureValid(code = "02002", desc = "获取薪酬列表", type = MethodType.FIND)
	public JSONReturn findEmployeesEmolumentList(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesEmolumentList(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}

	@ResponseBody
	@RequestMapping(value = "findEmployeesEmolumentCount")
	@SecureValid(code = "02002", desc = "获取薪酬分页", type = MethodType.FIND)
	public JSONReturn findEmployeesEmolumentCount(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesEmolumentCount(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesByDepartment")
	@SecureValid(code = "02002", desc = "根据部门获取员工", type = MethodType.FIND)
	public JSONReturn findEmployeesByDepartment(@RequestParam long department) {
		return employeesService.findEmployeesByDepartment(department);
	}
	
	@ResponseBody
	@RequestMapping(value = "addEmployeesEmolument")
	@SecureValid(code = "02002", desc = "保存考勤信息", type = MethodType.ADD)
	public JSONReturn addEmployeesEmolument(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesEmolument emolument = (TeEmployeesEmolument) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesEmolument.class);
		return employeesService.saveEmployeesEmolumentInfo(emolument,acctName(httpSession));
	}
	
	@ResponseBody
	@RequestMapping(value = "findEmolumentById")
	@SecureValid(code = "02002", desc = "获取考勤信息", type = MethodType.FIND)
	public JSONReturn findEmolumentById(@RequestParam long emoId) {
		
		return employeesService.findEmployeesEmolumentInfo(emoId);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "modifyEmolument")
	@SecureValid(code = "02002", desc = "修改考勤信息", type = MethodType.MODIFY)
	public JSONReturn modifyEmolument(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesEmolument emolument = (TeEmployeesEmolument) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesEmolument.class);
		return employeesService.modifyEmolumentInfo(emolument,acctName(httpSession));
	}
	
	
	@ResponseBody
	@RequestMapping(value = "deleteEmolument")
	@SecureValid(code = "02001", desc = "删除考勤信息", type = MethodType.DELETE)
	public JSONReturn deleteEmolument(@RequestParam long emoId,HttpSession httpSession) {
	
		return employeesService.deleteEmolumentInfo(emoId);
	}

}
