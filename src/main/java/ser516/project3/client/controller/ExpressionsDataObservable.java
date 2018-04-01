package ser516.project3.client.controller;

import java.util.ArrayList;
import java.util.Observable;

import ser516.project3.model.CoordinatesModel;

/**
 * 
 * This class holds the data for expressions and notifies the observer
 * that shows expressions 
 * 
 * @author Manish Tandon
 *
 */
public class ExpressionsDataObservable extends Observable {

	private ArrayList<ArrayList<CoordinatesModel>> expressionsData;

	private static ExpressionsDataObservable instance;

	private ExpressionsDataObservable() {
		expressionsData = new ArrayList<ArrayList<CoordinatesModel>>();
	}

	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the ExpressionsDataObservable
	 */
	public static ExpressionsDataObservable getInstance() {
		if (instance == null) {
			instance = new ExpressionsDataObservable();
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
		this.expressionsData.add(valueToBeAdded);
		setChanged();
		this.notifyObservers();
	}
}
