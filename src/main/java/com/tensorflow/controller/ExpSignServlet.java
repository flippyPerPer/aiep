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

import com.tensorflow.entity.Exp;
import com.tensorflow.service.ExpService;
import com.tensorflow.service.ExpServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/ExpSignServlet")
public class ExpSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String[] ExpID = request.getQueryString().split("=");
		if (!(null == ExpID[1] && "".equals(ExpID[1]))) {
			ExpService expService = new ExpServiceImpl();
			Exp exp = null;
			try {
				exp = expService.expSignByID(ExpID[1]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(exp != null) {				
				request.setAttribute("exp", exp);
				request.getRequestDispatcher("updateExperiment.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
