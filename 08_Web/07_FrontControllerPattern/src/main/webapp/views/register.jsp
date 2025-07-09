<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원가입</h1>
		<form action="/front" method="post">
		<input type="hidden" name="command" value="register">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		<input type="submit" value="회원가입">
		</form>
		<%-- 1. form 태그 사용해서 작성시작,(회원가입)
			 2. 입력받아야 하니까 input 태그 사용하여 필요한 정보 입력 --%>
	 
		<%-- 회원가입 로직 : 아이디, 비밀번호, 이름, 나이 입력 받아서
							호출 : /register, 방식 : post
							RegisterServlet
							index.jsp로 이동
		 --%>
</body>
</html>