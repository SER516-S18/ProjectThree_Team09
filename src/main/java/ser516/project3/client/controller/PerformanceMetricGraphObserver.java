package ser516.project3.client.controller;

import java.util.Observable;
import java.util.Observer;

import ser516.project3.client.view.GraphView;
import ser516.project3.model.GraphModel;

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
	/**
	 * 
	 * Overriding the update method in Observer class to update the graph
	 * .
	 */
	@Override
	public void update(Observable observable, Object observerObj) {
		PerformanceMetricDataObservable performanceMetricData = (PerformanceMetricDataObservable) observable;
		GraphModel graphModel = new GraphModel();
		GraphView graphView = new GraphView();
		GraphControllerInterface graphControllerInterface = new GraphControllerImpl(graphModel, graphView);
		graphControllerInterface.setGraphData(performanceMetricData.getPerformanceMetricData());
		graphControllerInterface.updateGraphView();
	}

}
