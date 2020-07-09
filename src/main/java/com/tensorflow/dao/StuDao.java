package com.tensorflow.dao;

import java.sql.SQLException;
import java.util.List;

import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;

public interface StuDao {
	public boolean addOneStu(Stu stu);
	public String checkStu(Stu stu) throws SQLException;
	public Stu stuSign(String stuName) throws SQLException;
	public boolean joinClass(String classCode, String univName, String stuNum) throws SQLException;
	public List<Class> showMyClass(String stuNum) throws SQLException;
}
