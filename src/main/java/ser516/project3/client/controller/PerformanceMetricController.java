package ser516.project3.client.controller;


import ser516.project3.client.view.GraphView;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.model.GraphModel;
import ser516.project3.model.PerformanceMetricModel;
import ser516.project3.constants.ClientConstants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PerformanceMetricController implements PerformanceMetricInterface{
  private PerformanceMetricModel performanceMetricModel;
  private PerformanceMetricView performanceMetricView;

  private GraphControllerInterface graphController;

  public PerformanceMetricController(PerformanceMetricModel performanceMetricModel, PerformanceMetricView performanceMetricView) {
    this.performanceMetricModel = performanceMetricModel;
    this.performanceMetricView = performanceMetricView;

    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView();
    graphController = new GraphControllerImpl(graphModel, graphView);
    performanceMetricView.initializePerformanceMetricUI(graphController.getGraphView());
    this.performanceMetricView.addEmotionButtonsListener(new EmotionButtonsListener());
  }

  /**
   * @inheritDoc
   */
  public PerformanceMetricView getPerformanceMetricView() {
    return performanceMetricView;
  }

  /**
   * @inheritDoc
   */
  public GraphControllerInterface getGraphController() {
    return graphController;
  }

  public class EmotionButtonsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      Color initialBackground;
      Color newBackground;
      switch(e.getActionCommand()) {
        case ClientConstants.INTEREST :
          initialBackground = performanceMetricModel.getInterestColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.INTEREST + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setInterestColor(newBackground);
          }
          break;
        case ClientConstants.ENGAGEMENT :
          initialBackground = performanceMetricModel.getEngagementColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.ENGAGEMENT + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setEngagementColor(newBackground);
          }
          break;
        case ClientConstants.STRESS :
          initialBackground = performanceMetricModel.getStressColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.STRESS + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setStressColor(newBackground);
          }
          break;
        case ClientConstants.RELAXATION :
          initialBackground = performanceMetricModel.getRelaxationColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.RELAXATION + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setRelaxationColor(newBackground);
          }
          break;
        case ClientConstants.EXCITEMENT :
          initialBackground = performanceMetricModel.getExcitementColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.EXCITEMENT + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setExcitementColor(newBackground);
          }
          break;
        case ClientConstants.FOCUS :
          initialBackground = performanceMetricModel.getFocusColor();
          newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.FOCUS + " Color",
              initialBackground);
          if (newBackground != null) {
            performanceMetricModel.setFocusColor(newBackground);
          }
          break;
      }
      performanceMetricView.updatePerformanceMetricView(performanceMetricModel);
    }
  }
}
