package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tensorflow.entity.Tch;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/TchLoginServlet")
public class TchLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pwd = null;
		String tchNum = request.getParameter("inTchNum");
		String tchPassword = request.getParameter("inPassword");
		TchService tchService = new TchServiceImpl();
		if (!(null == tchNum && "".equals(tchNum) && null == tchPassword && "".equals(tchPassword))) {
			Tch tch = new Tch(tchNum, tchPassword);
			try {
				pwd = tchService.checkTch(tch);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pwd != null && pwd.equals(tchPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("tch", tch);
				request.setAttribute("inTchNum", tchNum);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
