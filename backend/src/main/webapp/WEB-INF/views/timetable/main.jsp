<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="selectedTable"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
<link href="/style/style.css" rel="stylesheet">
<script>
	function selectTable(tableId, tableName) {
		let selectTableId = tableId;
		let selectTableName = tableName;

		document.querySelector('.timetable-main h2').textContent = selectTableName;
	}
</script>
</head>
<body>
	<%@ include file="../sub/top.jsp"%>
	<div class="timetable-layout">
		<aside class="timetable-sidebar">
			<form action="main" method="post">
				<input type="hidden" name="loginId" value="${loginId }">
				<h2>${username }님의 시간표 ${loginId }</h2>

				<c:forEach var="table" items="${tables }">
					<button type="button" onclick="selectTable('${table.timetableId }', '${table.name }')">${table.name }</button>
				</c:forEach>
				<button>새 시간표 생성</button>
			</form>
		</aside>
		<main class="timetable-main">
			<h2 align="center">시간표를 선택해주세요.</h2>
			<div class="timetable-board">
				<table class="timetable-table">
			        <thead>
            				<tr>
               				<th>시간</th>
                				<th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
            				</tr>
        				</thead>
        				<tbody>
        					<tr>
        						<td>09</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>10</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>11</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>12</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>13</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>14</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>15</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>16</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>17</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        					<tr>
        						<td>18</td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        						<td></td>
        					</tr>
        				</tbody>
				</table>
			</div>
		</main>
	</div>
</body>
</html>