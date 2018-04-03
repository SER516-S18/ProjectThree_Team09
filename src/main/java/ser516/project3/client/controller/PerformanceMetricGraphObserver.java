package ser516.project3.client.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import ser516.project3.model.CoordinatesModel;

/**
 * 
 * This class observes data changes in performance metrics data set and informs
 * the Graph object to populate new incoming data and repaint/update the user
 * interface graph element.
 * 
 * @author Manish Tandon
 *
 */
public class PerformanceMetricGraphObserver implements Observer {

	final static Logger logger = Logger.getLogger(PerformanceMetricGraphObserver.class);

	/**
	 * 
	 * Overriding the update method in Observer class to update the graph .
	 */
	@Override
	public void update(Observable observable, Object observerObj) {

		PerformanceMetricDataObservable performanceMetricData = (PerformanceMetricDataObservable) observable;
		ArrayList<ArrayList<CoordinatesModel>> pmd = performanceMetricData.getPerformanceMetricData();
		logger.info("test data");


		GraphControllerInterface graphControllerInterface = ClientControllerImpl.getInstance()
				.getPerformanceMetricController().getGraphController();

		graphControllerInterface.setGraphData(performanceMetricData.getPerformanceMetricData());
		graphControllerInterface.updateGraphView();

		ClientControllerImpl.getInstance().getPerformanceMetricController().getPerformanceMetricView().revalidate();
		ClientControllerImpl.getInstance().getPerformanceMetricController().getPerformanceMetricView().repaint();
	}

}
