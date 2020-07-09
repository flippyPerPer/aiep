package com.tensorflow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Stu;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.User;
import com.tensorflow.service.StuService;
import com.tensorflow.service.StuServiceImpl;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;
import com.tensorflow.service.UserService;
import com.tensorflow.service.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String pwd = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String type = request.getParameter("t&s");
		HttpSession session = request.getSession(true);
		if ("1".equals(type)) {
			User user = new User(userName, password);
			UserService userService = new UserServiceImpl();
			try {
				pwd = userService.checkUser(user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (pwd != null && pwd.equals(password)) {
				try {
					user = userService.userSign(userName);
					user.setStateNumber(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String userJson = JSON.toJSONString(user);
				session.setAttribute("user", userJson);
				
				// out.print(userJson);
				// System.out.println(userJson);
				// out.print(session.getAttribute("expsJson"));
				// System.out.println("log:"+session.getAttribute("expsJson"));
				if(session.getAttribute("user")!=null) {
						request.getRequestDispatcher("experimentPage.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}

			}
		}else if ("2".equals(type)) {
				Stu stu = new Stu(userName, password);
				StuService stuService = new StuServiceImpl();
				try {
					pwd = stuService.checkStu(stu);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (pwd != null && pwd.equals(password)) {
						try {
							stu = stuService.stuSign(userName);
							stu.setStateNumber(2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					String stuJson = JSON.toJSONString(stu);
					session.setAttribute("stu", stuJson);
					if(session.getAttribute("stu")!=null) {
						request.getRequestDispatcher("experimentPage.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}
			} else if ("3".equals(type)) {
				Tch tch = new Tch(userName, password);
				TchService tchService = new TchServiceImpl();
				try {
					pwd = tchService.checkTch(tch);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (pwd != null && pwd.equals(password)) {
					try {
						tch = tchService.tchSign(userName);
						tch.setStateNumber(3);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String tchJson = JSON.toJSONString(tch);
					session.setAttribute("tch", tchJson);
					if(session.getAttribute("tch")!=null) {
						request.getRequestDispatcher("experimentPage.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}
			}
		
//		out.print(session.getAttribute("user"));
//		System.out.println(session.getAttribute("user"));
//		if(session.getAttribute("user")!=null||session.getAttribute("stu")!=null||session.getAttribute("tch")!=null) {
//		} else {
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
