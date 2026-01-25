package com.example.Globalin.dao;

import com.example.Globalin.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDao {

	List<User> selectAllUsers();

	void deleteUser(@Param("userId") Long userId);
}