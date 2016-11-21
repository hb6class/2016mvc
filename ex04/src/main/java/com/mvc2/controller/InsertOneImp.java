package com.mvc2.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.model.GuestDao;
import com.mvc2.model.GuestVo;

public class InsertOneImp implements InterController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// GET방식의 경우 입력폼페이지로 
		if(req.getMethod().equals("GET"))return "guest/add";
		// POST방식의 경우 DB에 값 입력후 결과
		GuestDao dao = new GuestDao();
		String[] params = new String[3];
//		params[0]=req.getParameter("sabun");
//		params[1]=req.getParameter("name");
//		params[2]=req.getParameter("pay");
		int idx=0;
		Enumeration<String> pNm = req.getParameterNames();
		while(pNm.hasMoreElements()){
			params[idx++]=req.getParameter(pNm.nextElement());
		}
		int sabun = Integer.parseInt(params[0]);
		String name = params[1];
		int pay = Integer.parseInt(params[2]);
		GuestVo vo = new GuestVo(sabun,name,null,pay);
		System.out.println(vo);
		dao.insertOne(vo);
		return "guest/result";
	}

}
