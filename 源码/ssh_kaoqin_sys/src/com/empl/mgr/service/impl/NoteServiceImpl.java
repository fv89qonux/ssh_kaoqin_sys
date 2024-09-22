package com.empl.mgr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empl.mgr.constant.PageConstant;
import com.empl.mgr.dao.NoteDao;
import com.empl.mgr.dto.EmployeesInternshipListDto;
import com.empl.mgr.dto.NoteDto;
import com.empl.mgr.field.TeAccountField;
import com.empl.mgr.field.TeDepartmentField;
import com.empl.mgr.field.TeNoteField;
import com.empl.mgr.field.TePositionField;
import com.empl.mgr.model.TeAccount;
import com.empl.mgr.model.TeDepartment;
import com.empl.mgr.model.TeNote;
import com.empl.mgr.service.NoteService;
import com.empl.mgr.support.JSONReturn;
import com.empl.mgr.utils.CompareUtil;
import com.empl.mgr.utils.DateTimeUtil;
import com.empl.mgr.utils.PageUtils;

@Scope
@Service
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteDao noteDao;

	@Override
	@Transactional
	public JSONReturn saveNotesInfo(NoteDto dto, String acctName) {
		// TODO Auto-generated method stub
		if (CompareUtil.isEmpty(dto))
			return JSONReturn.buildFailure("公告保存失败!");
		TeNote note = new TeNote();
		note.setTitle(dto.getTitle());
		note.setContent(dto.getContent());
		note.setCreateTime(DateTimeUtil.getCurrentTime());
		note.setCreator(acctName);
		noteDao.save(note);
		return JSONReturn.buildSuccess(note.getId());
	}

	@Override
	public JSONReturn findNotesInfo(long id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TeNote note = noteDao.findUniqueByProperty(TeNoteField.ID, id);

		return JSONReturn.buildSuccess(note);
	}

	@Override
	@Transactional
	public JSONReturn modifyNotesInfo(NoteDto dto, String acctName) {
		// TODO Auto-generated method stub
		TeNote note = noteDao.findUniqueByProperty(TeNoteField.ID, dto.getId());
		note.setTitle(dto.getTitle());
		note.setContent(dto.getContent());
		note.setCreateTime(DateTimeUtil.getCurrentTime());
		noteDao.save(note);
		return JSONReturn.buildSuccess(dto.getId());
	}
	
	
	public JSONReturn findNotesList(String value, int page) {
		// TODO Auto-generated method stub
		List<NoteDto> dtoList = null;
		dtoList = noteDao.findNotesList(value,page);
		if (CollectionUtils.isEmpty(dtoList))
			return JSONReturn.buildFailure("未获取到相关数据!");
		
		return JSONReturn.buildSuccess(dtoList);
	}

	public JSONReturn findNotesPage(String value, int page) {
		// TODO Auto-generated method stub
		int count = noteDao.findNotesPage(value);
		return JSONReturn.buildSuccess(PageUtils.calculatePage(page, count, PageConstant.PAGE_LIST));
	}
	
	
	@Transactional
	public JSONReturn delNote(long id, String acctName) {
		// TODO Auto-generated method stub
		TeNote note = noteDao.findUniqueByProperty(TeNoteField.ID, id);
		if (CompareUtil.isEmpty(note))
			return JSONReturn.buildFailure("操作失败, 源数据不存在!");
		noteDao.delete(note); // 直接删除公告信息 
		return JSONReturn.buildSuccess("删除成功!");
	}

}
