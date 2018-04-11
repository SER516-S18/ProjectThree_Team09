package ser516.project3.model;

import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Class which notifies the observers if any changes take place which needs to
 * be updated in the header view
 *
 * @author Adhiraj Tikku
 */
public class HeaderObservable extends Observable {
    final static Logger logger = Logger.getLogger(HeaderObservable.class);
    private static HeaderObservable instance;
    private double headerTimeStamp;
    private double interval;

    /**
     * Constructor to initialize the private members
     */
    private HeaderObservable() {
        headerTimeStamp = 0;
    }

    /**
     * Creates a singleton instance . If exists, returns it, else creates it.
     *
     * @return instance of the HeaderObservable
     */
    public static HeaderObservable getInstance() {

        try {
            if (instance == null) {
                instance = new HeaderObservable();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage());
        }
        return instance;

    }

    /**
     * Sets the time stamp value for the header view.
     *
     * @param headerTimeStamp time stamp value for the header view.
     */
    public void setHeaderData(double headerTimeStamp, double interval) {
        this.headerTimeStamp = headerTimeStamp;
        this.interval = interval;
        setChanged();
        notifyObservers();
    }

    /**
     * @return the headerTimeStamp
     */
    public double getHeaderTimeStamp() {
        return headerTimeStamp;
    }

    /**
     * @return the interval
     */
    public double getInterval() {
        return interval;
    }
}
