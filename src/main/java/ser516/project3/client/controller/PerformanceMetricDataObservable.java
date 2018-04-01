package ser516.project3.client.controller;

import java.util.ArrayList;
import java.util.Observable;

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
	private ArrayList<ArrayList<CoordinatesModel>> performanceMetricData;

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
		if (instance == null) {
			instance = new PerformanceMetricDataObservable();
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
