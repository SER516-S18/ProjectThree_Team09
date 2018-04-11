package ser516.project3.client.service;

import java.io.IOException;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ClientController;
import ser516.project3.client.view.ExpressionsGraphObserver;
import ser516.project3.client.view.FaceViewObserver;
import ser516.project3.client.view.HeaderObserver;
import ser516.project3.model.ExpressionsDataObservable;
import ser516.project3.model.FaceExpressionsObservable;
import ser516.project3.model.HeaderObservable;
import ser516.project3.model.PerformanceMetricDataObservable;
import ser516.project3.client.view.PerformanceMetricGraphObserver;
import ser516.project3.client.helper.ClientConnectionThread;

public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ClientConnectionServiceImpl.class);
	Thread clientConnectionThread;
	ClientConnectionThread threadInstance;

	/**
	 * Overridden method that will connect to the server, read and decode the json into
	 * MessageModel bean
	 * 
	 *  @param ipAddress
	 *  @param port
	 *  @param endpoint
	 */
	@Override
	public void createClientConnection(final String ipAddress, final int port, final String endpoint) {

		// Registering the observers on client start
		HeaderObserver headerObserver = new HeaderObserver();
		HeaderObservable.getInstance().addObserver(headerObserver);

		PerformanceMetricGraphObserver performanceMetricObserver = new PerformanceMetricGraphObserver();
		PerformanceMetricDataObservable.getInstance().addObserver(performanceMetricObserver);

		ExpressionsGraphObserver expressionsGraphObserver = new ExpressionsGraphObserver();
		ExpressionsDataObservable.getInstance().addObserver(expressionsGraphObserver);
		
		FaceViewObserver faceViewObserver=new FaceViewObserver();
		FaceExpressionsObservable.getInstance().addObserver(faceViewObserver);
		
		threadInstance = new ClientConnectionThread(ipAddress, port, endpoint);
		clientConnectionThread = new Thread(threadInstance);
		clientConnectionThread.start();
	}

	/**
	 * Overridden method that disconnects the client from the server.
	 */
	@Override
	public void stopClientConnection() {
		try {
			if(threadInstance != null && threadInstance.getClientSession() != null)
				threadInstance.getClientSession().close();
			ClientController.getInstance().setConnectionStatus(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error while stopping client end point::::" + e.getMessage().toString());
		}
		clientConnectionThread.interrupt();
	}

}