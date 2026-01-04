<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testLogin</title>
</head>
<body>
	<form action="loginProc" method="post">
		이메일: <input type="email" name="email">
		비밀번호: <input type="password" name="passwd">
		<input type="submit" name="btn" value="login">&nbsp;&nbsp;
		<input type="submit" name="btn" value="register">&nbsp;&nbsp;
	</form>
</body>
</html>