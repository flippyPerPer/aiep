package com.tensorflow.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tensorflow.entity.Exp;

public interface ExpDao {

	public boolean addOneExp(Exp exp);
	
	public boolean deleteExp(String expID)throws SQLException;

	public Exp expSign(String exp_name) throws SQLException;

	public List<Exp> expList(String sign) throws SQLException;
	
	public Exp expSignByID(String exp_id) throws SQLException;
	
	public boolean expSignUpdate(Exp exp) throws SQLException;
	
	public boolean expTimesIncrease(String exp_num,int exp_times) throws SQLException;
	
//	public boolean expRecord(Exp exp);
}

