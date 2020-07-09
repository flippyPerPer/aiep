package com.tensorflow.service;

import java.sql.SQLException;
import java.util.List;

import com.tensorflow.dao.ClassDao;
import com.tensorflow.dao.ClassDaoImpl;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;

public class ClassServiceImpl implements ClassService{

	public ClassServiceImpl() {
	}
	private ClassDao classDao = new ClassDaoImpl();
	
	public boolean CreateClass(Class class1) throws SQLException {
		return classDao.CreateClass(class1);
	}

	public List<Stu> StuInClass(String classCode) throws SQLException {
		return classDao.StuInClass(classCode);
	}

	public String SearchClassID(String className) throws SQLException {
		return classDao.SearchClassID(className);
	}

	public String SearchClassName(String classID) throws SQLException {
		return classDao.SearchClassName(classID);
	}

}
