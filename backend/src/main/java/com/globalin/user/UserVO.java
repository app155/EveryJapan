package com.globalin.user;

import java.sql.Timestamp;

public class UserVO {
	private long userId;
	private long university;
	private int grade;
	private boolean emailVerificated;
	private Timestamp createdAt;
	private Timestamp lastLoginAt;
	private String email;
	private String password;
	private String username;
	private String major;
	private String studentId;
	private String profileImage;
	private String status;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUniversity() {
		return university;
	}
	public void setUniversity(long university) {
		this.university = university;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public boolean isEmailVerificated() {
		return emailVerificated;
	}
	public void setEmailVerificated(boolean emailVerificated) {
		this.emailVerificated = emailVerificated;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getLastLoginAt() {
		return lastLoginAt;
	}
	public void setLastLoginAt(Timestamp lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
