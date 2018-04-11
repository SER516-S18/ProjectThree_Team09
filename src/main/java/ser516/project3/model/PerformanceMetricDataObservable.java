package ser516.project3.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * This class holds the data for performance metrics and notifies the observer
 * that shows emotions (performance metrics)
 *
 * @author Manish Tandon
 */
public class PerformanceMetricDataObservable extends Observable {
    private static PerformanceMetricDataObservable instance;
    private ArrayList<ArrayList<CoordinatesModel>> performanceMetricData;

    private PerformanceMetricDataObservable() {
        performanceMetricData = new ArrayList<ArrayList<CoordinatesModel>>();
    }

    public ArrayList<ArrayList<CoordinatesModel>> getPerformanceMetricData() {
        return performanceMetricData;
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
     * @param valueToBeAdded - the new value received from server.
     */
    public void addToListValues(ArrayList<CoordinatesModel> valueToBeAdded) {
        this.performanceMetricData.add(valueToBeAdded);
        setChanged();
        this.notifyObservers();
    }

}
