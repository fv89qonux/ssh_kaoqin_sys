package com.empl.mgr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empl.mgr.annotation.SecureValid;
import com.empl.mgr.constant.MethodType;
import com.empl.mgr.controller.support.AbstractController;
import com.empl.mgr.model.TeEmployeesReward;
import com.empl.mgr.service.EmployeesService;
import com.empl.mgr.support.JSONReturn;

import net.sf.json.JSONObject;

@Scope
@Controller
@RequestMapping(value = "employees/reward")
public class EmployeesRewardController extends AbstractController{
	
	@Autowired
	private EmployeesService employeesService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesRewardList")
	@SecureValid(code = "01005", desc = "获取奖惩列表", type = MethodType.FIND)
	public JSONReturn findEmployeesRewardList(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesRewardList(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}

	@ResponseBody
	@RequestMapping(value = "findEmployeesRewardCount")
	@SecureValid(code = "01005", desc = "获取奖惩分页", type = MethodType.FIND)
	public JSONReturn findEmployeesRewardCount(@RequestParam int serType, @RequestParam String serVal,
			@RequestParam long department, @RequestParam long position, @RequestParam int page, HttpSession httpSession,@RequestParam int emplType) {
		return employeesService.findEmployeesRewardCount(serType, serVal, department, position, page, acctName(httpSession), emplType);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "findEmployeesByDepartment")
	@SecureValid(code = "01005", desc = "根据部门获取员工", type = MethodType.FIND)
	public JSONReturn findEmployeesByDepartment(@RequestParam long department) {
		return employeesService.findEmployeesByDepartment(department);
	}
	
	@ResponseBody
	@RequestMapping(value = "addEmployeesReward")
	@SecureValid(code = "01005", desc = "保存考勤信息", type = MethodType.ADD)
	public JSONReturn addEmployeesReward(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesReward reward = (TeEmployeesReward) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesReward.class);
		return employeesService.saveEmployeesRewardInfo(reward,acctName(httpSession));
	}
	
	@ResponseBody
	@RequestMapping(value = "findRewardById")
	@SecureValid(code = "01005", desc = "获取奖惩信息", type = MethodType.FIND)
	public JSONReturn findRewardById(@RequestParam long id) {
		
		return employeesService.findEmployeesRewardInfo(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "modifyReward")
	@SecureValid(code = "01005", desc = "修改奖惩信息", type = MethodType.MODIFY)
	public JSONReturn modifyReward(@RequestParam String data,HttpSession httpSession) {
		
		TeEmployeesReward reward = (TeEmployeesReward) JSONObject
				.toBean(JSONObject.fromObject(data), TeEmployeesReward.class);
		return employeesService.modifyRewardInfo(reward,acctName(httpSession));
	}
	
	
	@ResponseBody
	@RequestMapping(value = "deleteReward")
	@SecureValid(code = "01005", desc = "删除奖惩信息", type = MethodType.DELETE)
	public JSONReturn deleteReward(@RequestParam long id,HttpSession httpSession) {
	
		return employeesService.deleteRewardInfo(id);
	}

}
