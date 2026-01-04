<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Long loginId = (Long)session.getAttribute("loginId");
String username = (String)session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
테스트메인페이지입니다.
loginId= <%=loginId %>
<%=username %>님 환영합니다.

<button onclick="location.href='/chat/chat'">채팅페이지로</button>
</body>
</html>