package com.tensorflow.entity;

public class Work {
	private String tchNum;
	private String classCode;
	private String workName;
	private String workInfo;
	private String expID;
	private String expType;
	private String startTime;
	private String endTime;
	
	public Work() {
	}

	public Work(String tchNum, String classCode, String expID) {
		super();
		this.tchNum = tchNum;
		this.classCode = classCode;
		this.expID = expID;
	}

	public Work(String tchNum, String classCode, String expID, String endTime) {
		super();
		this.tchNum = tchNum;
		this.classCode = classCode;
		this.expID = expID;
		this.endTime = endTime;
	}

	public Work(String workName, String expID, String classCode, String startTime, String endTime) {
		super();
		this.workName = workName;
		this.classCode = classCode;
		this.expID = expID;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getTchNum() {
		return tchNum;
	}

	public void setTchNum(String tchNum) {
		this.tchNum = tchNum;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getExpID() {
		return expID;
	}

	public void setExpID(String expID) {
		this.expID = expID;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "work [tchNum=" + tchNum + ", classCode=" + classCode + ", expID=" + expID + ", expType=" + expType
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
