package com.tensorflow.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tensorflow.entity.Tch;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/TchRegisterServlet")
public class TchRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String univname = request.getParameter("tchunivname");
		String tchnum = request.getParameter("tchnum");
		String tchpassword = request.getParameter("tchpassword");
//		String checktchpassword = request.getParameter("checktchpassword");
		String tchname = request.getParameter("tchname");
		String tchphone = request.getParameter("tchphone");
		String tchemail = request.getParameter("tchemail");
		// 鑾峰彇浠庢敞鍐岄〉闈紶閫掕繘鏉ョ殑琛ㄥ崟鏁版嵁銆�

		TchService tchService = new TchServiceImpl();
		if (!("".equals(univname) && "".equals(tchnum) && "".equals(tchphone) && "".equals(tchemail) && null == univname
				&& null == tchnum && null == tchphone && null == tchemail)) {

			Tch tch = new Tch(univname, tchnum, tchpassword, tchname, tchphone, tchemail);

			if (tchService.addOneTch(tch) == true) {
				request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
