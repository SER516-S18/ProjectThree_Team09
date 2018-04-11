package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.TimerModel;
import ser516.project3.server.view.TimerView;

/**
 * Class that helps communicate between TimerView and TimerModel.
 * The controller can receive and update data from the TimerView, 
 * and use this data to update the TimerModel.
 * 
 * @author Ser516-Team09
 */
public class TimerController implements ControllerInterface{
  private TimerModel timerModel;
  private TimerView timerView;

  /**
   * Constructor to set the timer view and model object
   * @param timerModel TimerModel object
   * @param timerView TimerView object
   */
  public TimerController(TimerModel timerModel, TimerView timerView) {
    this.timerModel = timerModel;
    this.timerView = timerView;
  }
  
  /**
   * Method to initialize the timer view
   */
  @Override
  public void initializeView() {
    timerView.initializeView(null);
  }

  /**
   * Returns the set of sub controllers in case any
   *
   * @return array containing sub controllers
   */
  @Override
  public ControllerInterface[] getSubControllers() {
    return null;
  }

  /**
   * Method to get Timer view
   * and @return Timer view object
   */
  @Override
  public TimerView getView() {
    return timerView;
  }

  /**
   * Updates the time stamp in TimerModel  and TimerView
   * @param timeStamp value to be set for timeStamp in the server
   */
  public void updateTimeStamp(double timeStamp) {
    timerModel.setTimeElapsed(timeStamp);
    timerView.updateTimeStamp();
  }
}
