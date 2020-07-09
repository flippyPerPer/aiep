package com.tensorflow.service;

import java.sql.SQLException;

import com.tensorflow.dao.UserDao;
import com.tensorflow.dao.UserDaoImpl;
import com.tensorflow.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	private String temp;

	public boolean addOneUser(User user) {
		return userDao.addOneUser(user);
	}

	public String checkUser(User user) throws SQLException {
		temp = userDao.checkUser(user);
		return temp;
	}

	public User userSign(String UserName) throws SQLException{
		return userDao.userSign(UserName);
	}

}
