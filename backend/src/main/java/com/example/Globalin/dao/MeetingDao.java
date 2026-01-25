package com.example.Globalin.dao;

import com.example.Globalin.model.Meeting;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MeetingDao {

	void insertMeeting(Meeting meeting);

	List<Meeting> selectAllMeetings();

	Meeting selectMeetingById(@Param("meetingId") Long meetingId);

	void updateMemberCount(@Param("meetingId") Long meetingId);
}