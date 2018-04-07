package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.EmotionsModel;
import ser516.project3.server.view.EmotionsView;
import ser516.project3.utilities.ServerCommonData;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EmotionsController implements ControllerInterface{
  private EmotionsModel emotionsModel;
  private EmotionsView emotionsView;

  public EmotionsController(EmotionsModel emotionsModel, EmotionsView emotionsView) {
    this.emotionsModel = emotionsModel;
    this.emotionsView = emotionsView;
  }

  @Override
  public void initializeView() {
    emotionsView.initializeView(null);
    for(int i = 0; i < 6; i++) {
      emotionsView.addSpinnerListener(new SpinnerChangeListener());
    }
  }

  class SpinnerChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      JSpinner source = (JSpinner)e.getSource();
      switch (source.getName()) {
        case "Interest":
          emotionsModel.setInterest((double)source.getValue());
          break;
        case "Engagement":
          emotionsModel.setEngagement((double)source.getValue());
          break;
        case "Stress":
          emotionsModel.setStress((double)source.getValue());
          break;
        case "Relaxation":
          emotionsModel.setRelaxation((double)source.getValue());
          break;
        case "Excitement":
          emotionsModel.setExcitement((double)source.getValue());
          break;
        case "Focus":
          emotionsModel.setFocus((double)source.getValue());
          break;
      }
      ServerCommonData.getInstance().getMessage().setEmotion(source.getName(), (Double)source.getValue());
    }
  }

  public EmotionsView getEmotionsView() {
    return emotionsView;
  }
}
