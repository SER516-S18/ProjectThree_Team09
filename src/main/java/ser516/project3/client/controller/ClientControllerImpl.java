package ser516.project3.client.controller;

public class ClientControllerImpl implements ClientControllerInterface {

	@Override
	public void startClient() {
		// TODO: start data reception form server

		// Registering the observers on client start
		PerformanceMetricGraphObserver performanceMetricObserver = new PerformanceMetricGraphObserver();
		PerformanceMetricDataObservable.getInstance().addObserver(performanceMetricObserver);
		
		FaceViewObserver faceObserver=new FaceViewObserver();
		ExpressionsDataObservable.getInstance().addObserver(faceObserver);
		
		

	}

}
