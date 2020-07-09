package com.tensorflow.entity;

public class User {
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private int stateNumber = 0;

	public User() {

	}

	public User(String userName, String userPassword) {
		super();
		this.userPassword = userPassword;
		this.userName = userName;
	}
	
	public User(String userName, String userPhone, String userEmail) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	public User(String userName, String userPassWord, String userPhone, String userEmail) {
		super();
		this.userName = userName;
		this.userPassword = userPassWord;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	
	public int getStateNumber() {
		return stateNumber;
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String phone) {
		this.userPhone = phone;
	}

	public void setUserEmail() {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {

		return userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userPassword=" + userPassword + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + "]";
	}

}
