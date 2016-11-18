package com.mvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterController {

	String execute(HttpServletRequest req, HttpServletResponse res);
}
