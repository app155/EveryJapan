package com.globalin.chat.model;

import java.sql.Timestamp;

public class ChatMemberVO {
	private long memberId;
	private long roomId;
	private long userId;
    private Timestamp lastReadAt;
    private boolean notificationEnabled;
    private Timestamp joinedAt;
    private String nickname;
    
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Timestamp getLastReadAt() {
		return lastReadAt;
	}
	public void setLastReadAt(Timestamp lastReadAt) {
		this.lastReadAt = lastReadAt;
	}
	public boolean isNotificationEnabled() {
		return notificationEnabled;
	}
	public void setNotificationEnabled(boolean notificationEnabled) {
		this.notificationEnabled = notificationEnabled;
	}
	public Timestamp getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(Timestamp joinedAt) {
		this.joinedAt = joinedAt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
