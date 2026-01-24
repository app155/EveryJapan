package com.globalin.timetable.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.globalin.timetable.model.SubjectDAO;
import com.globalin.timetable.model.SubjectVO;
import com.globalin.timetable.model.TimetableDAO;
import com.globalin.timetable.model.TimetableVO;

@Service
public class TimetableService {
	@Autowired
	private TimetableDAO timetableDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	
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
	
	public List<SubjectVO> getSubjectsInTimetable(long timetableId) {
		return subjectDAO.getAllSubjectsInTimetable(timetableId);
	}
	
	public List<SubjectVO> getAllSubjects() {
		return subjectDAO.getAllSubjects();
	}
	
	public void addSubjectToTimeTable(long timetableId, long subjectId) {
		timetableDAO.addSubjectToTimeTable(timetableId, subjectId);
	}
}
