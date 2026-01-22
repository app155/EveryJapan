<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="selectedTable"></c:set>
<c:set var="times" value="${fn:split('09,10,11,12,13,14,15,16,17,18', ',')}"></c:set>
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
		
		const box = document.getElementById('subject-search-box');
		box.style.display = 'none';

		document.querySelector('.timetable-main h2').textContent = selectTableName;

		<c:set var="selectedTable" value="${tables.get(tableId) }"></c:set>
		<c:set var="subjects" value="${selectedTable.subjects }"></c:set>
		
		let tempSubjects = [];
		
		<c:forEach var="subject" items="${subjects }">
			tempSubjects.push(${subject });
		</c:forEach>
		
		<c:set var="temp" value="${tempSubjects }"></c:set>
		
		
	} 
	
	function toggleSearchBox() {
		const box = document.getElementById('subject-search-box');
	    box.style.display = 'block';
	}
	
	function searchSubject(e) {
	    e.preventDefault();
	    const form = e.target;
	    const keyword = form.keyword.value;
	    const day = form.day.value;

	    console.log('검색:', keyword, day);
	    // TODO: fetch('/timetable/searchSubject?...')로 Ajax 호출 후
	    // #search-result 안에 과목 리스트 렌더링

	    return false;
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
			<div>
				<h2 align="center">시간표를 선택해주세요.</h2>
				<button type="button" class="btn-add-subject" onclick="toggleSearchBox()">과목 추가</button>
			</div>
			<div class="timetable-board">
				<table class="timetable-table">
			        <thead>
            				<tr>
               				<th>시간</th>
                				<th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
            				</tr>
        				</thead>
        				<tbody>
        					<c:forEach var="time" items="${times }">
	   						<tr>
        							<td>${time }:00</td>
        							<c:forEach var="day" begin="0" end="4">
        								<td>
        									<c:forEach var="subject" items="${tempSubjects }">
        										<c:if test="${subject.day == day 
    														&& time == subject.startTime.toLocalTime().getHour() }">
        											<div class="subject-cell">
        												${subject.name }<br>
        												${subject.startTime }~${subject.endTime }
        											</div>
        										</c:if>
        										<c:if test="${subject.day == day 
    														&& time > subject.startTime.toLocalTime().getHour()
    														&& time <= subject.endTime.toLocalTime().getHour() }">
        											<div class="subject-cell">
        												
        											</div>
        										</c:if>
        									</c:forEach>
       								</td>
        							</c:forEach>
	       					</tr>
       					</c:forEach>
        				</tbody>
				</table>
			</div>
			<div id="subject-search-box" class="subject-search-box hidden">
        			<form action="/timetable/searchSubject" method="get" onsubmit="return searchSubject(event)">
            			<div class="search-row">
                			<input type="text" name="keyword" placeholder="과목명 / 교수명 검색">
                			<select name="day">
                    			<option value="">요일</option>
                    			<option value="0">월</option>
                    			<option value="1">화</option>
                    			<option value="2">수</option>
                    			<option value="3">목</option>
                    			<option value="4">금</option>
                			</select>
                			<button type="submit">검색</button>
            			</div>
        			</form>
        			<div id="search-result" class="search-result">
        		    <!-- Ajax로 검색 결과 과목 리스트 보여주기 -->
        			</div>
    			</div>
		</main>
	</div>
</body>
</html>