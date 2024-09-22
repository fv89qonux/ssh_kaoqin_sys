package com.empl.mgr.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.empl.mgr.constant.PageConstant;
import com.empl.mgr.dao.support.AbstractDao;
import com.empl.mgr.dto.EmployeesEmolumentDto;
import com.empl.mgr.model.TeEmployeesEmolument;
import com.empl.mgr.model.TeEmployeesEmolument;

@Repository
public class EmployeesEmolumentDao extends AbstractDao<TeEmployeesEmolument>{

	@Override
	public Class<TeEmployeesEmolument> getEntityClass() {
		// TODO Auto-generated method stub
		return TeEmployeesEmolument.class;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeesEmolumentDto> findEmployeesEmolumentList(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select new com.empl.mgr.dto.EmployeesEmolumentDto");
		query.append("(emo.emoId,emo.emId,basic.emFullName,basic.emState,basic.emDeparemtn,dept.deptName,po.poName, basic.emIdentity,emo.salary,emo.timestamp) ");
		query.append("from TeEmployeesEmolument emo,TeEmployeesBasic basic,TeDepartment dept,TePosition po where emo.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
		query.append(department > 0 ? " and basic.emDeparemtn =  " + department : "");
		query.append(position > 0 ? " and basic.emPosition = " + position : "");
		query.append(emplType > 0 ? " and basic.emState = " + emplType : "");
		query.append(serType == 1 && StringUtils.isNotEmpty(serVal) ? " and basic.emFullName like '%" + serVal + "%' " : "");
		query.append(serType == 2 && StringUtils.isNotEmpty(serVal) ? " and basic.emIdentity like '%" + serVal + "%' " : "");
		query.append(" order by emo.createTime desc ");
		return findSession().createQuery(query.toString()).setFirstResult((page - 1) * PageConstant.PAGE_LIST)
				.setMaxResults(PageConstant.PAGE_LIST).list();
	}

	public int findEmployeesEmolumentCount(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select count(emo.emId)");
		query.append("from TeEmployeesEmolument emo,TeEmployeesBasic basic,TeDepartment dept,TePosition po where emo.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
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
