package ser516.project3.client.controller;

import ser516.project3.client.service.ClientConnectionServiceImpl;
import ser516.project3.client.service.ClientConnectionServiceInterface;
import ser516.project3.constants.ClientConstants;

public class ClientControllerImpl implements ClientControllerInterface {

	@Override
	public void startClient() {
		// TODO: start data reception form server

		// Registering the observers on client start
		PerformanceMetricGraphObserver performanceMetricObserver = new PerformanceMetricGraphObserver();
		PerformanceMetricDataObservable.getInstance().addObserver(performanceMetricObserver);

		FaceViewObserver faceObserver = new FaceViewObserver();
		ExpressionsDataObservable.getInstance().addObserver(faceObserver);

		ExpressionsGraphObserver expGraphObserver = new ExpressionsGraphObserver();
		ExpressionsDataObservable.getInstance().addObserver(expGraphObserver);

	}

	@Override
	public void connectServer(String ipAddress, int port) {
		ClientConnectionServiceInterface clientConnectionService = new ClientConnectionServiceImpl();
		clientConnectionService.createClientConnection(ipAddress, port, ClientConstants.ENDPOINT);

	}
}
