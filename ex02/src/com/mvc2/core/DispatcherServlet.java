package com.mvc2.core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doDispatcher(request, response);		
	}
	protected void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request, response);
	}
	
}












