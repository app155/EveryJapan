package com.globalin.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.timetable.model.TimetableDAO;

@Service
public class TimetableService {
	@Autowired
	TimetableDAO timetableDAO;
}
