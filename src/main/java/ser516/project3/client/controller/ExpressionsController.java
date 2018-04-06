package ser516.project3.client.controller;

import ser516.project3.client.view.ClientViewInterface;
import ser516.project3.client.view.ExpressionsView;
import ser516.project3.model.ExpressionsModel;

public class ExpressionsController implements ClientControllerInterface{
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
    graphController.setNoOfChannels(12);
    graphController.setXLength(100);
    graphController.updateGraphView();
    ClientViewInterface clientViewInterface[] = {graphController.getGraphView()};
    expressionsView.initializeView(clientViewInterface);
  }

  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }

  public GraphController getGraphController() {
    return graphController;
  }
}
