package com.one.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;
import com.one.model.GuestVo;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sabun = Integer.parseInt(request.getParameter("sabun"));
		GuestDao dao = new GuestDao();
		GuestVo bean = dao.selectOne(sabun);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); //fixed
		PrintWriter out = response.getWriter();
		out.print("{\"detail\":["+bean+"]}");
	}

}
