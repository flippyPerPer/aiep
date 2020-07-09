package com.tensorflow.entity;

public class StuInClass {
	private String classCode;
	private String stuNum;
	private String univName;

	public StuInClass() {
	}

	public StuInClass(String classCode, String stuNum, String univName) {
		super();
		this.classCode = classCode;
		this.stuNum = stuNum;
		this.univName = univName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	@Override
	public String toString() {
		return "StuInClass [classCode=" + classCode + ", stuNum=" + stuNum + ", univName=" + univName + "]";
	}
	
	
}
