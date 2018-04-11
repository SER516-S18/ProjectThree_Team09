package ser516.project3.client.helper;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ControllerFactory;
import ser516.project3.constants.ClientConstants;

/**
 * Thread class to create a client web socket end point
 * @author User
 *
 */
public class ClientConnectionThread implements Runnable {

	final static Logger logger = Logger.getLogger(ClientConnectionThread.class);

	private static CountDownLatch messageLatch;

	private String ipAddress;

	private int port;

	private String endpoint;
	
	private WebSocketContainer container;
	
	private Session clientSession;

	/**
	 * Parameterized constructor with connection details
	 * @param ipAddress - host name of the server
	 * @param port - the port of the server
	 * @param endpoint - The URI end point of the web socket
	 */
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
			clientSession = container.connectToServer(ClientConnectionEndpoint.class, URI.create(uri));
			messageLatch.await(0, TimeUnit.SECONDS);
			ControllerFactory.getInstance().getClientController().setConnectionStatus(true);
		} catch (DeploymentException | IOException | InterruptedException e) {
			logger.error("Exception occurred in createClientConnection method::::" + e.getMessage().toString());
			ControllerFactory.getInstance().getClientController().setConnectionStatus(false);
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, ClientConstants.NO_CONNECTION_MESSAGE,ClientConstants.ERROR_STRING,JOptionPane.ERROR_MESSAGE);
		}

	}

	/**Method to get ClientSession
	 * @return the clientSession
	 */
	public Session getClientSession() {
		return clientSession;
	}

	/**
	 * @param clientSession the clientSession to set
	 */
	public void setClientSession(Session clientSession) {
		this.clientSession = clientSession;
	}
	
}
