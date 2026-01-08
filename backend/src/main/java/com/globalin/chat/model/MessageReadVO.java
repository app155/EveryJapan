package com.globalin.chat.model;

import java.sql.Timestamp;

public class MessageReadVO {
	private long readId;
	private long messageId;
	private long userId;
	private Timestamp readAt;
	
	public long getReadId() {
		return readId;
	}
	public void setReadId(long readId) {
		this.readId = readId;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Timestamp getReadAt() {
		return readAt;
	}
	public void setReadAt(Timestamp readAt) {
		this.readAt = readAt;
	}
	
	
}
