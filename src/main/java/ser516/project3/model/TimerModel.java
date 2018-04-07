package ser516.project3.model;

public class TimerModel {
  private int timeElapsed;

  /**
   * Gets the time elapsed since the server is running.
   *
   * @return the time elapsed since the server is running
   */
  public int getTimeElapsed() {
    return timeElapsed;
  }

  /**
   * Sets the time elapsed since the server is running.
   *
   * @param timeElapsed the time elapsed since the server is running
   */
  public void setTimeElapsed(int timeElapsed) {
    this.timeElapsed = timeElapsed;
  }
}