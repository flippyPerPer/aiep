package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.entity.Class;
import com.tensorflow.entity.Exp;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Work;
import com.tensorflow.util.CloseResourceUtils;
import com.tensorflow.util.GetConnectionUtils;

public class TchDaoImpl implements TchDao {

	public TchDaoImpl() {
	}

	public boolean addOneTch(Tch tch) {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "insert into tch (Univ_name,Tch_num,Tch_password,Tch_name,Tch_phone,Tch_email) value(?,?,?,?,?,?)";
		try {
			preparedStatement = oneConnection.prepareStatement(sql);
			preparedStatement.setString(1, tch.getUnivName());
			preparedStatement.setString(2, tch.getTchNum());
			preparedStatement.setString(3, tch.getTchPassword());
			preparedStatement.setString(4, tch.getTchName());
			preparedStatement.setString(5, tch.getTchPhone());
			preparedStatement.setString(6, tch.getTchEmail());

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

	public String checkTch(Tch tch) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select Tch_num,Tch_password from tch where Tch_num=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, tch.getTchNum());
		// String TchNum = null;
		String Password = null;
		ResultSet resultSet = read.executeQuery();
		if (resultSet.next()) {

			// TchNum = resultSet.getString("Tch_name");
			Password = resultSet.getString("Tch_password");

			CloseResourceUtils.close(connection, read, resultSet);
			return Password;
		}

		CloseResourceUtils.close(connection, read, resultSet);
		return null;

	}

	public Tch tchSign(String tchName) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select * from tch where Tch_num=?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, tchName);
		ResultSet resultSet = read.executeQuery();
		String Univ_name = null;
		String Tch_num = null;
		String Tch_name = null;
		String Tch_phone = null;
		String Tch_email = null;

		if (resultSet.next()) {

			Univ_name = resultSet.getString("Univ_name");
			Tch_num = resultSet.getString("Tch_num");
			Tch_name = resultSet.getString("Tch_name");
			Tch_phone = resultSet.getString("Tch_phone");
			Tch_email = resultSet.getString("Tch_email");
			Tch tch = new Tch(Univ_name, Tch_num, Tch_name, Tch_phone, Tch_email);
			CloseResourceUtils.close(connection, read, resultSet);
			return tch;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;
	}

	public List<Class> showMyClass(String tchNum) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "SELECT * FROM class WHERE Class_tch = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		System.out.println(tchNum);
		read.setString(1, tchNum);
		ResultSet resultSet = read.executeQuery();
		List<Class> list = new ArrayList<Class>();
		while (resultSet.next()) {
			Class class1 = new Class(resultSet.getString("Class_code"), resultSet.getString("Univ_name"), resultSet.getString("Class_tch"), resultSet.getString("Class_name"));
			list.add(class1);
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return list;
	}

	public boolean UpdateSign(Tch tch) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "UPDATE tch SET Tch_phone = ?,Tch_email = ?,Tch_password = ? WHERE Tch_num = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, tch.getTchPhone());
		read.setString(2, tch.getTchEmail());

		read.setString(3, tch.getTchPassword());

		read.setString(4, tch.getTchNum());

		tch.setTchPassword(null);

		int executeUpdate = read.executeUpdate();
		if (executeUpdate > 0) {
			CloseResourceUtils.close(connection, read, null);
			return true;
		}
		CloseResourceUtils.close(connection, read, null);
		return false;
	}

	public List<Exp> showMyExp(String tchNum) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select Exp_ID,Exp_name,Exp_info,Num_of_exp,URL_of_pic from Exp where Tch_num = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, tchNum);

		String e_Exp_ID = null;
		String e_Exp_name = null;
		String e_Exp_info = null;
		int e_Num_of_exp;
		String e_Pic_URL = null;

		ResultSet resultSet = read.executeQuery();
		List<Exp> exps = new ArrayList<Exp>();

		while (resultSet.next()) {
			e_Exp_ID = resultSet.getString("Exp_ID");
			e_Exp_name = resultSet.getString("Exp_name");
			e_Exp_info = resultSet.getString("Exp_info");
			e_Num_of_exp = resultSet.getInt("Num_of_exp");
			e_Pic_URL = resultSet.getString("URL_of_pic");
			Exp exp = new Exp(e_Exp_ID, e_Exp_name, e_Exp_info, e_Num_of_exp, e_Pic_URL);

			exps.add(exp);
		}

		CloseResourceUtils.close(connection, read, resultSet);
		return exps;
	}

	public boolean addWork(Work work) throws SQLException {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int workID = 0;
		
		try {
			String sql0 = "select max(work_ID) as work_ID from work";
			preparedStatement = oneConnection.prepareStatement(sql0);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				workID = result.getInt("work_ID");
			}

		String sql = "insert into work (work_ID,work_name,work_info,Tch_num,Class_code,Exp_ID,Exp_type,Start_time,End_time) value(?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = oneConnection.prepareStatement(sql);
			preparedStatement.setInt(1, workID+1);
			preparedStatement.setString(2, work.getWorkName());
			preparedStatement.setString(3, work.getWorkInfo());
			preparedStatement.setString(4, work.getTchNum());
			preparedStatement.setString(5, work.getClassCode());
//			preparedStatement.setInt(6, Integer.parseInt(work.getExpID()));
			preparedStatement.setString(6, work.getExpID());
			preparedStatement.setString(7, work.getExpType());
			preparedStatement.setString(8, work.getStartTime());
			preparedStatement.setString(9, work.getEndTime());
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			
			if (executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResourceUtils.close(oneConnection, preparedStatement, resultSet);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return false;
	}

	public List<Work> showMyWork(String tchNum) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select work_name,Exp_ID,Class_code,Start_time,End_time from work where Tch_num = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, tchNum);

		String work_name = null;
		String Exp_ID = null;
		String Class_code = null;
		String Start_time = null;
		String End_time = null;

		ResultSet resultSet = read.executeQuery();
		List<Work> works = new ArrayList<Work>();

		while (resultSet.next()) {
			work_name = resultSet.getString("work_name");
			Exp_ID = resultSet.getString("Exp_ID");
			Class_code = resultSet.getString("Class_code");
			Start_time = resultSet.getString("Start_time");
			End_time = resultSet.getString("End_time");
			Work work = new Work(work_name, Exp_ID, Class_code, Start_time, End_time);
			works.add(work);
		}

		CloseResourceUtils.close(connection, read, resultSet);
		return works;
	}

}
