<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form action="deleteCommentProc" method="post">
	<table>
		<c:forEach var="comment" items="${comments }">
			<tr>
				<td>${comment.userId }&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;${comment.createdAt }</td>
				<c:if test="${comment.userId == loginId }">
					<td><input type="submit" value="x"></td>
					<input type="hidden" name="commentId" value="${comment.commentId }">
					<input type="hidden" name="postId" value="${comment.postId }">
				</c:if>
			</tr>
		</c:forEach>
	</table>
</form>
</html>