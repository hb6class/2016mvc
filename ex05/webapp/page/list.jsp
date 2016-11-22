<%@ page import="java.util.*, com.one.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table>
	<tr>
		<td>sabun</td>
		<td>name</td>
		<td>nalja</td>
		<td>pay</td>
	</tr>
	<%
		List<GuestVo> list = (List<GuestVo>)request.getAttribute("alist");
		for(GuestVo bean:list){
	%>
	<tr>
		<td><%=bean.getSabun() %></td>
		<td><%=bean.getName() %></td>
		<td><%=bean.getNalja() %></td>
		<td><%=bean.getPay() %></td>
	</tr>
	<%} %>
</table>