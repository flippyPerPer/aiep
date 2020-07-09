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
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Work;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/ShowTchWorksServlet")
public class ShowTchWorksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String tchNum = JSON.parseObject((String)request.getSession().getAttribute("tch"), Tch.class).getTchNum();

		TchService tchService = new TchServiceImpl();
		
		List<Work> works = new ArrayList<Work>();
		
		try {
			works = tchService.showMyWork(tchNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String worksJson = JSON.toJSONString(works);
		PrintWriter out = response.getWriter();
		out.print(worksJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
