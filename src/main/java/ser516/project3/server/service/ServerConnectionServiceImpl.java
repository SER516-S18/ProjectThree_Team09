package ser516.project3.server.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.glassfish.tyrus.server.Server;

public class ServerConnectionServiceImpl implements ServerConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ServerConnectionServiceImpl.class);
	private static final int PORT = 1516;
	private Server server;

	@Override
	public void initServerEndpoint() {
		server = new Server("localhost", PORT, "", null, ServerConnectionEndpoint.class);
		try {
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			reader.readLine();
		} catch (Exception e) {
			logger.error("Error occurred while trying to start the server websocket::::" + e.getStackTrace());
		} finally {
			server.stop();
		}
	}

	@Override
	public void stopServerEndpoint() {
		server.stop();
	}

	/**
	 * Just for testing purposes
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ServerConnectionServiceImpl obj = new ServerConnectionServiceImpl();
		obj.initServerEndpoint();

	}

}
