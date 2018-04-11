package ser516.project3.server.service;

import org.apache.log4j.Logger;

import ser516.project3.constants.ServerConstants;
import ser516.project3.server.controller.ServerController;
import ser516.project3.server.helper.ServerContainerThread;
/**
 * This is the Service class responsible for creating threads
 * for web socket and closing of these threads
 * @author vsriva12
 *
 */
public class ServerConnectionServiceImpl implements ServerConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ServerConnectionServiceImpl.class);
	Thread serverContainerThread;
	ServerContainerThread threadInstance;

	/**
	 * Method responsible for creating threads
	 * for web socket
	 */
	@Override
	public void initServerEndpoint() {
		threadInstance = new ServerContainerThread();
		serverContainerThread = new Thread(threadInstance);
		serverContainerThread.start();
		ServerController.getInstance().getConsoleController().getConsoleModel().
			logMessage(ServerConstants.SERVER_STARTED);
	}
	
	/**
	 * Method responsible for closing any thread instance
	 */
	@Override
	public void stopServerEndpoint() {
		if(threadInstance != null || serverContainerThread != null) {
			threadInstance.getServer().stop();
			ServerController.getInstance().getConsoleController().getConsoleModel().
				logMessage(ServerConstants.SERVER_STOPPED);
			serverContainerThread.interrupt();
		}
		ServerController.getInstance().getTopController().getTopModel().setServerStarted(false);
		ServerController.getInstance().getTopController().getTopModel().
			setSendButtonEnabled(false);
		ServerController.getInstance().getTopController().getTopModel().
			setServerStartStopButtonText(ServerConstants.START_SERVER);
		ServerController.getInstance().getTopController().updateServerStartStopButtonText();
		ServerController.getInstance().getTopController().updateEnableDisableSendButton();
		ServerController.getInstance().getTopController().setBlinking(false);
	}
}
