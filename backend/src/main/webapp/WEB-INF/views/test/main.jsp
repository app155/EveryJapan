<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../sub/top.jsp" %>
테스트메인페이지입니다.<br>
loginId= ${loginId }<br>
${username }님 환영합니다.<br>

<button onclick="location.href='/board/main'">게시판</button>
<button onclick="location.href='/chat/chat'">채팅페이지로</button>
<button onclick="location.href='/test/logoutProc'">로그아웃</button>
</body>
</html>