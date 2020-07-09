package com.tensorflow.entity;

public class Comment {
	private String commentNum;
	private String commentDetails;
	private String commentToNum;
	private String commentTime;
	
	public Comment() {
	}

	public Comment(String commentNum, String commentDetails, String commentToNum, String commentTime) {
		super();
		this.commentNum = commentNum;
		this.commentDetails = commentDetails;
		this.commentToNum = commentToNum;
		this.commentTime = commentTime;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public String getCommentToNum() {
		return commentToNum;
	}

	public void setCommentToNum(String commentToNum) {
		this.commentToNum = commentToNum;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", commentDetails=" + commentDetails + ", commentToNum="
				+ commentToNum + ", commentTime=" + commentTime + "]";
	}
	
	
}
