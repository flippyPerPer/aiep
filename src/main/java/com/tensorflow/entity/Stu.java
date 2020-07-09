package com.tensorflow.entity;

public class Stu {
	private String univName;
	private String stuNum;
	private String stuPassword;
	private String stuName;
	private String stuPhone;
	private String stuEmail;
	private int stuAge;
	private String stuIDNum;
	private int stateNumber = 0;

	public Stu() {
	}
	
	public Stu(String stuNum,String stuPassword) {
		super();
		this.stuNum = stuNum;
		this.stuPassword = stuPassword;
	}

	public Stu(String univName, String stuNum, String stuPassword, String stuName, String stuPhone, String stuEmail) {
		super();
		this.univName = univName;
		this.stuNum = stuNum;
		this.stuPassword = stuPassword;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuEmail = stuEmail;
	}
	
	public Stu(String univName, String stuNum, String stuName, String stuPhone, String stuEmail) {
		super();
		this.univName = univName;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuEmail = stuEmail;
	}

	

	public Stu(String univName, String stuNum, String stuName, String stuPhone, String stuEmail, int stuAge) {
		super();
		this.univName = univName;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.stuEmail = stuEmail;
		this.stuAge = stuAge;
	}	


	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuIDNum() {
		return stuIDNum;
	}

	public void setStuIDNum(String stuIDNum) {
		this.stuIDNum = stuIDNum;
	}

	public int getStateNumber() {
		return stateNumber;
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	@Override
	public String toString() {
		return "Stu [univName=" + univName + ", stuNum=" + stuNum + ", stuPassword=" + stuPassword + ", stuName="
				+ stuName + ", stuPhone=" + stuPhone + ", stuEmail=" + stuEmail + ", stuAge=" + stuAge + ", stuIDNum="
				+ stuIDNum + "]";
	}
	
	

}
