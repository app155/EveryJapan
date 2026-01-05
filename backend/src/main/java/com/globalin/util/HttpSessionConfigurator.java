package com.globalin.util;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		 HttpSession httpSession = (HttpSession)request.getHttpSession();
        if (httpSession != null) {
            // HttpSession의 정보를 저장한다. 개ㅓㅇ렵네ㅣㄴ짜;;;
            sec.getUserProperties().put("username", (String)httpSession.getAttribute("username"));
            sec.getUserProperties().put("loginId", (long)httpSession.getAttribute("loginId"));
        }
	}
}
