package ser516.project3.server.service;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import ser516.project3.model.Message;
import ser516.project3.model.MessageEncoder;

@ServerEndpoint(value = "/server", encoders = { MessageEncoder.class })
public class ServerConnectionEndpoint {

	@OnOpen
	public void onOpen(final Session session) throws IOException {
		try {
			//TODO: Here the logic is to start sending the message json based on the value of auto send flag
			//TODO: If the flag is false, just send the json once, else keep sending based on the interval
			session.getBasicRemote().sendObject(new Message());
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		try {
			//TODO: We have to write logic of what to do when we receive message from the client
			session.getBasicRemote().sendObject(new Message());
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("onClose: " + closeReason);
		try {
			session.getBasicRemote().sendText("Connection closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError: " + t);
	}
}