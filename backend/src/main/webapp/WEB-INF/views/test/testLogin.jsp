<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testLogin</title>
</head>
<body>
	<form action="loginProc" method="post">
		<table style="width: 400; margin: 0 auto;">
			<tr>
				<td colspan="2">이메일: <input type="email" name="email" value="${email }"></td>
			</tr>
			<tr>
				<td colspan="2">비밀번호: <input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2"><font color="red">${error }</font></td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="btn" value="login">
				</td>
				<td>
					<input type="submit" name="btn" value="register">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>