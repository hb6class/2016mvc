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

	<h1>${title } 페이지</h1>
	<form method="post">
	<p>
		<label for="sabun">sabun</label>
		<input type="text" name="sabun" id="sabun" value="${dto.sabun }" />
	</p>
	<p>
		<label for="name">name</label>
		<input type="text" name="name" id="name" value="${dto.name }" />
	</p>
	<p>
		<label for="pay">pay</label>
		<input type="text" name="pay" id="pay" value="${dto.pay }" />
	</p>
	<p>
		<button type="submit">${title }</button>
		<button type="reset">취소</button>
	</p>
	</form>
</body>
</html>








