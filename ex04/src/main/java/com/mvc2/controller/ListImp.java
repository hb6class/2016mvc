package com.mvc2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;
import com.mvc2.model.GuestVo;

public class ListImp implements InterController {

	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		GuestDao dao = new GuestDao();
		List list = dao.selectAll();
		req.setAttribute("alist", list);
		return "guest/list";
	}

}
