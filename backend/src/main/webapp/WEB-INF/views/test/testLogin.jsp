<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testLogin</title>
<link href="/style/style.css?after" rel="stylesheet">
</head>
<body>
	<form action="loginProc" method="post">
		<div class="table-wrap">
			<table class="clean-table">
				<tr>
					<td colspan="2">이메일: <input type="email" name="email" value="${email }"></td>
				</tr>
				<tr>
					<td colspan="2">비밀번호: <input type="password" name="passwd"></td>
				</tr>
				<c:if test="${error != null }">
					<tr>
						<td colspan="2"><font color="red">${error }</font></td>
					</tr>
				</c:if>
				<tr>
					<td class="cell-actions"><input type="submit" name="btn" value="login"></td>
					<td><input type="submit" name="btn" value="register"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>