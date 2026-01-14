<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<%@ include file="../sub/top.jsp" %>
게시판임ㅇㅇ
<div align="center">
	<table width="60%" border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:if test="${posts == null }">
			<tr><td colspan="4" align="center">등록 게시글이 없습니다.</td></tr>
		</c:if>
		<c:forEach var="post" items="${posts }">
			<tr>
				<td width="10%">${post.postId }</td>
				<td width="50%"><a href="/board/post?postId=${post.postId }">${post.title }</a></td>
				<td width="20%">${post.author }</td>
				<td width="20%">${post.createdAt }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div>
		
	</div>
</div>

<input type="button" value="글작성" onclick="location.href='/board/createPostForm'">
</body>
</html>