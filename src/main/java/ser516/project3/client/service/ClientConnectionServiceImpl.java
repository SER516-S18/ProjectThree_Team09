package ser516.project3.client.service;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {

	private static final int PORT = 1516;
	private static CountDownLatch messageLatch;
	private static final String SENT_MESSAGE = "Hello World";

	@Override
	public void createClientConnection() {
		try {
			messageLatch = new CountDownLatch(1);

			final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();

			ClientManager client = ClientManager.createClient();
			client.connectToServer(new Endpoint() {

				@Override
				public void onOpen(Session session, EndpointConfig config) {
					try {
						session.addMessageHandler(new MessageHandler.Whole<String>() {

							@Override
							public void onMessage(String message) {
								System.out.println("Received message: " + message);
								messageLatch.countDown();
							}
						});
						session.getBasicRemote().sendText(SENT_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}, cec, new URI("ws://localhost:"+PORT+"/server"));
			messageLatch.await(100, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Just for testing purposes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientConnectionServiceImpl().createClientConnection();
	}

}
