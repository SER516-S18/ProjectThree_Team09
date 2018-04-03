package ser516.project3.server.service;

import org.apache.log4j.Logger;

import ser516.project3.model.ConsoleModel;
import ser516.project3.server.helper.ServerContainerThread;
import ser516.project3.utilities.ServerCommonData;

public class ServerConnectionServiceImpl implements ServerConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ServerConnectionServiceImpl.class);
	Thread serverContainerThread;
	ServerContainerThread threadInstance;

	@Override
	public void initServerEndpoint() {
		threadInstance = new ServerContainerThread();
		serverContainerThread = new Thread(threadInstance);
		serverContainerThread.start();
		ConsoleModel.getInstance().logMessage("Success! Yippieee!");
	}

	@Override
	public void stopServerEndpoint() {
		threadInstance.getServer().stop();
		serverContainerThread.interrupt();
		ServerCommonData.getInstance().setServerStarted(false);
	}

}
