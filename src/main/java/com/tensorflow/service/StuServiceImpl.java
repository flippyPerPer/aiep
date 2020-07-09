package com.tensorflow.service;

import java.sql.SQLException;
import java.util.List;

import com.tensorflow.dao.StuDao;
import com.tensorflow.dao.StuDaoImpl;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;

public class StuServiceImpl implements StuService {

	private StuDao stuDao = new StuDaoImpl();
	
	public boolean addOneStu(Stu stu) {
		return stuDao.addOneStu(stu);
	}

	public String checkStu(Stu stu) throws SQLException {
		return stuDao.checkStu(stu);
	}

	public Stu stuSign(String stuName) throws SQLException {
		return stuDao.stuSign(stuName);
	}

	public boolean joinClass(String classCode, String univName, String stuNum) throws SQLException {
		return stuDao.joinClass(classCode,univName,stuNum);
	}

	public List<Class> showMyClass(String stuNum) throws SQLException {
		return stuDao.showMyClass(stuNum);
	}

}
