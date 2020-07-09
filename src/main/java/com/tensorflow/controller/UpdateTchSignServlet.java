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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import com.tensorflow.entity.Tch;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/UpdateTchSignServlet")
public class UpdateTchSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Tch tch = JSON.parseObject((String)session.getAttribute("tch"), Tch.class);
		String phone = request.getParameter("phone");
		String emil = request.getParameter("emil");
		String password = request.getParameter("password");
		if(phone != null) {
			tch.setTchPhone(phone);
		}
		if(emil != null) {
			tch.setTchEmail(emil);
		}
		if(password != null) {
			tch.setTchPassword(password);
		}
		TchService tchService = new TchServiceImpl();
		try {
			if(tchService.UpdateSign(tch) == true) {
				session.removeAttribute("tch");
				session.setAttribute("tch",JSON.toJSONString(tch));
				PrintWriter out = response.getWriter();
				out.print(JSON.toJSONString(tch));
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
