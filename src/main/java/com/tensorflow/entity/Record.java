package com.tensorflow.entity;

public class Record {
	private String expID;
	private String recordNum;
//	private String expComplete;
//	private String expScore;
//	private String expCompiler;
	private String expTime;
	
	public Record() {
	}

	public Record(String expID, String recordNum, String expTime) {
		super();
		this.expID = expID;
		this.recordNum = recordNum;
		this.expTime = expTime;
	}

//	public Record(String expID, String recordNum, String expComplete, String expScore, String expCompiler,
//			String expTime) {
//		super();
//		this.expID = expID;
//		this.recordNum = recordNum;
//		this.expComplete = expComplete;
//		this.expScore = expScore;
//		this.expCompiler = expCompiler;
//		this.expTime = expTime;
//	}

	public String getExpID() {
		return expID;
	}

	public void setExpID(String expID) {
		this.expID = expID;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

//	public String getExpComplete() {
//		return expComplete;
//	}
//
//	public void setExpComplete(String expComplete) {
//		this.expComplete = expComplete;
//	}
//
//	public String getExpScore() {
//		return expScore;
//	}
//
//	public void setExpScore(String expScore) {
//		this.expScore = expScore;
//	}
//
//	public String getExpCompiler() {
//		return expCompiler;
//	}
//
//	public void setExpCompiler(String expCompiler) {
//		this.expCompiler = expCompiler;
//	}

	public String getExpTime() {
		return expTime;
	}

	public void setExpTime(String expTime) {
		this.expTime = expTime;
	}

	@Override
	public String toString() {
		return "Record [expID=" + expID + ", recordNum=" + recordNum + ", expTime=" + expTime + "]";
	}

//	public String toString() {
//		return "Record [expID=" + expID + ", recordNum=" + recordNum + ", expComplete=" + expComplete + ", expScore="
//				+ expScore + ", expCompiler=" + expCompiler + ", expTime=" + expTime + "]";
//	}
	
	
}
