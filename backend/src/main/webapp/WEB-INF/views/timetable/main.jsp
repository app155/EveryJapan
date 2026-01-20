<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="selectedTable"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="/style/style.css" rel="stylesheet">
<script>
function selectTable(table) {
	// 여기서 selectedTable에 값 넘겨주기 가능???????????????????????????????????????
}
</script>
</head>
<body>
	<%@ include file="../sub/top.jsp" %>
	<div class="timetable-layout">
		<aside class="timetable-sidebar">
			<h2>${username }님의 시간표</h2>
			
			<c:forEach var="table" items="${tables }">
				<button onclick="">${tables.name }</button>
			</c:forEach>
			<button onclick="location.herf='/timetable/createTimetable'">새 시간표 생성</button>
		</aside>
		<main class="timetable-main">
			<div class="timetable-table">
				선택된 시간표: ${selectedTable }
			</div>
		</main>
	</div>
</body>
</html>