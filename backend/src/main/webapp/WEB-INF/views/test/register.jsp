<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/style/style.css" rel="stylesheet">
</head>
<body>
	<form action="registerProc" method="post">
		<div class="table-wrap">
			<table class="clean-table">
				<tr>
					<td>이메일:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>닉네임:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>대학:</td>
					<td><input type="text" name="university"></td>
				</tr>
				<tr>
					<td>학년:</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>전공:</td>
					<td><input type="text" name="major"></td>
				</tr>
				<tr>
					<td>학번:</td>
					<td><input type="text" name="studentId"></td>
				</tr>
			</table>
			<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>