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
import com.tensorflow.util.GetConnectionUtils;

public class StuDaoImpl implements StuDao {

	public boolean addOneStu(Stu stu) {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "insert into stu (Univ_name,Stu_num,Stu_password,Stu_name,Stu_phone,Stu_email) value(?,?,?,?,?,?)";
		try { 
			preparedStatement = oneConnection.prepareStatement(sql);
			preparedStatement.setString(1, stu.getUnivName());
			preparedStatement.setString(2, stu.getStuNum());
			preparedStatement.setString(3, stu.getStuPassword());
			preparedStatement.setString(4, stu.getStuName());
			preparedStatement.setString(5, stu.getStuPhone());
			preparedStatement.setString(6, stu.getStuEmail());

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

	public String checkStu(Stu stu) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select Stu_num,Stu_password from stu where Stu_num=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, stu.getStuNum());
//		String StuNum = null;
		String Password = null;
		ResultSet resultSet = read.executeQuery();
		if (resultSet.next()) {
			
//			StuNum = resultSet.getString("Stu_name");
			Password = resultSet.getString("Stu_password");

			CloseResourceUtils.close(connection, read, resultSet);
			return Password;
			
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;

	}

	public Stu stuSign(String stuName) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select * from stu where Stu_num=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, stuName);
		ResultSet resultSet = read.executeQuery();
		String Univ_name = null;
		String Stu_num = null;
		String Stu_name = null;
		String Stu_phone = null;
		String Stu_email = null;
		
		if (resultSet.next()) {
			Univ_name = resultSet.getString("Univ_name");
			Stu_num = resultSet.getString("Stu_num");
			Stu_name = resultSet.getString("Stu_name");
			Stu_phone = resultSet.getString("Stu_phone");
			Stu_email = resultSet.getString("Stu_email");
			Stu stu = new Stu(Univ_name, Stu_num, Stu_name, Stu_phone, Stu_email);
			CloseResourceUtils.close(connection, read, resultSet);
			return stu;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;
	}

	public boolean joinClass(String classCode, String univName, String stuNum) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "INSERT INTO stu_in_classes(Univ_name,Class_code,Stu_num)  VALUE(?,?,?)";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, univName);
		read.setString(2, classCode);
		read.setString(3, stuNum);
		int executeUpdate = read.executeUpdate();
		if(executeUpdate>0) {
			return true;
		}else {			
			return false;
		}
	}

	public List<Class> showMyClass(String stuNum) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql1 = "SELECT Class_code FROM stu_in_classes WHERE Stu_num = ?";
		PreparedStatement read = connection.prepareStatement(sql1);
		read.setString(1, stuNum);
		ResultSet resultSet = read.executeQuery();
		ArrayList<String> classCodes = new ArrayList<String>();
		int n = 0;
		while(resultSet.next()) {
			classCodes.add(resultSet.getString("Class_code"));
			n++;
		}
		
		String sql2 = "SELECT * FROM class WHERE Class_code = ?";
		List<Class> list = new ArrayList<Class>();
		while(n-->0) {
			read = connection.prepareStatement(sql2);
			read.setString(1, classCodes.get(n));
			resultSet = read.executeQuery();
			while (resultSet.next()) {
				Class class1 = new Class(resultSet.getString("Class_code"), resultSet.getString("Univ_name"), resultSet.getString("Class_tch"), resultSet.getString("Class_name"));
				list.add(class1);
			}
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return list;
	}

}
