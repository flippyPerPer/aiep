package com.tensorflow.entity;

public class Tch {
	private String univName;
	private String tchNum;
	private String tchPassword;
	private String tchName;
	private String tchPhone;
	private String tchEmail;
	private int tchAge;
	private String tchIDNum;
	private int stateNumber = 0;

	public Tch() {
	}
	

	public Tch(String tchNum, String tchPassword) {
		super();
		this.tchNum = tchNum;
		this.tchPassword = tchPassword;
	}


	public Tch(String univName, String tchNum, String tchPassword, String tchName, String tchPhone, String tchEmail) {
		super();
		this.univName = univName;
		this.tchNum = tchNum;
		this.tchPassword = tchPassword;
		this.tchName = tchName;
		this.tchPhone = tchPhone;
		this.tchEmail = tchEmail;
	}
	

	public Tch(String univName, String tchNum, String tchName, String tchPhone, String tchEmail) {
		super();
		this.univName = univName;
		this.tchNum = tchNum;
		this.tchName = tchName;
		this.tchPhone = tchPhone;
		this.tchEmail = tchEmail;
	}


	public Tch(String univName, String tchNum, String tchName, String tchPhone, String tchEmail, int tchAge) {
		super();
		this.univName = univName;
		this.tchNum = tchNum;
		this.tchName = tchName;
		this.tchPhone = tchPhone;
		this.tchEmail = tchEmail;
		this.tchAge = tchAge;
	}


	public Tch(String univName, String tchNum, String tchName, String tchPhone, String tchEmail, int tchAge,
			String tchIDNum) {
		super();
		this.univName = univName;
		this.tchNum = tchNum;
		this.tchName = tchName;
		this.tchPhone = tchPhone;
		this.tchEmail = tchEmail;
		this.tchAge = tchAge;
		this.tchIDNum = tchIDNum;
	}


	public int getStateNumber() {
		return stateNumber;
	}


	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}


	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getTchNum() {
		return tchNum;
	}

	public void setTchNum(String tchNum) {
		this.tchNum = tchNum;
	}

	public String getTchPassword() {
		return tchPassword;
	}

	public void setTchPassword(String tchPassword) {
		this.tchPassword = tchPassword;
	}

	public String getTchName() {
		return tchName;
	}

	public void setTchName(String tchName) {
		this.tchName = tchName;
	}

	public String getTchPhone() {
		return tchPhone;
	}

	public void setTchPhone(String tchPhone) {
		this.tchPhone = tchPhone;
	}

	public String getTchEmail() {
		return tchEmail;
	}

	public void setTchEmail(String tchEmail) {
		this.tchEmail = tchEmail;
	}

	public int getTchAge() {
		return tchAge;
	}

	public void setTchAge(int tchAge) {
		this.tchAge = tchAge;
	}

	public String getTchIDNum() {
		return tchIDNum;
	}

	public void setTchIDNum(String tchIDNum) {
		this.tchIDNum = tchIDNum;
	}

	@Override
	public String toString() {
		return "Tch [univName=" + univName + ", tchNum=" + tchNum + ", tchPassword=" + tchPassword + ", tchName="
				+ tchName + ", tchPhone=" + tchPhone + ", tchEmail=" + tchEmail + ", tchAge=" + tchAge + ", tchIDNum="
				+ tchIDNum + "]";
	}

}
