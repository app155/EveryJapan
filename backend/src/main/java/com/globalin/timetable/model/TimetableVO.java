package com.globalin.timetable.model;

import java.util.List;

public class TimetableVO {
	private long timetableId;
	private long userId;
	private String name;
	private String semester;
	private List<SubjectVO> subjects;
	
	public long getTimetableId() {
		return timetableId;
	}
	public void setTimetableId(long timetableId) {
		this.timetableId = timetableId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public List<SubjectVO> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectVO> subjects) {
		this.subjects = subjects;
	}
	
}
