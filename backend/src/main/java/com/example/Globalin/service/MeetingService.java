package com.example.Globalin.service;

import com.example.Globalin.dao.MeetingDao;
import com.example.Globalin.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MeetingService {

	@Autowired
	private MeetingDao meetingDao;

	public List<Meeting> getMeetingList() {
		return meetingDao.selectAllMeetings();
	}

	public void createMeeting(Meeting meeting) {

		meetingDao.insertMeeting(meeting);
	}

	public Meeting getMeetingDetail(Long meetingId) {
		return meetingDao.selectMeetingById(meetingId);
	}

	public void joinMeeting(Long meetingId) {
		meetingDao.updateMemberCount(meetingId);
	}
}