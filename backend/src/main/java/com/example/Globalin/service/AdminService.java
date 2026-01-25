package com.example.Globalin.service;

import com.example.Globalin.dao.AdminDao;
import com.example.Globalin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public List<User> getUserList() {
		return adminDao.selectAllUsers();
	}

	public void banUser(Long userId) {
		adminDao.deleteUser(userId);
	}
}