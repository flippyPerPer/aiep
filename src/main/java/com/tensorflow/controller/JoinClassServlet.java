package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Stu;
import com.tensorflow.service.StuService;
import com.tensorflow.service.StuServiceImpl;

/**
 * Servlet implementation class JoinClassServlet
 */
@WebServlet("/JoinClassServlet")
public class JoinClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Stu stu = JSON.parseObject((String)request.getSession().getAttribute("stu"), Stu.class);
		String classCode = request.getParameter("classCode");
		
		StuService stuService = new StuServiceImpl();
		
		try {
			if(stuService.joinClass(classCode, stu.getUnivName(), stu.getStuNum())) {
				request.getRequestDispatcher("studentPage.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
