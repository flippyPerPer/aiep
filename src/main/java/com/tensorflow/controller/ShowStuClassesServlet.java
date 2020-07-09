package com.tensorflow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Stu;
import com.tensorflow.entity.Tch;
import com.tensorflow.service.StuService;
import com.tensorflow.service.StuServiceImpl;


@WebServlet("/ShowStuClassesServlet")
public class ShowStuClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String stuNum = JSON.parseObject((String)request.getSession().getAttribute("stu"), Stu.class).getStuNum();

		StuService stuService = new StuServiceImpl();
		List<Class> classes = new ArrayList<Class>();
		
		try {
			classes = stuService.showMyClass(stuNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String classesJson = JSON.toJSONString(classes);
		PrintWriter out = response.getWriter();
		out.print(classesJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
