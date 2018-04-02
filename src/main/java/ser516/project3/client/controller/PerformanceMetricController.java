package ser516.project3.client.controller;


import ser516.project3.client.view.GraphView;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.model.GraphModel;
import ser516.project3.model.PerformanceMetricModel;

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
  }

  /**
   * @inheritDoc
   */
  public void initializePerformanceMetricView() {
    performanceMetricView.initializePerformanceMetricUI(graphController.getGraphView());
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
}
