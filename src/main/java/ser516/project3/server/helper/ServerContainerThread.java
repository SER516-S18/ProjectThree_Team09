package ser516.project3.server.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.glassfish.tyrus.server.Server;

import ser516.project3.constants.ServerConstants;
import ser516.project3.server.controller.ServerController;

/**
 * The thread class for Server Container which initializes the glass fish
 * container to provide environment for the server's web socket to receive
 * connections
 * 
 * @author vsriva12
 *
 */
public class ServerContainerThread implements Runnable {
	final static Logger logger = Logger.getLogger(ServerContainerThread.class);
	private static final int PORT = 1516;
	private Server server;

	@Override
	public void run() {
		server = new Server(ServerConstants.LOCALHOST, PORT, "", null, ServerConnectionEndpoint.class);
		try {
			server.start();
			ServerController.getInstance().getTopController().getTopModel().setServerStarted(true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			reader.readLine();
		} catch (Exception e) {
			logger.error(ServerConstants.ERROR_SERVER_START + e.getMessage());
			ServerController.getInstance().getConsoleController().getConsoleModel()
					.logMessage(ServerConstants.ERROR_SERVER_START);
		} finally {
			server.stop();
			ServerController.getInstance().getTopController().getTopModel().setServerStarted(false);
		}
	}

	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

}
