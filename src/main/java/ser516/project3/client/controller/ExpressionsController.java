package ser516.project3.client.controller;

import ser516.project3.client.view.ExpressionsView;
import ser516.project3.client.view.GraphView;
import ser516.project3.model.ExpressionsModel;
import ser516.project3.model.GraphModel;

public class ExpressionsController {
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  private GraphControllerInterface graphController;

  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;

    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView();
    graphController = new GraphControllerImpl(graphModel, graphView);
    expressionsView.initializeExpressionsUI(graphController.getGraphView());
  }

  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }
}
