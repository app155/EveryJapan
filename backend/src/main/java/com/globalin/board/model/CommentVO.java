package com.globalin.board.model;

import java.sql.Timestamp;

public class CommentVO {
	private long commentId;
	private long postId;
	private long userId;
	private String content;
	private boolean isAnonymous;
	private long parentCommentId;
	private Timestamp createdAt;
	
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isAnonymous() {
		return isAnonymous;
	}
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
