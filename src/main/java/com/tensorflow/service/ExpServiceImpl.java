package com.tensorflow.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.tensorflow.dao.ExpDao;
import com.tensorflow.dao.ExpDaoImpl;
import com.tensorflow.entity.Exp;
import com.tensorflow.entity.Pod;

public class ExpServiceImpl implements ExpService{

	private ExpDao expDao = new ExpDaoImpl();
	
	public boolean addOneExp(Exp exp) {
		return expDao.addOneExp(exp);
	}

	public Exp expSign(String exp_name) throws SQLException {
		return expDao.expSign(exp_name);
	}

	public List<Exp> expList(String sign) throws SQLException {
		return expDao.expList(sign);
	}

	public Exp expSignByID(String exp_id) throws SQLException {
		PodService podService = new PodServiceImpl();
		podService.updateAllPodStatus();
		System.out.println("有用户准备上机，更新当前Pod情况。\n");
		Pod pod = podService.checkAvaliablePods();
		System.out.println("从数据库中查出符合需求的Pod为：\n"+pod);
		Exp exp = expDao.expSignByID(exp_id);
		exp.setExpEnvirment(pod.getPodIP());
		exp.setExpPodName(pod.getPodName());
		return exp;
	}

	public boolean expSignUpdate(Exp exp) throws SQLException {
		return expDao.expSignUpdate(exp);
	}

	public boolean deleteExp(String expID) throws SQLException {
		return expDao.deleteExp(expID);
	}

//	public boolean expTimesIncrease(String exp_num,String exp_times) {
//		return;
//	}


}
