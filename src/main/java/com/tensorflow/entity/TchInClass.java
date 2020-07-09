package com.tensorflow.entity;

public class TchInClass {
	private String classCode;
	private String tchNum;
	private String univName;
	
	public TchInClass() {
	}

	public TchInClass(String classCode, String tchNum, String univName) {
		super();
		this.classCode = classCode;
		this.tchNum = tchNum;
		this.univName = univName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getTchNum() {
		return tchNum;
	}

	public void setTchNum(String tchNum) {
		this.tchNum = tchNum;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	@Override
	public String toString() {
		return "TchInClass [classCode=" + classCode + ", tchNum=" + tchNum + ", univName=" + univName + "]";
	}
	
	
}
