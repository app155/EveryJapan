<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.globalin.chat.ChatRoomVO"%>
<%@page import="com.globalin.chat.ChatRoomDAO"%>
<%@page import="java.util.List"%>  
<%
Long loginId = (Long)session.getAttribute("loginId");
String username = (String)session.getAttribute("username");
List<ChatRoomVO> rooms = ChatRoomDAO.getInstance().getAllRoomsById(loginId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test chat</title>
<style>
	.modal { display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0,0,0,0.5); z-index: 999; }
    .modal-content { background: white; margin: 20% auto; width: 300px; padding: 20px; border-radius: 10px; text-align: center; }
</style>
</head>
<body>
loginId = <%=loginId %>
<%=username %>님 안녕하세요. 채팅페이지입니다.

<div>
	<table>
		<tr>
			<td>소속된 채팅방 목록: </td>
		</tr>
		<%
		for (int i = 0; i < rooms.size(); i++) {
		%>
			<tr>
				<td>
					<a href="/chat/chatroom?roomId=<%=rooms.get(i).getRoomId() %>"><b><%=rooms.get(i).getRoomName() %></b><br></a>
					<!-- 채팅방 마지막메시지넣기ㅣㅣㅣㅣ -->
				</td>
			<tr>
		<%
		}
		%>
	</table>
</div>

<button onclick="openModal()">채팅방 생성</button>

<div id="myModal" class="modal">
    <div class="modal-content">
    		<form action="createRoomProc" method="post">
    			<h3>채팅 생성</h3>
        		<p>
        			채팅 생성하기<br>
	        		<input type="text" id="roomNameInput" placeholder="채팅방 이름 입력" name="roomName"><br>
	        		익명채팅여부 <input type="checkbox" name="isAnonymous"><br>
	        		방 종류
	        		<select name="roomType">
	        			<option>Direct</option>
	        			<option>Group</option>
	        			<option>Anonymous</option>
	        		</select>
        		</p>
        
        		<input type="submit" value="방 생성">
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
</script>
</body>
</html>