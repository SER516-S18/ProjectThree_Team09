package ser516.project3.client.controller;

import ser516.project3.client.view.FaceView;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.client.view.ExpressionsView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.ExpressionsModel;
/**
 * The Controller class for Expressions related tasks
 * @author vsriva12
 *
 */
public class ExpressionsController implements ControllerInterface {
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  private GraphController graphController;

  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView, GraphController graphController) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;
    this.graphController = graphController;
  }

  @Override
  public void initializeView() {
    String legendNames[] = {"blink", "rightWink", "leftWink", "lookingRight", "lookingLeft",
        "smile", "clench", "leftSmirk", "rightSmirk", "laugh", "furrowBrow", "raiseBrow"};
    graphController.setLegendNames(legendNames);
    graphController.setNoOfChannels(12);
    graphController.setXLength(100);
    graphController.updateGraphView();
    ViewInterface clientViewInterface[] = {graphController.getGraphView()};
    expressionsView.initializeView(clientViewInterface);
  }

  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }

  public GraphController getGraphController() {
    return graphController;
  }

  public void setSelected(boolean selected) {
    expressionsModel.setTabSelected(selected);
      FaceView.getInstance().setSelected(selected);
  }
}
