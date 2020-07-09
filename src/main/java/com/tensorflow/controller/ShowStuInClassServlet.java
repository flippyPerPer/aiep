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
import com.tensorflow.entity.Stu;
import com.tensorflow.service.ClassService;
import com.tensorflow.service.ClassServiceImpl;


@WebServlet("/ShowStuInClassServlet")
public class ShowStuInClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String classCode = request.getParameter("classCode");

		ClassService classService = new ClassServiceImpl();
		
		List<Stu> stus = new ArrayList<Stu>();
		
		try {
			stus = classService.StuInClass(classCode);
//			System.out.println(classes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String stusJson = JSON.toJSONString(stus);
//		System.out.println(stus);
		PrintWriter out = response.getWriter();
		out.print(stusJson);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
