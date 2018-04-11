package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Class to update the header view of the controller
 *
 * @author Adhiraj Tikku, vishakhasingal
 */
public class HeaderModel implements ModelInterface {

    private boolean connectionStatus;
    private double timeStamp;

    /**
     * @return the connectionStatus
     */
    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    /**
     * @param connectionStatus the connectionStatus to set
     */
    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    /**
     * @return the timeStamp
     */
    public double getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(double timeStamp) {
        this.timeStamp = timeStamp;
    }


}
