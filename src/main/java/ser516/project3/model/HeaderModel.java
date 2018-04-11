package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

public class HeaderModel implements ModelInterface {
  private boolean connectionStatus;
  private double timeStamp;

  public boolean isConnectionStatus() {
    return connectionStatus;
  }

  public void setConnectionStatus(boolean connectionStatus) {
    this.connectionStatus = connectionStatus;
  }

  public double getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(double timeStamp) {
    this.timeStamp = timeStamp;
  }
}
