package ser516.project3.model;

import java.util.Observable;

public class HeaderObservable extends Observable {
  private static HeaderObservable instance;
  private double headerTimeStamp;
  private double interval;

  private HeaderObservable() {
    headerTimeStamp = 0;
  }

  public double getHeaderTimeStamp() {
    return headerTimeStamp;
  }

  public double getInterval() {
    return interval;
  }

  /**
   * Creates a singleton instance . If exists, returns
   * it, else creates it.
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
      System.out.println(e.getMessage());
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
}
