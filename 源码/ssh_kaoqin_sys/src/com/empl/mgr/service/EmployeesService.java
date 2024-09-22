package com.empl.mgr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.empl.mgr.dto.EmployeesInfoDto;
import com.empl.mgr.model.TeEmployeesAttendance;
import com.empl.mgr.model.TeEmployeesEmolument;
import com.empl.mgr.model.TeEmployeesReward;
import com.empl.mgr.support.JSONReturn;

public abstract interface EmployeesService {

	public abstract JSONReturn findChoose();

	public abstract JSONReturn saveEmployeesInfo(EmployeesInfoDto dto, String acctName);

	public abstract JSONReturn findEmployeesList(int serType, String serVal, long department, long position, int page,
			String acctName, int... emplType);

	public abstract JSONReturn findEmployeesPage(int serType, String serVal, long department, long position, int page,
			String acctName, int... emplType);

	public abstract JSONReturn enroll(long emId, String acctName);

	public abstract JSONReturn eliminate(long emId, String note, String string);

	public abstract JSONReturn findEmployeesInfo(long emplId);

	public abstract JSONReturn modifyEmployeesInfo(EmployeesInfoDto dto, String acctName);

	public abstract JSONReturn departure(long id, String note, String acctName);

	public abstract JSONReturn findTrainingRecord(long emplId, String acctName);

	public abstract JSONReturn findEmployeesList(long trainingId, long deptId, String searchVal, String acctName);

	public abstract JSONReturn addAllTraining(long trainingId, long deptId, String searchVal, String acctName);

	public abstract JSONReturn destroy(long emplId, String acctName);

	public abstract JSONReturn findDepartureNote(long emplId, String acctName);

	public abstract JSONReturn enrollEmployees(long emplId, String note, String acctName);

	public abstract JSONReturn uploadImg(MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public abstract JSONReturn findEmployeesRecord(long emplId);
	
	//考勤模块
	public abstract JSONReturn findEmployeesAttendanceList(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);
	
	public abstract JSONReturn findEmployeesAttendanceCount(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);
	
	
	public abstract JSONReturn findEmployeesByDepartment(long department);
	
	public abstract JSONReturn saveEmployeesAttendanceInfo(TeEmployeesAttendance attendance,String acctName);
	
	public abstract JSONReturn findEmployeesAttendanceInfo(long attenId);
	
	public abstract JSONReturn modifyAttendanceInfo( TeEmployeesAttendance attendance, String acctName);
	
	public abstract JSONReturn deleteAttendanceInfo(long attenId);
	
	
	
	//薪酬模块
	public abstract JSONReturn findEmployeesEmolumentList(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);
	
	public abstract JSONReturn findEmployeesEmolumentCount(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);

		
	public abstract JSONReturn saveEmployeesEmolumentInfo(TeEmployeesEmolument emolument,String acctName);
	
	public abstract JSONReturn findEmployeesEmolumentInfo(long attenId);
	
	public abstract JSONReturn modifyEmolumentInfo( TeEmployeesEmolument emolument, String acctName);
	
	public abstract JSONReturn deleteEmolumentInfo(long attenId);
	
	
	
	//奖惩模块
	public abstract JSONReturn findEmployeesRewardList(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);
	
	public abstract JSONReturn findEmployeesRewardCount(int serType, String serVal, long department, long position, int page,
			String acctName, int emplType);
	
	public abstract JSONReturn saveEmployeesRewardInfo(TeEmployeesReward reward,String acctName);
	
	public abstract JSONReturn findEmployeesRewardInfo(long id);
	
	public abstract JSONReturn modifyRewardInfo( TeEmployeesReward reward, String acctName);
	
	public abstract JSONReturn deleteRewardInfo(long id);
	
	
	
	

}
