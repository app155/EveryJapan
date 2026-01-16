<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/style/style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div align="center">
	<form action="createCommentProc" method="post">
		<input type="hidden" name="postId" value="${post.postId }">
		<input type="hidden" name="userId" value="${loginId }">
		<table>
			<tr>
				<td><textarea rows="2" cols="80" name="content" placeholder="댓글 입력하기"></textarea></td>
				<td><input type="submit" value="댓글 작성">&nbsp;<input type="checkbox" name="isAnonymous">익명댓글</td>	
			</tr>
		</table>
		<table>
			<c:forEach var="comment" items="${comments }">
				<tr>
					<td>
						${comment.userId }&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;${comment.createdAt }
						<input type="button" value="x" onclick="location.href='/board/commentDelProc'">
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
</body>
</html>