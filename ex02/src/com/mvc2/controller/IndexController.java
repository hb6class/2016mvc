package com.mvc2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements CMDimp {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("POJO 클래스 실행");
		
		
		return "index";
	}
}
