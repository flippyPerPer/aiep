package com.tensorflow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tensorflow.entity.Class;
import com.tensorflow.entity.Tch;
import com.tensorflow.entity.Work;
import com.tensorflow.service.ClassService;
import com.tensorflow.service.ClassServiceImpl;
import com.tensorflow.service.TchService;
import com.tensorflow.service.TchServiceImpl;

@WebServlet("/addWorkServlet")
public class addWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String workName = request.getParameter("workName");
		String expID = request.getParameter("expID");
		String workStartTime = request.getParameter("workStartTime");
		String workEndTime = request.getParameter("workEndTime");
		String workClass = request.getParameter("workClass");
		String workInfo = request.getParameter("workInfo");
		String tchNum = JSON.parseObject((String)request.getSession().getAttribute("tch"), Tch.class).getTchNum();
		String ClassCode = null;
		try {
			ClassService classService = new ClassServiceImpl();
			ClassCode =classService.SearchClassID(workClass);
		} catch (SQLException e1) {  
			e1.printStackTrace();
		}
		TchService tchService = new TchServiceImpl();
		if (!(expID==null&&"".equals(expID))) {

			Work work = new Work(tchNum, ClassCode, expID);
			if(workStartTime != null) {
				work.setStartTime(workStartTime);
			}
			if(workEndTime != null) {
				work.setEndTime(workEndTime);
			}
			if(workName != null) {
				work.setWorkName(workName);
				
			}
			if(workInfo != null) {
				work.setWorkInfo(workInfo);
			}

			try {
				if(tchService.addWork(work)) {				
					request.getRequestDispatcher("teacherPage.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
