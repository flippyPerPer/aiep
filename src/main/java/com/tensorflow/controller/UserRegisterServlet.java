package com.tensorflow.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tensorflow.entity.User;
import com.tensorflow.service.UserService;
import com.tensorflow.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		String checkPassword = request.getParameter("checkPassword");
		String userphone = request.getParameter("userphone");
		String userEmail = request.getParameter("email");

		UserService userService = new UserServiceImpl();
		if (!("".equals(username) && "".equals(password) && "".equals(userphone) && "".equals(userEmail)
				&& null == username && null == password && null == userphone && null == userEmail)) {

			User user = new User(username, password, userphone, userEmail);

			if (userService.addOneUser(user) == true) {
				request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
