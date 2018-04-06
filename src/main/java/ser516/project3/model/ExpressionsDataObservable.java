package ser516.project3.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * 
 * This class holds the data for expressions and notifies the observer
 * that shows expressions 
 * 
 * @author Manish Tandon
 *
 */
public class ExpressionsDataObservable extends Observable {
	private static ExpressionsDataObservable instance;
	private ArrayList<ArrayList<CoordinatesModel>> expressionsData;

	private ExpressionsDataObservable() {
		expressionsData = new ArrayList<ArrayList<CoordinatesModel>>();
	}

	public ArrayList<ArrayList<CoordinatesModel>> getExpressionsData() {
		return expressionsData;
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
