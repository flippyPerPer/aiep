package com.tensorflow.service;

import java.sql.SQLException;

import com.tensorflow.entity.User;

public interface UserService {
	public boolean addOneUser(User user);
	public String checkUser(User user) throws SQLException;
	public User userSign(String UserName) throws SQLException;
}
