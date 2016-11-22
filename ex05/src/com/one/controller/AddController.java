package com.one.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;


@WebServlet("/add.do")
public class AddController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object[] obj= new Object[3];
		int cnt =0;
		Enumeration<String> pnm = request.getParameterNames();
		while(pnm.hasMoreElements()){
			String param=pnm.nextElement();
			//System.out.println(param+":"+request.getParameter(param));
			obj[cnt++]=request.getParameter(param);
		}
		GuestDao dao = new GuestDao();
		dao.insertOne(obj);
	}

}
