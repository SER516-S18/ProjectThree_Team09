package ser516.project3.client.service;

import java.io.IOException;

import org.apache.log4j.Logger;

import ser516.project3.model.ExpressionsDataObservable;
import ser516.project3.model.FaceExpressionsObservable;
import ser516.project3.model.HeaderObservable;
import ser516.project3.model.PerformanceMetricDataObservable;
import ser516.project3.client.controller.ClientControllerFactory;
import ser516.project3.client.helper.ClientConnectionThread;
import ser516.project3.client.observers.ExpressionsGraphObserver;
import ser516.project3.client.observers.FaceViewObserver;
import ser516.project3.client.observers.HeaderObserver;
import ser516.project3.client.observers.PerformanceMetricGraphObserver;

/**
 * Class to register the client and connect it to the server. Also, updates the observers whenever
 * the data is received from server
 *
 * @author Adhiraj Tikku
 *
 */
public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {
	final static Logger logger = Logger.getLogger(ClientConnectionServiceImpl.class);
	Thread clientConnectionThread;
	ClientConnectionThread threadInstance;

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

	@Override
	public void stopClientConnection() {
		try {
			if(threadInstance != null && threadInstance.getClientSession() != null)
				threadInstance.getClientSession().close();
			ClientControllerFactory.getInstance().getClientController().setConnectionStatus(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error while stopping client end point::::" + e.getMessage().toString());
		}
		clientConnectionThread.interrupt();
	}

}