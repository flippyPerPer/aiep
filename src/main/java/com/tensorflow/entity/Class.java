package com.tensorflow.entity;

public class Class {
	private String classCode;
	private String univName;
	private String className;
	private String classPicURL;
	private String classTch;

	public Class() {
	}

	public Class(String univName, String classTch, String className) {
		super();
		this.univName = univName;
		this.className = className;
		this.classTch = classTch;
	}

	public Class(String classCode, String univName, String classTch, String className) {
		super();
		this.classCode = classCode;
		this.univName = univName;
		this.className = className;
		this.classTch = classTch;
	}

	public String getClassTch() {
		return classTch;
	}

	public void setClassTch(String classTch) {
		this.classTch = classTch;
	}

	public String getClassPicURL() {
		return classPicURL;
	}

	public void setClassPicURL(String classPicURL) {
		this.classPicURL = classPicURL;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Class [classCode=" + classCode + ", univName=" + univName + ", className=" + className + "]";
	}

}
