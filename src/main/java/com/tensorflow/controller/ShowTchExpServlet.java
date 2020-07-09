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

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Exp;
import com.tensorflow.entity.Tch;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/ShowTchExpServlet")
public class ShowTchExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		TchService tchService = new TchServiceImpl();
		List<Exp> exps = new ArrayList<Exp>();

		try {
			exps = tchService.showMyExp(JSON.parseObject((String)request.getSession().getAttribute("tch"), Tch.class).getTchNum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String tchExps = JSON.toJSONString(exps);
		PrintWriter out = response.getWriter();
		out.print(tchExps);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
