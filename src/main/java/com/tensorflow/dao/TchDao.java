package com.tensorflow.dao;

import java.sql.SQLException;

import java.util.List;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Exp;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Work;

public interface TchDao {
	public boolean addOneTch(Tch tch);
	public String checkTch(Tch tch) throws SQLException;
	public Tch tchSign(String tchName) throws SQLException;
	public boolean UpdateSign(Tch tch) throws SQLException;
	public List<Exp> showMyExp(String tchNum) throws SQLException;
	public boolean addWork(Work work) throws SQLException;
	public List<Work> showMyWork(String tchNum)throws SQLException;
	public List<Class> showMyClass(String tchNum) throws SQLException;

}
