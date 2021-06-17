package net.madvirus.spring4.chap09.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
// websocket을 구현한 소켓 서버 클래스
	@Override
	public void afterConnectionEstablished(WebSocketSession session) 
			throws Exception {
		System.out.printf("%s 연결 됨\n", session.getId());
	}

	@Override
	protected void handleTextMessage(
			WebSocketSession session, TextMessage message) throws Exception {
		// message 는 클라이언트가 전송한 텍스트 데이터를 담고있고, getPayload메소드를 통해서, 텍스트 데이터를 구할 수 있다.
		System.out.printf("%s로부터 [%s] 받음\n", 
				session.getId(), message.getPayload());
		session.sendMessage(new TextMessage("echo: " + message.getPayload()));
		//send Message 메소드를 이용해서 텍스트 데이터를 전송한다.
	}

	@Override
	public void afterConnectionClosed(
			WebSocketSession session, CloseStatus status) throws Exception {
		System.out.printf("%s 연결 끊김\n", session.getId());
	}

}
