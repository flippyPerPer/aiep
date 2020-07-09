package com.tensorflow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tensorflow.entity.Exp;
import com.tensorflow.service.ExpService;
import com.tensorflow.service.ExpServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/ExpListServlet")
public class ExpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String ExpSign = request.getParameter("ExpSign");

		ExpService expService = new ExpServiceImpl();
		
		List<Exp> exps = new ArrayList<Exp>();
		
		try {
			exps = expService.expList(ExpSign);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String expsJson = JSON.toJSONString(exps);
		request.getSession().setAttribute("expsJson", expsJson);
		PrintWriter out = response.getWriter();
		out.print(expsJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
