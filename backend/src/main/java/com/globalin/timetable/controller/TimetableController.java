package com.globalin.timetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globalin.timetable.service.TimetableService;

@Controller
@RequestMapping("/timetable")
public class TimetableController {
	@Autowired
	TimetableService timetableService;
}
