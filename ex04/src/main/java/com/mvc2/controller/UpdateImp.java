package com.mvc2.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;
import com.mvc2.model.GuestVo;

public class UpdateImp implements InterController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		if(req.getMethod().equals("GET")){
			int sabun=Integer.parseInt(req.getParameter("idx"));
			GuestDao dao = new GuestDao();
			GuestVo vo = dao.selectOne(sabun);
			req.setAttribute("title", "¼öÁ¤");
			req.setAttribute("dto", vo);
			return "guest/add";
		}
		String[] params= new String[3];
		int idx=0;
		Enumeration<String> pNm = req.getParameterNames();
		while(pNm.hasMoreElements()){
			String name = pNm.nextElement();
			if(name.equals("idx"))continue;
			params[idx++]=req.getParameter(name);
		}
		int sabun = Integer.parseInt(params[0]);
		String name = params[1];
		int pay = Integer.parseInt(params[2]);
		GuestVo vo = new GuestVo(sabun, name, null, pay);
		GuestDao dao = new GuestDao();
		dao.updateOne(vo);
		return "guest/result";
	}

}







