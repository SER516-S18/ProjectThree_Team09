package ser516.project3.client.helper;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import org.apache.log4j.Logger;

public class ClientConnectionThread implements Runnable {

	final static Logger logger = Logger.getLogger(ClientConnectionThread.class);

	private static CountDownLatch messageLatch;

	private String ipAddress;

	private int port;

	private String endpoint;
	
	private WebSocketContainer container;

	public ClientConnectionThread(final String ipAddress, final int port, final String endpoint) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.endpoint = endpoint;
	}

	@Override
	public void run() {
		messageLatch = new CountDownLatch(1);
		container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://" + ipAddress + ":" + port + "/" + endpoint;
		logger.info("Connecting to " + uri);
		try {
			container.connectToServer(ClientConnectionEndpoint.class, URI.create(uri));
			messageLatch.await(100, TimeUnit.SECONDS);
		} catch (DeploymentException | IOException | InterruptedException e) {
			logger.error("Exception occurred in createClientConnection method::::" + e.getStackTrace().toString());
		}

	}
}
