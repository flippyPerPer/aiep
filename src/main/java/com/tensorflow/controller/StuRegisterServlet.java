package com.tensorflow.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tensorflow.entity.Stu;
import com.tensorflow.service.StuService;
import com.tensorflow.service.StuServiceImpl;

@WebServlet("/StuRegisterServlet")
public class StuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String univname = request.getParameter("stuunivname");
		String stunum = request.getParameter("stunum");
		String stupassword = request.getParameter("stupassword");
//		String checkstupassword = request.getParameter("checkstupassword");
		String stuname = request.getParameter("stuname");
		String stuphone = request.getParameter("stuphone");
		String stuemail = request.getParameter("stuemail");

		StuService stuService = new StuServiceImpl();
		if (!("".equals(univname) && "".equals(stunum) && "".equals(stuphone) && "".equals(stuemail) && null == univname
				&& null == stunum && null == stuphone && null == stuemail)) {

			Stu stu = new Stu(univname, stunum, stupassword, stuname, stuphone, stuemail);

			if (stuService.addOneStu(stu) == true) {
				request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
