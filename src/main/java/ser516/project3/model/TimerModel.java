package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Stores data for the time elapsed interval in the server
 *
 * @author Raviteja
 */
public class TimerModel implements ModelInterface {
    private double timeElapsed;

    /**
     * Gets the time elapsed since the server is running.
     *
     * @return the time elapsed since the server is running
     */
    public double getTimeElapsed() {
        return timeElapsed;
    }

    /**
     * Sets the time elapsed since the server is running.
     *
     * @param timeElapsed the time elapsed since the server is running
     */
    public void setTimeElapsed(double timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}