package com.tensorflow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkLoginServlet")
public class checkLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (session.getAttribute("stu") != null) {
			out.print(session.getAttribute("stu"));
		} else if (session.getAttribute("user") != null) {
			out.print(session.getAttribute("user"));
		} else if (session.getAttribute("tch") != null) {
			out.print(session.getAttribute("tch"));
		} else {
//			request.getRequestDispatcher("error.jsp").forward(request, response);
			int stateNumber = 0;
			out.print(stateNumber);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
