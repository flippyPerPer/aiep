package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tensorflow.entity.User;
import com.tensorflow.util.CloseResourceUtils;
import com.tensorflow.util.GetConnectionUtils;

public class UserDaoImpl implements UserDao {

	public boolean addOneUser(User user) {

		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "insert into user (u_name,u_password,u_phone,u_email) value(?,?,?,?)";
		try {
			preparedStatement = oneConnection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPassword());
			preparedStatement.setString(3, user.getUserPhone());
			preparedStatement.setString(4, user.getUserEmail());
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			if (executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResourceUtils.close(oneConnection, preparedStatement, resultSet);
		}
		return false;
	}

	public String checkUser(User user) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select u_name,u_password from user where u_name=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, user.getUserName());
//		String UserName = null;
		String Password = null;
		ResultSet resultSet = read.executeQuery();
		if (resultSet.next()) {
//			UserName = resultSet.getString("User_name");
			Password = resultSet.getString("User_password");

			CloseResourceUtils.close(connection, read, resultSet);
			return Password;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;

	}
	
	public User userSign(String UserName) throws SQLException{
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select * from user where u_name=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, UserName);
		ResultSet resultSet = read.executeQuery();
		String User_name = null;
		String User_phone = null;
		String User_email = null;
		if (resultSet.next()) {
			
			User_name = resultSet.getString("User_name");
			User_phone = resultSet.getString("User_phone");
			User_email = resultSet.getString("User_email");
			User user = new User(User_name,User_phone,User_email);
			
			CloseResourceUtils.close(connection, read, resultSet);
			return user;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;
	}

}
