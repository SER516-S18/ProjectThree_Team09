package ser516.project3.client.controller;

import ser516.project3.client.view.PerformanceMetricView;

public interface PerformanceMetricInterface {
  /**
   * Gets the view for Performance Metrics
   *
   * @return the view for Performance Metrics
   */
  PerformanceMetricView getPerformanceMetricView();

  /**
   * Gets the controller for the Graph.
   * @return the controller for the Graph
   */
  GraphControllerInterface getGraphController();
}
