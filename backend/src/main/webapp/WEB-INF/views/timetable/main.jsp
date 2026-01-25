<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="selectedTable" value=""></c:set>
<c:set var="times" value="${fn:split('09,10,11,12,13,14,15,16,17,18', ',')}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
<link href="/style/style.css" rel="stylesheet">
<script>
	let selectTableId = null;
	let selectTableName = null;
	
	function selectTable(tableId, tableName) {
		selectTableId = tableId;
		selectTableName = tableName;
		
		const box = document.getElementById('subject-search-box');
		box.style.display = 'none';

		document.querySelector('.timetable-main h2').textContent = selectTableName;
		const btns = document.getElementsByClassName("btn-add-subject");
		
		for (const btn of btns) {
			btn.style.display = 'block';
		}

		<c:set var="selectedTable" value="${tables.get(tableId) }"></c:set>
		<c:set var="subjects" value="${selectedTable.subjects }"></c:set>
		
		let tempSubjects = [];
		
		<c:forEach var="subject" items="${subjects }">
			tempSubjects.push(${subject });
		</c:forEach>
		
		<c:set var="temp" value="${tempSubjects }"></c:set>
		
		fetch('/timetable/' + tableId + '/subjects')
		.then(res => res.json())
		.then(subjects => {
			drawTimetable(subjects);
		})
		.catch(err => console.error(err));
	}
	
	function drawTimetable(subjects) {
		const tbody = document.querySelector('.timetable-table tbody');
		tbody.innerHTML = '';
		
		const times = [09,10,11,12,13,14,15,16,17,18];
		
		times.forEach(time=> {
			const tr = document.createElement('tr');
			
			const timeTd = document.createElement('td');
			timeTd.textContent = time + ':00';
			tr.appendChild(timeTd);
			
			for (let day = 0; day < 5; day++) {
				const td = document.createElement('td');
				
				const subject = subjects.find(s => 
				s.day === day && 
				time >= parseInt(s.startTime.substring(0, 2)) && 
				time < parseInt(s.endTime.substring(0, 2))
				);
				
				if (subject) {
					const div = document.createElement('div');
					div.className = 'subject-cell';
					div.onclick = () => deleteToTimetable(subject.subjectId);
					console.log(subject.name);
					console.log("time: " + time);
					console.log("startTime: " + subject.startTime.substring(0, 2));
					console.log(time == parseInt(subject.startTime.substring(0, 2)));
					console.log("과목발견");
					
					if (time === parseInt(subject.startTime.substring(0, 2))) {
						console.log("시작셀");
						
						div.innerHTML = 
							subject.name + '<br>' + 
							subject.startTime.substring(0, 5) + '~' + subject.endTime.substring(0, 5);
					}
					
					td.append(div);
				}
				
				tr.append(td);
			}
			
			tbody.appendChild(tr);
		});
	}
	
	function toggleSearchBox() {
		const box = document.getElementById('subject-search-box');
	    box.style.display = 'block';
	    const result = document.getElementById('search-result');
	    
	    fetch('/timetable/subjects')
	    .then(res => res.json())
	    .then(subjects => {
	    		renderSearchResult(subjects)
	    });
	}
	
	function searchSubject(e) {
	    e.preventDefault();
	    const form = e.target;
	    const keyword = form.keyword.value;
	    const day = form.day.value;

	    console.log('검색:', keyword, day);
	    // TODO: fetch('/timetable/searchSubject?...')로 Ajax 호출 후
	    // #search-result 안에 과목 리스트 렌더링
		
	    fetch('/timetable/subjects')
	    .then(res => res.json())
	    .then(subjects => {
	    		renderSearchResult(subjects)
	    });
	    
	    
	    return false;
	}
	
	function renderSearchResult(subjects) {
		const resultDiv = document.getElementById('search-result');
		
		if (subjects.length == 0) {
			resultDiv.innerHTML = '<div><font color="red">검색 결과가 없습니다.</font></div>'
			return;
		}
		
		let html = '';
		subjects.forEach(subject => {
			console.log('과목명: ' + subject.name);
			
			html += 
				'<div class="search-result-item">' +
					/* '<div>' + */
						'<button onclick="addToTimetable(' + subject.subjectId + ')">' +
							'<strong>' + subject.name + '</strong><br>' +
							'<small>' +
								(subject.professor || '미정') + '<br>' + 
								subject.startTime.substring(0, 5) + ' ~ ' + subject.endTime.substring(0, 5) + '<br>' +
								subject.credit + '학점' +
							'</small>' +
						'</button>' +
					/* '</div>' + */
				'</div>'
			;
		});
		
		resultDiv.innerHTML = html;
	}
	
	function addToTimetable(subjectId) {
		const currentTimetableId = selectTableId;
		
		console.log('선택된 테이블 아이디: ' + currentTimetableId);
		console.log('선택된 테이블 이름: ' + selectTableName);
		
		fetch('/timetable/' + selectTableId + '/subject', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				subjectId: subjectId
			})
		})
		.then(res => res.json())
		.then(result => {
			if (result.success) {
				selectTable(selectTableId, selectTableName);
			}
		})
		.catch(err => {
			console.error(err);
			alert('시간표에 과목 추가 실패...');
		});
	}
	
	function deleteToTimetable(subjectId) {
		fetch('/timetable/' + selectTableId + '/delSubject', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				subjectId: subjectId
			})
		})
		.then(res => res.json())
		.then(result => {
			if (result.success) {
				selectTable(selectTableId, selectTableName);
			}
		})
		.catch(err => {
			console.error(err);
			alert('시간표에 과목 삭제 실패...');
		});
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
				<div style="display: flex; gap: 10px;">
					<button type="button" class="btn-add-subject" onclick="toggleSearchBox()">과목 추가</button>&nbsp;&nbsp;
					<button type="button" class="btn-add-subject" onclick="saveTimeTable()">시간표 저장</button>
				</div>
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