<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
roomId ${roomId } 채팅방입니다.

<script>
window.onload = function() {
    connectToRoom(${roomId });
};
</script>
<h2>🗣️ 실시간 채팅(ws://localhost:8080/chat)</h2> <!-- 앞의 ws://가 꼭 붙어야 함 -->
<div id="messages"></div>
<input id="input" type="text" placeholder="메시지 입력...." onkeypress="if(event.keyCode==13)sendMessage()">
<button onclick="sendMessage()">전송</button>
<button onclick="openModal()">인원 추가</button><br>
<button onclick="ws.close()">연결 종료</button>

<div id="myModal" class="modal">
    <div class="modal-content">
    		<form action="inviteToRoom" method="post">
    			<h3>인원 추가</h3>
        		<p>
        			인원 추가하기<br>
        			<input type="hidden" name="roomId" value="${roomId }">
	        		<input type="email" id="emailInput" placeholder="추가할 인원 이메일 입력" name="email"><br>
        		</p>
        		<input type="submit" value="인원 추가">
        		<input type="button" value="닫기" onclick="closeModal()">
    		</form>
    </div>
</div>

<script>
	function openModal() {
	    document.getElementById('myModal').style.display = 'block';
	}

	function closeModal() {
	    	document.getElementById('myModal').style.display = 'none';
	}

	var ws = null;
	
	// 채팅 영역을 찾아야함.
	var messages = document.getElementById('messages');
	
	function addMessage(msg) {
		messages.innerHTML += 
			'<div class="message.me">' + 
				'<div class="speech-bubble speech-bubble-right">' + 
					'<p align="right">' + new Date().toLocaleTimeString() + '|' + msg + '</p>' + 
				'</div>' + 
			'</div>';
		messages.scrollTop = messages.scrollHeight;
	}
	
	function sendMessage() {
		var input = document.getElementById('input');
		if (ws.readyState !== WebSocket.OPEN) {
			alert("채팅방과 연결되지 않았습니다.");
			return;
		}
			
		if (input.value) {
			ws.send(input.value);
			input.value = '';
		}
		else {
			console.log("WebSocket 상태: " + ws.readyState);  // 1=OPEN, 2=CLOSED
		}
	}
	
	function connectToRoom(roomId) {
		// 이미 연결 시 먼저 연결된 방 연결 해제
		if (ws != null && ws.readyState == WebSocket.OPEN) {
			ws.close();
		}
		
		ws = new WebSocket("ws://localhost:8080/chat?roomId=" + roomId);
		
		// 각 이벤트 핸들러에 메소드 등록
		ws.onopen = function() {
			addMessage(roomId + "방에 ✅연결 성공");
		};
		
		ws.onmessage = function(event) {
			addMessage(event.data);
		};
		
		ws.onclose = function() {
			addMessage("❌ 연결 종료");
		};
		
		ws.onerror = function(error) {
			addMessage("⚠️오류: " + error);
		};
	}

</script>
</body>
</html>