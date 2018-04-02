package ser516.project3.client.controller;


import ser516.project3.client.view.GraphView;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.model.GraphModel;
import ser516.project3.model.PerformanceMetricModel;

public class PerformanceMetricController {
  PerformanceMetricModel performanceMetricModel;
  PerformanceMetricView performanceMetricView;
  GraphControllerInterface graphController;

  public PerformanceMetricController(PerformanceMetricModel performanceMetricModel, PerformanceMetricView performanceMetricView) {
    this.performanceMetricModel = performanceMetricModel;
    this.performanceMetricView = performanceMetricView;

    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView();
    graphController = new GraphControllerImpl(graphModel, graphView);
  }

  public void initializePerformanceMetricView() {
    performanceMetricView.initializePerformanceMetricUI(graphController.getGraphView());
  }

  public PerformanceMetricView getPerformanceMetricView() {
    return performanceMetricView;
  }
}
