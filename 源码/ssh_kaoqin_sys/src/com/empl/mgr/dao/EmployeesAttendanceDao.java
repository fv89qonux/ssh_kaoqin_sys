package com.empl.mgr.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.empl.mgr.constant.PageConstant;
import com.empl.mgr.dao.support.AbstractDao;
import com.empl.mgr.dto.EmployeesAttendanceDto;
import com.empl.mgr.dto.EmployeesInternshipListDto;
import com.empl.mgr.model.TeAccount;
import com.empl.mgr.model.TeEmployeesAttendance;

@Repository
public class EmployeesAttendanceDao extends AbstractDao<TeEmployeesAttendance>{

	@Override
	public Class<TeEmployeesAttendance> getEntityClass() {
		// TODO Auto-generated method stub
		return TeEmployeesAttendance.class;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeesAttendanceDto> findEmployeesAttendanceList(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select new com.empl.mgr.dto.EmployeesAttendanceDto");
		query.append("(atte.attenId, basic.emId, basic.emFullName,basic.emState,basic.emDeparemtn,dept.deptName,po.poName, basic.emIdentity,atte.atteTime,atte.morning,atte.afternoon,atte.timestamp) ");
		query.append("from TeEmployeesAttendance atte,TeEmployeesBasic basic,TeDepartment dept,TePosition po where atte.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
		query.append(department > 0 ? " and basic.emDeparemtn =  " + department : "");
		query.append(position > 0 ? " and basic.emPosition = " + position : "");
		query.append(emplType > 0 ? " and basic.emState = " + emplType : "");
		query.append(serType == 1 && StringUtils.isNotEmpty(serVal) ? " and basic.emFullName like '%" + serVal + "%' " : "");
		query.append(serType == 2 && StringUtils.isNotEmpty(serVal) ? " and basic.emIdentity like '%" + serVal + "%' " : "");
		query.append(" order by basic.emId desc ");
		return findSession().createQuery(query.toString()).setFirstResult((page - 1) * PageConstant.PAGE_LIST)
				.setMaxResults(PageConstant.PAGE_LIST).list();
	}

	public int findEmployeesAttendanceCount(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select count(atte.attenId)");
		query.append("from TeEmployeesAttendance atte,TeEmployeesBasic basic,TeDepartment dept,TePosition po where atte.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
		query.append(department > 0 ? " and basic.emDeparemtn =  " + department : "");
		query.append(position > 0 ? " and basic.emPosition = " + position : "");
		query.append(emplType > 0 ? " and basic.emState = " + emplType : "");
		query.append(serType == 1 && StringUtils.isNotEmpty(serVal) ? " and basic.emFullName like '%" + serVal + "%' " : "");
		query.append(serType == 2 && StringUtils.isNotEmpty(serVal) ? " and basic.emIdentity like '%" + serVal + "%' " : "");
		return Integer.parseInt(findSession().createQuery(query.toString()).uniqueResult().toString());
	}
	
	
	private String pack(int... type) {
		String result = "";
		for (int key : type)
			result += key + ",";
		return StringUtils.isEmpty(result) ? "" : result.substring(0, result.length() - 1);
	}
	

}
