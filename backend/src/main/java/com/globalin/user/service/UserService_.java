package com.globalin.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.user.model.UserDAO;

@Service
public class UserService_ {
	@Autowired private UserDAO userDAO;
	
	public int loginProcess(String email, String passwd) {
		return userDAO.loginProcess(email, passwd);
	}
	
	public long getUserIdByEmail(String email) {
		return userDAO.getUserIdByEmail(email);
	}
	
	public String getUsernameByEmail(String email) {
		return userDAO.getUsernameByEmail(email);
	}
	
	public boolean insert(String email, String password, String username, String university, String grade, String major, String studentId) {
		return userDAO.insert(email, password, username, university, Integer.parseInt(grade), major, studentId);
	}
}
