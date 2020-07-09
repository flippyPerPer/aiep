package com.tensorflow.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Exp;
import com.tensorflow.entity.Tch;
import com.tensorflow.service.ExpService;
import com.tensorflow.service.ExpServiceImpl;

@WebServlet("/CreateExpServlet")
public class CreateExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateExpServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String Exp_name = request.getParameter("Exp_name");
		String Exp_info = request.getParameter("Exp_info");
//		String Exp_type = request.getParameter("Exp_type");
//		String Exp_api = request.getParameter("Exp_api");
		String URL_of_pic = request.getParameter("URL_of_pic");
		String Tch_num = JSON.parseObject((String)request.getSession().getAttribute("tch"), Tch.class).getTchNum();

		ExpService expService = new ExpServiceImpl();
		if (!(null == Exp_name && "".equals(Exp_name))) {

			Exp exp = new Exp(Exp_name, Exp_info, Tch_num);
			if(URL_of_pic == null) {
				exp.setExpURLPic("http://ws4.sinaimg.cn/large/9150e4e5ly1flhz64m7gbj20am08cq37.jpg");
			}

			if(expService.addOneExp(exp)) {				
				request.getRequestDispatcher("teacherPage.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
