package ser516.project3.client.controller;


import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.model.PerformanceMetricModel;

public class PerformanceMetricController {
  PerformanceMetricModel performanceMetricModel;
  PerformanceMetricView performanceMetricView;

  public PerformanceMetricController(PerformanceMetricModel performanceMetricModel, PerformanceMetricView performanceMetricView) {
    this.performanceMetricModel = performanceMetricModel;
    this.performanceMetricView = performanceMetricView;
  }

  public PerformanceMetricView getPerformanceMetricView() {
    return performanceMetricView;
  }
}
