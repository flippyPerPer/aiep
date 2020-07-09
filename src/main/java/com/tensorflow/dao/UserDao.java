package com.tensorflow.dao;

import java.sql.SQLException;

import com.tensorflow.entity.User;

public interface UserDao {
	
	public boolean addOneUser(User user);
	public String checkUser(User user) throws SQLException;
	public User userSign(String UserName) throws SQLException;
}
