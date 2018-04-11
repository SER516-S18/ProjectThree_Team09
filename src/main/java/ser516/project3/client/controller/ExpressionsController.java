package ser516.project3.client.controller;

import ser516.project3.client.view.FaceView;
import ser516.project3.interfaces.CommonDataInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.client.view.ExpressionsView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.ExpressionsModel;
/**
 * The Controller class for Expressions related tasks
 * @author vsriva12
 *
 */
public class ExpressionsController implements ControllerInterface, CommonDataInterface {
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  private GraphController graphController;
  private FaceController faceController;

  private boolean connectionStatus;

  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView, GraphController graphController, FaceController faceController) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;
    this.graphController = graphController;
    this.faceController = faceController;
  }

  @Override
  public void initializeView() {
    String legendNames[] = {"blink", "rightWink", "leftWink", "lookingRight", "lookingLeft",
        "smile", "clench", "leftSmirk", "rightSmirk", "laugh", "furrowBrow", "raiseBrow"};
    graphController.setLegendNames(legendNames);
    graphController.setNoOfChannels(12);
    graphController.setXLength(100);
    graphController.updateGraphView();
    ViewInterface clientViewInterface[] = {graphController.getView(), faceController.getView()};
    expressionsView.initializeView(clientViewInterface);
  }

  @Override
  public ExpressionsView getView() {
    return expressionsView;
  }

  @Override
  public ControllerInterface[] getSubControllers() {
    ControllerInterface[] subControllers = {graphController, faceController};
    return subControllers;
  }

  @Override
  public void setConnectionStatus(boolean connectionStatus) {
    this.connectionStatus = connectionStatus;
  }

  @Override
  public void setTabSelected(boolean tabSelected) {
    expressionsModel.setTabSelected(tabSelected);
    faceController.setSelected(tabSelected);
  }
}
