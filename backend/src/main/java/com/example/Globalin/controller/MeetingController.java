package com.example.Globalin.controller;

import com.example.Globalin.model.Meeting;
import com.example.Globalin.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/meeting") 
public class MeetingController {

    @Autowired
    private MeetingService meetingService;


    @GetMapping("/list")
    public List<Meeting> list() {
        System.out.println("모임 목록 요청 들어옴!"); 
        return meetingService.getMeetingList();
    }

  
    @PostMapping("/create")
    public String create(@RequestBody Meeting meeting) {
        System.out.println("새 모임 생성 요청: " + meeting.getTitle());
        meetingService.createMeeting(meeting);
        return "success";
    }

 
    @GetMapping("/{id}")
    public Meeting detail(@PathVariable("id") Long id) {
        return meetingService.getMeetingDetail(id);
    }

 
    @PostMapping("/join/{id}")
    public String join(@PathVariable("id") Long id) {
        meetingService.joinMeeting(id);
        return "joined";
    }
}