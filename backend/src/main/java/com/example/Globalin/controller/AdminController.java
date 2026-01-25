package com.example.Globalin.controller;

import com.example.Globalin.model.User;
import com.example.Globalin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/users")
	public List<User> list() {
		System.out.println("관리자: 회원 목록 요청");
		return adminService.getUserList();
	}

	@PostMapping("/ban/{id}")
	public String ban(@PathVariable("id") Long id) {
		System.out.println("관리자: 회원 번호 " + id + "번 강퇴 요청");
		adminService.banUser(id);
		return "banned";
	}
}