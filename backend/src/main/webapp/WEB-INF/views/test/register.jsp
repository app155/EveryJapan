<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="registerProc" method="post">
	<table width="500">
		<tr>
			<td width="100">이메일: </td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td width="100">비밀번호: </td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td width="100">닉네임: </td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td width="100">대학: </td>
			<td><input type="text" name="university"></td>
		</tr>
		<tr>
			<td width="100">학년: </td>
			<td><input type="text" name="grade"></td>
		</tr>
		<tr>
			<td width="100">전공: </td>
			<td><input type="text" name="major"></td>
		</tr>
		<tr>
			<td width="100">학번: </td>
			<td><input type="text" name="studentId"></td>
		</tr>
	</table>
	<input type="submit" value="회원가입">
</form>
</body>
</html>