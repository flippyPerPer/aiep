package com.tensorflow.service;

import java.sql.SQLException;

import java.util.List;
import com.tensorflow.dao.TchDao;
import com.tensorflow.dao.TchDaoImpl;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Work;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Exp;

public class TchServiceImpl implements TchService{

	private TchDao tchDao = new TchDaoImpl();
	
	public boolean addOneTch(Tch tch) {
		return tchDao.addOneTch(tch);
	}
	
	public String checkTch(Tch tch) throws SQLException {
		return tchDao.checkTch(tch);
	}

	public Tch tchSign(String tchName) throws SQLException {
		return tchDao.tchSign(tchName);
	}

	public List<Class> showMyClass(String tchNum) throws SQLException {
		return tchDao.showMyClass(tchNum);
	}

	public boolean UpdateSign(Tch tch) throws SQLException {
		return tchDao.UpdateSign(tch);
	}

	public List<Exp> showMyExp(String tchNum) throws SQLException {
		return tchDao.showMyExp(tchNum);
	}

	public boolean addWork(Work work) throws SQLException {
		return tchDao.addWork(work);
	}

	public List<Work> showMyWork(String tchNum) throws SQLException {
		return tchDao.showMyWork(tchNum);
	}


}
