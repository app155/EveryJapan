package com.example.Globalin.service;

import com.example.Globalin.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserProfile getUserProfile(String userId) {
        // TODO: 실제 데이터베이스 연동 시 구현
        // 임시로 목 데이터 반환
        UserProfile profile = new UserProfile();
        profile.setId(1L);
        profile.setUsername("student123");
        profile.setEmail("student@example.com");
        profile.setNickname("유학생");
        profile.setPostCount(15);
        profile.setCommentCount(42);
        profile.setJoinDate(new java.util.Date());

        return profile;
    }
}
