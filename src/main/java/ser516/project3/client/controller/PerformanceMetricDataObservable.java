package ser516.project3.client.controller;

import java.util.ArrayList;
import java.util.Observable;

import org.apache.log4j.Logger;

import ser516.project3.client.view.GraphView;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.model.CoordinatesModel;

/**
 * 
 * This class holds the data for performance metrics and notifies the observer
 * that shows emotions (performance metrics)
 * 
 * @author Manish Tandon
 *
 */
public class PerformanceMetricDataObservable extends Observable {

	final static Logger logger = Logger.getLogger(PerformanceMetricDataObservable.class);
	private ArrayList<ArrayList<CoordinatesModel>> performanceMetricData;

	private PerformanceMetricView performanceMetricView;

	private GraphView graphView;

	public GraphView getGraphView() {
		return graphView;
	}

	public void setGraphView(GraphView graphView) {
		this.graphView = graphView;
	}

	public PerformanceMetricView getPerformanceMetricView() {
		return performanceMetricView;
	}

	public void setPerformanceMetricView(PerformanceMetricView performanceMetricView) {
		this.performanceMetricView = performanceMetricView;
	}

	public ArrayList<ArrayList<CoordinatesModel>> getPerformanceMetricData() {
		return performanceMetricData;
	}

	public void setPerformanceMetricData(ArrayList<ArrayList<CoordinatesModel>> performanceMetricData) {
		this.performanceMetricData = performanceMetricData;

	}

	private static PerformanceMetricDataObservable instance;

	private PerformanceMetricDataObservable() {
		performanceMetricData = new ArrayList<ArrayList<CoordinatesModel>>();
	}

	/**
	 * Creates a singleton instance . If exists, returns
	 * it, else creates it.
	 * 
	 * @return instance of the PerformanceMetricDataObservable
	 */
	public static PerformanceMetricDataObservable getInstance() {
		
		try {
			if (instance == null) {
				instance = new PerformanceMetricDataObservable();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return instance;
		
	}

	/**
	 * On receiving of new data from server, this method inserts them to the common
	 * list and notifies the observers
	 * 
	 * @param valueToBeAdded
	 *            - the new value received from server.
	 */
	public void addToListValues(ArrayList<CoordinatesModel> valueToBeAdded) {
		this.performanceMetricData.add(valueToBeAdded);
		setChanged();
		this.notifyObservers();
	}

}
