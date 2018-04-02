package ser516.project3.client.controller;

import ser516.project3.client.view.PerformanceMetricView;

public interface PerformanceMetricInterface {
  /**
   * Creates the components in the Performance Metrics view. This includes the graph
   * and the emotions.
   */
  void initializePerformanceMetricView();

  /**
   * Gets the view for Performance Metrics
   *
   * @return the view for Performance Metrics
   */
  PerformanceMetricView getPerformanceMetricView();

  /**
   *
   * @return the controller for Graph
   */
  GraphControllerInterface getGraphController();
}
