package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.TimerModel;
import ser516.project3.server.view.TimerView;

public class TimerController implements ControllerInterface{
  private TimerModel timerModel;
  private TimerView timerView;

  public TimerController(TimerModel timerModel, TimerView timerView) {
    this.timerModel = timerModel;
    this.timerView = timerView;
  }

  @Override
  public void initializeView() {
    timerView.initializeView(null);
  }

  public TimerView getTimerView() {
    return timerView;
  }

  public void updateTimeStamp(double timeStamp) {
    timerModel.setTimeElapsed(timeStamp);
    timerView.updateTimeStamp();
  }
}
