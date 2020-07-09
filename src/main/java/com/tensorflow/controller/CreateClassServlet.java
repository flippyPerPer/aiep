package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Class;
import com.tensorflow.service.ClassService;
import com.tensorflow.service.ClassServiceImpl;
import com.tensorflow.service.UserService;
import com.tensorflow.util.GenerateClassCode;

@WebServlet("/CreateClassServlet")
public class CreateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateClassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String className = request.getParameter("className");

		ClassService classService = new ClassServiceImpl();
		if (!(null == className && "".equals(className))) {
			Tch tch = JSON.parseObject((String)request.getSession().getAttribute("tch"), Tch.class);
			Class class1 = new Class(tch.getUnivName(), tch.getTchNum(), className);
			try {
				if(classService.CreateClass(class1)) {
					request.getRequestDispatcher("teacherPage.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
