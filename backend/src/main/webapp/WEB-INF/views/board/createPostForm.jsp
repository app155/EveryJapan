<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
게시글작성 만들기...

<div align="center">
	<form action="createPostProc" method="post">
		<input type="hidden" name="authorId" value="${loginId }">
		<table width="60%">
			<tr>
				<td>
					<input type="text" name="category" placeholder="글 카테고리">
				</td>
				<td>
					<input type="text" name="title" size="200" placeholder="제목을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="20" cols="20" name="content" placeholder="본문을 입력해 주세요."></textarea>
				</td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="글 작성"></td>
				<td align="left"><input type="button" value="돌아가기" onclick="javascript:history.go(-1)"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>