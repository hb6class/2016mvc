package com.mvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;
import com.mvc2.model.GuestVo;

public class DetailImp implements InterController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		String param = req.getParameter("idx");
		// null~~~~~
		int sabun = Integer.parseInt(param.trim());
		GuestDao dao = new GuestDao();
		GuestVo vo=dao.selectOne(sabun);
		req.setAttribute("dto", vo);
		return "guest/detail";
	}

}
