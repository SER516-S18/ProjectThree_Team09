package ser516.project3.client.view;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ClientController;
import ser516.project3.client.controller.GraphController;
import ser516.project3.model.PerformanceMetricDataObservable;
import ser516.project3.utilities.ControllerFactory;

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

		PerformanceMetricDataObservable performanceMetricDataObservable = (PerformanceMetricDataObservable) observable;

		GraphController graphController = ControllerFactory.getInstance().getPerformanceMetricGraphController();

		graphController.setGraphData(performanceMetricDataObservable.getPerformanceMetricData());
		graphController.updateGraphView();
	}

}
