package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/updateExperimentServlet")
public class updateExperimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String Exp_name = request.getParameter("Exp_name");
		String Exp_info = request.getParameter("Exp_info");
//		String Exp_type = request.getParameter("Exp_type");
		String Exp_api = request.getParameter("Exp_api");
		String URL_of_pic = request.getParameter("file");
		String Exp_ID = request.getParameter("Exp_ID");
		System.out.println("updateServlet:"+Exp_ID);
		if (!(null == Exp_ID && "".equals(Exp_ID))) {
			ExpService expService = new ExpServiceImpl();
			Exp exp = null;
			try {
				exp = expService.expSignByID(Exp_ID);
				System.out.println("´ÓupdateServlet:"+exp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			exp.setExpName(Exp_name);
			exp.setExpInfo(Exp_info);
			if(Exp_api != null) {
				exp.setExpApi(Exp_api);
			}else {
				exp.setExpApi("");
			}
			if(URL_of_pic != null) {
				exp.setExpURLPic(URL_of_pic);
			}
		try {
			if(expService.expSignUpdate(exp)) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
