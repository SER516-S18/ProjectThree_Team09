package ser516.project3.client.service;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import org.apache.log4j.Logger;

public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ClientConnectionServiceImpl.class);

	private static CountDownLatch messageLatch;

	@Override
	public void createClientConnection(final String ipAddress, final int port, final String endpoint) {
		messageLatch = new CountDownLatch(1);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://" + ipAddress + ":" + port + "/" + endpoint;
		logger.info("Connecting to " + uri);
		try {
			container.connectToServer(ClientConnectionEndpoint.class, URI.create(uri));
			messageLatch.await(100, TimeUnit.SECONDS);
		} catch (DeploymentException | IOException | InterruptedException e) {
			logger.error("Exception occurred in createClientConnection method::::" + e.getStackTrace());
		}
	}

	/**
	 * Just for testing purposes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientConnectionServiceImpl().createClientConnection("localhost", 1516, "server");
	}

}