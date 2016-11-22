package com.one.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.model.GuestDao;

@WebServlet("/delete.do")
public class DelController extends HttpServlet {

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String data = br.readLine();//sabun=3333&name=cccc&pay=3000
		StringTokenizer st = new StringTokenizer(data,"=");
		st.nextElement();
		int sabun=Integer.parseInt((String) st.nextElement());
		GuestDao dao = new GuestDao();
		dao.deleteOne(sabun);
	}

}
