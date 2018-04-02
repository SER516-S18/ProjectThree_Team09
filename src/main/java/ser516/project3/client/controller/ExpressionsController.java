package ser516.project3.client.controller;

import ser516.project3.client.view.ExpressionsView;
import ser516.project3.model.ExpressionsModel;

public class ExpressionsController {
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;
  }

  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }
}
