package com.globalin.timetable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globalin.timetable.model.TimetableVO;
import com.globalin.timetable.service.TimetableService;

@Controller
@RequestMapping("/timetable")
public class TimetableController {
	@Autowired
	TimetableService timetableService;
	
	@GetMapping("main")
	public String timetableMain(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long loginId = (Long)session.getAttribute("loginId");
		String username = (String)session.getAttribute("username");
		List<TimetableVO> tables = timetableService.getTables(loginId);
		
		request.setAttribute("tables", tables);
		
		return "timetable/main";
	}
	
	@GetMapping("createTimetable")
	public String createTimetable(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long loginId = (Long)request.getAttribute("loginId");
		
		timetableService.addTable(loginId);
		
		return "timetable/main";
	}
}
