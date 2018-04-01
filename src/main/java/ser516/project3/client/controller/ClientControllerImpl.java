package ser516.project3.client.controller;

import ser516.project3.client.service.ClientConnectionServiceImpl;
import ser516.project3.client.service.ClientConnectionServiceInterface;
import ser516.project3.constants.ClientConstants;

public class ClientControllerImpl implements ClientControllerInterface {
	private boolean connected = false;
	ClientConnectionServiceInterface clientConnectionService;

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
	public void toggleConnectionToServer(String ipAddress, int port) {
		if (connected) {
			clientConnectionService.stopClientConnection();
			connected = false;
			// TODO: Find a way to stop the client container
		} else {
			clientConnectionService = new ClientConnectionServiceImpl();
			clientConnectionService.createClientConnection(ipAddress, port, ClientConstants.ENDPOINT);
			connected = true;
		}
	}

	@Override
	public void stopClientConnector() {
		clientConnectionService.stopClientConnection();
		connected = false;
	}

}
