package com.globalin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class TestController {
	
    @PostMapping("loginProc")
    public String loginProc(String id, String passwd, @RequestParam("btn") String btnValue ) {
        if (btnValue.equals("login")) {
        		// TODO: id, passwd 체크 로직 (나중에)
        		if (id.equals("test") && passwd.equals("1234")) {
    				return "redirect:main";
    			}
    		
    			else {
    				return "redirect:testLogin";
    			}
        }
        
        else {
        		return "redirect:register";
        }
    }
    
    @GetMapping("/testLogin")
    public String login() {
   	 	return "test/testLogin";
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
    		if (UserDAO.getInstance().insert(email, password, username, university, Integer.parseInt(grade), major, studentId)) {
    			return "redirect:main";
    		}
    		
    		return "asdf";
    }
}
