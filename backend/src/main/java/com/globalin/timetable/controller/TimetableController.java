package com.globalin.timetable.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globalin.timetable.model.SubjectVO;
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
	
	@PostMapping("main")
	public String createTimetable(long loginId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		int count = timetableService.getTableCount(loginId);
		timetableService.addTable(loginId, "시간표" + (count + 1));
		
		return "redirect:/timetable/main";
	}
	
	@GetMapping("/subjects")
	@ResponseBody
	public List<SubjectVO> getAllSubjects() {
		return timetableService.getAllSubjects();
	}
	
	@GetMapping("/{timetableId}/subjects")
	@ResponseBody
	public List<SubjectVO> getSubjectsInTimetable(@PathVariable long timetableId) {
		return timetableService.getSubjectsInTimetable(timetableId);
	}
	
	@PostMapping("/{timetableId}/subject")
	@ResponseBody
	public Map<String, Object> addSubjectToTimeTable(@PathVariable("timetableId") long timetableId, @RequestBody Map<String, Long> request) {
		Long subjectId = request.get("subjectId");
		
	    System.out.println("받은 데이터: " + request);
		
		try {
			timetableService.addSubjectToTimeTable(timetableId, subjectId);
			Map<String, Object> result = new HashMap<>(); 
			result.put("success", true);
			result.put("message", "추가 성공");
			return result;
		}
		catch (DuplicateKeyException e) {
			Map<String, Object> result = new HashMap<>(); 
			result.put("success", false);
			result.put("message", "이미 추가된 과목");
			return result;
	    } 
		catch (Exception e) {
	        Map<String, Object> result = new HashMap<>(); 
			result.put("success", false);
			result.put("message", "추가 실패");
			return result;
	    }
	}
	
	@PostMapping("/{timetableId}/delSubject")
	@ResponseBody
	public Map<String, Object> deleteSubjectToTimeTable(@PathVariable("timetableId") long timetableId, @RequestBody Map<String, Long> request) {
		Long subjectId = request.get("subjectId");
		
	    System.out.println("받은 데이터: " + request);
		
		try {
			timetableService.deleteSubjectToTimeTable(timetableId, subjectId);
			Map<String, Object> result = new HashMap<>(); 
			result.put("success", true);
			result.put("message", "삭제 성공");
			return result;
		}
		catch (Exception e) {
	        Map<String, Object> result = new HashMap<>(); 
			result.put("success", false);
			result.put("message", "삭제 실패");
			return result;
	    }
	}
}
