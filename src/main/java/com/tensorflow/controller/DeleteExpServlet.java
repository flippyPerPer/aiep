package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tensorflow.service.ExpService;
import com.tensorflow.service.ExpServiceImpl;

/**
 * Servlet implementation class DeleteExpServlet
 */
@WebServlet("/DeleteExpServlet")
public class DeleteExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String expID = request.getParameter("expID");
		ExpService expService = new ExpServiceImpl();
		System.out.println("进入删除Exp的servlet："+expID);
		
		if(expID != null) {
			try {
				if(expService.deleteExp(expID)) {
					System.out.println("开始删除");
					request.getRequestDispatcher("teacherPage.jsp").forward(request, response);
					System.out.println("success!");
				}else {
					System.out.println("wrong!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
