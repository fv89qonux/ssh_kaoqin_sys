package com.empl.mgr.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.empl.mgr.constant.PageConstant;
import com.empl.mgr.dao.support.AbstractDao;
import com.empl.mgr.dto.EmployeesRewardDto;
import com.empl.mgr.model.TeEmployeesReward;

@Repository
public class EmployeesRewardDao extends AbstractDao<TeEmployeesReward>{

	@Override
	public Class<TeEmployeesReward> getEntityClass() {
		// TODO Auto-generated method stub
		return TeEmployeesReward.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeesRewardDto> findEmployeesRewardList(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select new com.empl.mgr.dto.EmployeesRewardDto");
		query.append("(reward.id, basic.emId, basic.emFullName,basic.emState,basic.emDeparemtn,dept.deptName,po.poName, basic.emIdentity,reward.type,reward.title,reward.amount,reward.content,reward.creator,reward.createTime,reward.timestamp) ");
		query.append("from TeEmployeesReward reward,TeEmployeesBasic basic,TeDepartment dept,TePosition po where reward.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
		query.append(department > 0 ? " and basic.emDeparemtn =  " + department : "");
		query.append(position > 0 ? " and basic.emPosition = " + position : "");
		query.append(emplType > 0 ? " and basic.emState = " + emplType : "");
		query.append(serType == 1 && StringUtils.isNotEmpty(serVal) ? " and basic.emFullName like '%" + serVal + "%' " : "");
		query.append(serType == 2 && StringUtils.isNotEmpty(serVal) ? " and basic.emIdentity like '%" + serVal + "%' " : "");
		query.append(" order by reward.id desc ");
		return findSession().createQuery(query.toString()).setFirstResult((page - 1) * PageConstant.PAGE_LIST)
				.setMaxResults(PageConstant.PAGE_LIST).list();
	}

	public int findEmployeesRewardCount(int serType, String serVal,long department,  long position,  int page, String accName, int emplType) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select count(reward.id)");
		query.append("from TeEmployeesReward reward,TeEmployeesBasic basic,TeDepartment dept,TePosition po where reward.emId = basic.emId and basic.emDeparemtn = dept.deptId and basic.emDeparemtn = po.poDepartment and basic.emPosition = po.poId");
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
