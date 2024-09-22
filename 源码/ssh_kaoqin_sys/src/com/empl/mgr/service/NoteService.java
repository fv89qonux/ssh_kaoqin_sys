package com.empl.mgr.service;

import com.empl.mgr.dto.NoteDto;
import com.empl.mgr.support.JSONReturn;

public abstract interface NoteService {
	
	
	
	public abstract JSONReturn saveNotesInfo(NoteDto dto, String acctName);
	
	public abstract JSONReturn findNotesInfo(long id);
	
	public abstract JSONReturn modifyNotesInfo(NoteDto dto, String acctName);
	
	public abstract JSONReturn findNotesList(String value, int page);
	
	public abstract JSONReturn findNotesPage(String value, int page);
	
	public abstract JSONReturn delNote(long id, String acctName);

}
