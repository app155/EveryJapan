package com.globalin.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.globalin.user.model.*;
import com.globalin.user.service.UserService_;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired UserService_ userService;
    @PostMapping("loginProc")
    public String loginProc(String email, String passwd, @RequestParam("btn") String btnValue, HttpSession session ) {
        if (btnValue.equals("login")) {
        		int result = userService.loginProcess(email, passwd);
        	
        		if (result == 1) {
        			session.setAttribute("email", email);
        			session.setAttribute("loginId", userService.getUserIdByEmail(email));
        			session.setAttribute("username", userService.getUsernameByEmail(email));
        			
    				return "redirect:main";
    			}
    		
    			else {
    				if (result == 0) {
    					// 비번틀림 띄우기
    				}
    					
    				else {
    					// 아이디없음 띄우기
    				}
    				return "redirect:testLogin";
    			}
        }
        
        else {
        		return "redirect:register";
        }
    }
    
    @GetMapping("testLogin")
    public String loginPage(HttpSession session) {
    		if (session.getAttribute("loginId") == null) {
    			return "test/testLogin";    			
    		}
    		
    		else {
    			return "redirect:main";
    		}
    }
    
    @GetMapping("main")
    public String main() {
    		return "test/main";
    }
    
    @GetMapping("register")
    public String register() {
    		return "test/register";
    }
    
    @PostMapping("registerProc")
    public String registerProc(String email, String password, String username, String university, String grade, String major, String studentId) {
    		if (userService.insert(email, password, username, university, grade, major, studentId)) {
    			return "redirect:main";
    		}
    		
    		return "asdf";
    }
}
