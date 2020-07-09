package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tensorflow.entity.Exp;
import com.tensorflow.service.ExpService;
import com.tensorflow.util.CloseResourceUtils;
import com.tensorflow.util.GetConnectionUtils;

public class ExpDaoImpl implements ExpDao {

	@SuppressWarnings("resource")
	public boolean addOneExp(Exp exp) {
		// TODO Auto-generated method stub
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int expID = 0;
		
		try {
			String sql0 = "select max(Exp_ID) as Exp_ID from exp";
			preparedStatement = oneConnection.prepareStatement(sql0);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				expID = result.getInt("Exp_ID");
			}
				
			String sql = "insert into exp(Exp_ID,Exp_name,Exp_info,Exp_type,Tch_num,Exp_api,Exp_envirment,Num_of_exp,URL_of_pic) value(?,?,?,?,?,?,?,?,?)";
			preparedStatement = oneConnection.prepareStatement(sql);
			preparedStatement.setInt(1, expID+1);
			preparedStatement.setString(2, exp.getExpName());
			preparedStatement.setString(3, exp.getExpInfo());
			preparedStatement.setString(4, exp.getExpType());
			preparedStatement.setString(5, exp.getTchNum());
			preparedStatement.setString(6, exp.getExpApi());
			preparedStatement.setString(7, exp.getExpEnvirment());
			preparedStatement.setInt(8, 0);
			preparedStatement.setString(9, exp.getExpURLPic());

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

	public Exp expSign(String exp_name) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select * from exp where Exp_name = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1, exp_name);

		String e_Exp_ID;
		String e_Exp_name = null;
		String e_Exp_info = null;
		String e_Exp_type = null;
		String e_Tch_num = null;
		String e_Exp_api = null;
		String e_Exp_envirment = null;
		int e_Num_of_exp;
		String e_URL_of_pic = null;

		ResultSet resultSet = read.executeQuery();

		if (resultSet.next()) {
			e_Exp_ID = resultSet.getString("Exp_ID");
			e_Exp_name = resultSet.getString("Exp_name");
			e_Exp_info = resultSet.getString("Exp_info");
			e_Exp_type = resultSet.getString("Exp_type");
			e_Tch_num = resultSet.getString("Tch_num");
			e_Exp_api = resultSet.getString("Exp_api");
			e_Exp_envirment = resultSet.getString("Exp_envirment");
			e_URL_of_pic = resultSet.getString("URL_of_pic");
			e_Num_of_exp = resultSet.getInt("Num_of_exp");
			Exp exp = new Exp(e_Exp_ID, e_Exp_name, e_Exp_info, e_Exp_type, e_Tch_num, e_Exp_api, e_Exp_envirment,
					e_URL_of_pic, e_Num_of_exp);

			// 实验次数加1，即添加一条实验记录。
			CloseResourceUtils.close(connection, read, resultSet);
			return exp;
		}
		CloseResourceUtils.close(connection, read, resultSet);
		return null;
	}

	public List<Exp> expList(String sign) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "select Exp_ID,Exp_name,Exp_info,Num_of_exp,URL_of_pic from exp where Exp_name like ?";
		PreparedStatement read = connection.prepareStatement(sql);
		if (sign == null) {
			sign = "";
		}
		read.setString(1, "%" + sign + "%");

		String e_Exp_ID=null;
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
			Exp exp = new Exp(e_Exp_ID, e_Exp_name, e_Exp_info, e_Num_of_exp,e_Pic_URL);

			exps.add(exp);
		}

		CloseResourceUtils.close(connection, read, resultSet);
		return exps;
	}

	public boolean expTimesIncrease(String exp_num, int exp_times) throws SQLException {
		Connection oneConnection = GetConnectionUtils.getoneConnection();
		String sql = "update exp set Num_of_exp = ? where Exp_ID = ?";
		PreparedStatement preparedStatement = oneConnection.prepareStatement(sql);
		preparedStatement = oneConnection.prepareStatement(sql);
		preparedStatement.setInt(1, exp_times + 1);
		preparedStatement.setString(2, exp_num);
		int executeUpdate = preparedStatement.executeUpdate();
		CloseResourceUtils.close(oneConnection, preparedStatement, null);
		if (executeUpdate>0) {
			return true;
		}
		return false;
	}

	public Exp expSignByID(String exp_id) throws SQLException {
		// TODO Auto-generated method stub
				Connection connection = GetConnectionUtils.getoneConnection();
				String sql = "select * from exp where Exp_ID = ?";
				PreparedStatement read = connection.prepareStatement(sql);
				read.setString(1, exp_id);

				String e_Exp_ID = exp_id;
				String e_Exp_name = null;
				String e_Exp_info = null;
				String e_Exp_type = null;
				String e_Tch_num = null;
				String e_Exp_api = null;
				String e_Exp_envirment = null;
				int e_Num_of_exp;
				String e_URL_of_pic = null;

				ResultSet resultSet = read.executeQuery();

				if (resultSet.next()) {
					e_Exp_ID = resultSet.getString("Exp_ID");
					e_Exp_name = resultSet.getString("Exp_name");
					e_Exp_info = resultSet.getString("Exp_info");
					e_Exp_type = resultSet.getString("Exp_type");
					e_Tch_num = resultSet.getString("Tch_num");
					e_Exp_api = resultSet.getString("Exp_api");
					e_Exp_envirment = resultSet.getString("Exp_envirment");
					e_Num_of_exp = resultSet.getInt("Num_of_exp");
					e_URL_of_pic = resultSet.getString("URL_of_pic");
					Exp exp = new Exp(e_Exp_ID, e_Exp_name, e_Exp_info, e_Exp_type, e_Tch_num, e_Exp_api, e_Exp_envirment,
							e_URL_of_pic, e_Num_of_exp);
					// 实验次数加1，即添加一条实验记录。
					expTimesIncrease(e_Exp_ID, e_Num_of_exp);
					CloseResourceUtils.close(connection, read, resultSet);
					return exp;
				}
				CloseResourceUtils.close(connection, read, resultSet);
				return null;
	}

	public boolean expSignUpdate(Exp exp) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql = "UPDATE exp SET Exp_name = ?,Exp_info = ?,Exp_api = ?,URL_of_pic = ? WHERE Exp_ID = ?";
		PreparedStatement read = connection.prepareStatement(sql);
		read.setString(1,exp.getExpName());
		read.setString(2,exp.getExpInfo());
		read.setString(3,exp.getExpApi());
		read.setString(4,exp.getExpURLPic());
		read.setString(5, exp.getExpID());
		
		int executeUpdate = read.executeUpdate();
		if(executeUpdate > 0) {
			CloseResourceUtils.close(connection, read, null);
			return true;
		}
		CloseResourceUtils.close(connection, read, null);
		return false;
	}

	public boolean deleteExp(String expID) throws SQLException {
		Connection connection = GetConnectionUtils.getoneConnection();
		String sql1 = "delete from work where Exp_ID = ?";
		PreparedStatement read = connection.prepareStatement(sql1);
		read.setString(1, expID);
		int excuteUpdate1 = read.executeUpdate();
		if(excuteUpdate1>0) {
			String sql2 = "delete from exp where Exp_ID = ?";
			read = connection.prepareStatement(sql2);
			read.setString(1, expID);
			int excuteUpdate2 = read.executeUpdate();
			if(excuteUpdate2>0) {
				CloseResourceUtils.close(connection, read, null);
				return true;
			}else {
				CloseResourceUtils.close(connection, read, null);
				return false;
			}
		}else {
			CloseResourceUtils.close(connection, read, null);
			return false;
		}
	}
	
//	public boolean expRecord(Exp exp) {
//		Connection oneConnection = GetConnectionUtils.getoneConnection();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//
//		String sql = "insert into record_of_exp(Exp_ID,Record_num,Exp_complete,Exp_score,Exp_compiler,Exp_time) value(?,?,?,?,?,?)";
//		try {
//			preparedStatement = oneConnection.prepareStatement(sql);
//			preparedStatement.setString(1, exp.getExpID());
//			preparedStatement.setString(2, exp.getExpName());
//			preparedStatement.setString(3, exp.getExpInfo());
//			preparedStatement.setString(4, exp.getExpType());
//			preparedStatement.setString(5, exp.getTchNum());
//			preparedStatement.setString(6, exp.getExpApi());
//			int executeUpdate = preparedStatement.executeUpdate();
//			if (executeUpdate > 0) {
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			CloseResourceUtils.close(oneConnection, preparedStatement, resultSet);
//		}
//
//		return false;
//	}

}
