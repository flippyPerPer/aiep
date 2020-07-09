package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;
import com.tensorflow.util.CloseResourceUtils;
import com.tensorflow.util.GenerateClassCode;
import com.tensorflow.util.GetConnectionUtils;

public class ClassDaoImpl implements ClassDao {

	public ClassDaoImpl() {
	}

	public boolean CreateClass(Class class1) throws SQLException {

		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String classCode = null;
		while (true) {
			String sql1 = "select Class_code from class where Class_code=?";
			PreparedStatement read = oneConnection.prepareStatement(sql1);
			classCode = GenerateClassCode.createShareCode();
			read.setString(1, classCode);
			ResultSet check = read.executeQuery();
			if (check.next()) {
				continue;
			} else {
				break;
			}
		}
		System.out.println("ClassDaoImpl:"+classCode);
		String sql2 = "insert into class (Univ_name,Class_code,Class_name,Class_tch) value(?,?,?,?)";
		try {
			preparedStatement = oneConnection.prepareStatement(sql2);
			preparedStatement.setString(1, class1.getUnivName());
			preparedStatement.setString(2, classCode);
			preparedStatement.setString(3, class1.getClassName());
			preparedStatement.setString(4, class1.getClassTch());

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

	public List<Stu> StuInClass(String classCode) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "SELECT stu.Stu_name,stu_in_classes.Stu_num FROM stu,stu_in_classes WHERE stu.Stu_num=stu_in_classes.Stu_num AND stu_in_classes.Class_code=?;";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, classCode);
		ResultSet resultSet = read.executeQuery();
		List<Stu> list = new ArrayList<Stu>();
		while (resultSet.next()) {
			list.add(new Stu(resultSet.getString("Stu_name"), resultSet.getString("Stu_num")));
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return list;
	}

	public String SearchClassID(String className) throws SQLException {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		String sql = "select Class_code from class where Class_name=?";
		PreparedStatement read = oneConnection.prepareStatement(sql);
		read.setString(1, className);
		ResultSet resultSet = read.executeQuery();
		if (resultSet.next()) {
			String classCode = resultSet.getString("Class_code");
			CloseResourceUtils.close(oneConnection, read, resultSet);
			return classCode;
		} else {
			CloseResourceUtils.close(oneConnection, read, resultSet);
			return null;
		}
	}


	public String SearchClassName(String classID) throws SQLException {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		String sql = "select Class_name from class where Class_code=?";
		PreparedStatement read = oneConnection.prepareStatement(sql);
		read.setString(1, classID);
		ResultSet resultSet = read.executeQuery();
		if (resultSet.next()) {
			System.out.println("ClassDaoImpl:"+resultSet.getString("Class_name"));
			CloseResourceUtils.close(oneConnection, read, resultSet);
			return resultSet.getString("Class_name");
		} else {
			CloseResourceUtils.close(oneConnection, read, resultSet);
			return null;
		}
	}

}
