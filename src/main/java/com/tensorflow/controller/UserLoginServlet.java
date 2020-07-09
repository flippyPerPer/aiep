package com.tensorflow.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.tensorflow.entity.User;
import com.tensorflow.service.UserService;
import com.tensorflow.service.UserServiceImpl;
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pwd = null;
		String userName = request.getParameter("inUserName");
		String userPassword = request.getParameter("inPassword");
		UserService userService = new UserServiceImpl();
		if (!(null == userName && "".equals(userName) && null == userPassword && "".equals(userPassword))) {
			User user = new User(userName, userPassword);
//			List<User> list = new ArrayList<User>();
//			list.add(user);
//			JSONArray jsonArray2 = JSONArray.fromObject(list);
			try {
				pwd = userService.checkUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pwd != null && pwd.equals(userPassword)) {
				request.setAttribute("inUserName", userName);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
//				session.setAttribute("json", jsonArray2);
				request.getRequestDispatcher("test.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
