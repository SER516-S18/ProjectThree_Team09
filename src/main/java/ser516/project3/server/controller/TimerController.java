package ser516.project3.server.controller;

import ser516.project3.model.TimerModel;
import ser516.project3.server.view.TimerView;

public class TimerController {
  private TimerModel timerModel;
  private TimerView timerView;

  public TimerController(TimerModel timerModel, TimerView timerView) {
    this.timerModel = timerModel;
    this.timerView = timerView;
  }

  public void updateTimeStamp() {
    timerView.updateTimeStamp();
  }
}
