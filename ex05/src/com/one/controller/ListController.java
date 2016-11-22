package com.one.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;
import com.one.model.GuestVo;

@WebServlet("/list.do")
public class ListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDao dao = new GuestDao();
		List<GuestVo> list = dao.listAll();
		
//		request.setAttribute("alist", list);
//		request.getRequestDispatcher("/page/list.jsp").forward(request, response);
		int cnt=0;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); //fixed
		PrintWriter out = response.getWriter();
		out.print("{\"tlist\":[");
		for(GuestVo bean:list){
			if(cnt!=0)out.print(",");
			out.print(bean);
			cnt++;
		}
		out.print("]}");
//		System.out.println();
	}

}








