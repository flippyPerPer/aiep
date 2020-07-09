package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tensorflow.entity.Stu;
import com.tensorflow.service.StuService;
import com.tensorflow.service.StuServiceImpl;

/**
 * Servlet implementation class StuLoginServlet
 */
@WebServlet("/StuLoginServlet")
public class StuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pwd = null;
		String stuNum = request.getParameter("inStuNum");
		String stuPassword = request.getParameter("inPassword");
		StuService stuService = new StuServiceImpl();
		if (!(null == stuNum && "".equals(stuNum) && null == stuPassword && "".equals(stuPassword))) {
			Stu stu = new Stu(stuNum, stuPassword);
			try {
				pwd = stuService.checkStu(stu);
			} catch (SQLException e) {
				// TODO Auto-generated castu block
				e.printStackTrace();
			}
			if (pwd != null && pwd.equals(stuPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("stu", stu);
				request.setAttribute("inStuNum", stuNum);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
