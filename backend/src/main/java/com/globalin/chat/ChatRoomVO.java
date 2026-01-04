package com.globalin.chat;

import java.sql.Timestamp;

public class ChatRoomVO {
	private long roomId;
	private boolean isAnonymous;
	private Timestamp lastMessageAt;
	private Timestamp createAt;
	private String roomName;
	private RoomType roomType;
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public boolean isAnonymous() {
		return isAnonymous;
	}
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public Timestamp getLastMessageAt() {
		return lastMessageAt;
	}
	public void setLastMessageAt(Timestamp lastMessageAt) {
		this.lastMessageAt = lastMessageAt;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
