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
import com.empl.mgr.dto.NoteDto;
import com.empl.mgr.service.NoteService;
import com.empl.mgr.support.JSONReturn;

import net.sf.json.JSONObject;

@Scope
@Controller
@RequestMapping(value = "note")
public class NoteController extends AbstractController{
	
	@Autowired
	private NoteService noteService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "saveNotesInfo")
	@SecureValid(code = "05001", desc = "保存公告信息", type = MethodType.ADD)
	public JSONReturn saveNotesInfo(@RequestParam String data, HttpSession httpSession) {
		NoteDto dto = (NoteDto) JSONObject
				.toBean(JSONObject.fromObject(data), NoteDto.class);
		return noteService.saveNotesInfo(dto, acctName(httpSession));
	}
	
	
	@ResponseBody
	@RequestMapping(value = "findNotesInfo")
	@SecureValid(code = { "05001",}, desc = "获取公告信息", type = MethodType.FIND)
	public JSONReturn findEmployeesInfo(@RequestParam long id) {
		return noteService.findNotesInfo(id);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "modifyNotesInfo")
	@SecureValid(code = { "05001"}, desc = "修改公告信息", type = MethodType.MODIFY)
	public JSONReturn modifyEmployeesInfo(@RequestParam String data, HttpSession httpSession) {
		NoteDto dto = (NoteDto) JSONObject
				.toBean(JSONObject.fromObject(data), NoteDto.class);
		return noteService.modifyNotesInfo(dto, acctName(httpSession));
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "findNotesList")
	@SecureValid(code = "05001", desc = "获取公告列表信息", type = MethodType.FIND)
	public JSONReturn findNotesList(@RequestParam String serVal, @RequestParam int page, HttpSession httpSession) {
		return noteService.findNotesList(serVal, page);
	}

	@ResponseBody
	@RequestMapping(value = "findNotesPage")
	@SecureValid(code = "05001", desc = "获取实习员工分页", type = MethodType.FIND)
	public JSONReturn findNotesPage(@RequestParam String serVal, @RequestParam int page, HttpSession httpSession) {
		return noteService.findNotesPage(serVal,page);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "delNote")
	@SecureValid(code = "04001", desc = "删除公告信息", type = MethodType.DELETE)
	public JSONReturn delNote(@RequestParam long id, HttpSession httpSession) {
		return noteService.delNote(id, acctName(httpSession));
	}

}
