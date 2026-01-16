<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="/style/style.css" rel="stylesheet" type="text/css">
<body>
<%@ include file="../sub/top.jsp" %>
${post.postId }번 포스트임.
<div align="center">
	<table width="80%">
		<tr>
			<td colspan="4">[${post.category }] ${post.title }</td>
		<tr>
		<tr>
			<td>${post.author }</td>
			<td>${post.createdAt }</td>
			<td>${post.viewCount }</td>
			<td>${post.likeCount }</td>
		</tr>
		<tr>
			<td colspan="4">${post.content }</td>
		</tr>
	</table>
	<%@ include file="comment.jsp" %>
</div>
</body>
</html>