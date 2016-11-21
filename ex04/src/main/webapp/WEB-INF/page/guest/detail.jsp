<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style></style>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<table>
		<tr>
			<td>sabun</td>
			<td>${dto.sabun }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>nalja</td>
			<td>${dto.nalja }</td>
		</tr>
		<tr>
			<td>pay</td>
			<td>${dto.pay }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="./update.do?idx=${dto.sabun }">수 정</a>
				<a href="./delete.do?idx=${dto.sabun }">삭 제</a>
			</td>
		</tr>
	</table>
	
</body>
</html>







