package ser516.project3.server.service;

import org.apache.log4j.Logger;

import ser516.project3.model.ConsoleModel;
import ser516.project3.server.controller.ServerController;
import ser516.project3.server.helper.ServerContainerThread;

public class ServerConnectionServiceImpl implements ServerConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ServerConnectionServiceImpl.class);
	Thread serverContainerThread;
	ServerContainerThread threadInstance;

	@Override
	public void initServerEndpoint() {
		threadInstance = new ServerContainerThread();
		serverContainerThread = new Thread(threadInstance);
		serverContainerThread.start();
		ServerController.getInstance().getConsoleController().getConsoleModel().logMessage("Server Started");
	}

	@Override
	public void stopServerEndpoint() {
		if(threadInstance != null || serverContainerThread != null) {
			threadInstance.getServer().stop();
			ServerController.getInstance().getConsoleController().getConsoleModel().logMessage("Server Stopped");
			serverContainerThread.interrupt();
		}
		ServerController.getInstance().getTopController().getTopModel().setServerStarted(false);
		ServerController.getInstance().getTopController().getTopModel().setSendButtonEnabled(false);
		ServerController.getInstance().getTopController().getTopModel().setServerStartStopButtonText("Start Server");
		ServerController.getInstance().getTopController().updateServerStartStopButtonText();
		ServerController.getInstance().getTopController().updateEnableDisableSendButton();
		ServerController.getInstance().getTopController().setBlinking(false);
	}

}
