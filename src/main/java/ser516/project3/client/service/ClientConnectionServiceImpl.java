package ser516.project3.client.service;

import org.apache.log4j.Logger;

import ser516.project3.client.helper.ClientConnectionThread;

public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ClientConnectionServiceImpl.class);
	Thread clientConnectionThread;
	ClientConnectionThread threadInstance;

	@Override
	public void createClientConnection(final String ipAddress, final int port, final String endpoint) {
		threadInstance = new ClientConnectionThread(ipAddress, port, endpoint);
		clientConnectionThread = new Thread(threadInstance);
		clientConnectionThread.start();
	}

	@Override
	public void stopClientConnection(){
		clientConnectionThread.interrupt();
	}

}