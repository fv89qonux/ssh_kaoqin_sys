package com.empl.mgr.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.empl.mgr.constant.PageConstant;
import com.empl.mgr.dao.support.AbstractDao;
import com.empl.mgr.dto.EmployeesInternshipListDto;
import com.empl.mgr.dto.NoteDto;
import com.empl.mgr.model.TeNote;

@Repository
public class NoteDao extends AbstractDao<TeNote> {

	@Override
	public Class<TeNote> getEntityClass() {
		// TODO Auto-generated method stub
		return TeNote.class;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<NoteDto> findNotesList(String value, int page) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select new com.empl.mgr.dto.NoteDto");
		query.append("(note.id, note.title, note.content, note.creator, note.createTime) ");
		query.append("from TeNote note where 1=1");
		query.append(StringUtils.isNotEmpty(value) ? " and note.title like '%" + value + "%' " : "");
		query.append(" order by note.createTime desc ");
		return findSession().createQuery(query.toString()).setFirstResult((page - 1) * PageConstant.PAGE_LIST)
				.setMaxResults(PageConstant.PAGE_LIST).list();
	}

	public int findNotesPage(String value) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select count(id) from TeNote note where 1=1");
		query.append(StringUtils.isNotEmpty(value) ? " and note.title like '%" + value + "%' " : "");
		return Integer.parseInt(findSession().createQuery(query.toString()).uniqueResult().toString());
	}
	
	

}
