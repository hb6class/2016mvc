package com.mvc2.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.controller.AddController;
import com.mvc2.controller.CMDimp;
import com.mvc2.controller.IndexController;
import com.mvc2.controller.ListController;
import com.mvc2.controller.OneController;

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
		String srvPath = request.getServletPath();
		System.out.println(srvPath);
		
		CMDimp imp = null;
		
		// 按眉 包府(Spring - HandlerMapping)
		if(srvPath.equals("/")){
			imp = new IndexController();
		}else if(srvPath.equals("/list.do")){
			imp = new ListController();
		}else if(srvPath.equals("/add.do")){
			imp = new AddController();
		}else if(srvPath.equals("/One.do")){
			imp = new OneController();
		}
		
		// controller急琶 角青(Spring - Adapter)
		String url = imp.execute(request, response);
		
		// view甫 包府(Spring - ViewResolver)
		String prefix="/WEB-INF/page/";
		String suffix=".jsp";
		url = prefix+url+suffix;
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}












