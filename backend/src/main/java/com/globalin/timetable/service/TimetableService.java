package com.globalin.timetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.timetable.model.TimetableDAO;
import com.globalin.timetable.model.TimetableVO;

@Service
public class TimetableService {
	@Autowired
	TimetableDAO timetableDAO;
	
	public int getTableCount(long userId) {
		System.out.println("아이디 !!!!!!!!!!!!: " + userId);
		
		return timetableDAO.getTablesCount(userId);
	}
	
	public List<TimetableVO> getTables(long userId) {
		return timetableDAO.getTimetables(userId);
	}
	
	public void addTable(long userId, String name) {
		timetableDAO.insert(userId, name);
	}
	
	public void deleteTable(long tableId) {
		timetableDAO.delete(tableId);
	}
	
	public void updateTable(long tableId, String name) {
		timetableDAO.update(tableId, name);
	}
}
