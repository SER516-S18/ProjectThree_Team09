package ser516.project3.client.controller;

public class ClientControllerImpl implements ClientControllerInterface {

	@Override
	public void startClient() {
		// TODO: start data reception form server

		// Registering the observer on client start
		PerformanceMetricGraphObserver performanceMetricObserver = new PerformanceMetricGraphObserver();
		PerformanceMetricDataObservable.getInstance().addObserver(performanceMetricObserver);

	}

}
