package com.tensorflow.service;

import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;

import java.sql.SQLException;
import java.util.List;

public interface ClassService {
	public boolean CreateClass(Class class1) throws SQLException;
	public String SearchClassID(String className) throws SQLException;
	public String SearchClassName(String classID) throws SQLException;
	public List<Stu> StuInClass(String classCode) throws SQLException;
}
