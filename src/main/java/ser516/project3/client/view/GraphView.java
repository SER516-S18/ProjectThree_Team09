package ser516.project3.client.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ser516.project3.constants.ClientConstants;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.GraphModel;

/**
 * GraphView is a class to represent the basic view template of a graph. A graph can
 * be created as well as updated with new values. The updated graph will reflect the values
 * present in the graphModel.
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-03-30
 *
 */
public class GraphView extends JPanel{
  private JFreeChart chart;
  private ChartPanel chartPanel;
  private GraphModel graphModel;

  /**
   * Initializes a graph instance and creates a default empty
   * graph.
   *
   */
  public GraphView() {
    graphModel = new GraphModel();
    graphModel.setNoOfChannels(0);
    graphModel.setXLength(1);
    initializeGraph();
    add(chartPanel);
    setVisible(true);
  }

  /**
   * Updates the Graph with new model data.
   *
   * @param graphModel a model object containing required graph data.
   * @see GraphModel
   */
  public void updateGraphView(GraphModel graphModel) {
    this.graphModel = graphModel;
    remove(chartPanel);
    XYDataset dataSet = createDataSet();
    chart = createChart(dataSet);
    chartPanel = new ChartPanel(chart);
    add(chartPanel);
    setVisible(true);
  }

  private void initializeGraph() {
    XYSeriesCollection dataSet = new XYSeriesCollection();
    chart = createChart(dataSet);
    chartPanel = new ChartPanel(chart);
  }

  private XYDataset createDataSet() {
    XYSeries series[] = new XYSeries[graphModel.getNoOfChannels()];
    XYSeriesCollection dataSet = new XYSeriesCollection();

    for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
      series[i] = new XYSeries(i);
    }

    if(graphModel.getGraphData() != null) {
      for (ArrayList<CoordinatesModel> data: graphModel.getGraphData()) {
        for(int i = 0; i < graphModel.getNoOfChannels(); i++) {
          double xCoordinate = data.get(i).getXCoordinate();
          double yCoordinate = data.get(i).getYCoordinate();
          series[i].add(xCoordinate, yCoordinate);
        }
      }
    }

    for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
      dataSet.addSeries(series[i]);
    }

    return dataSet;
  }

  private JFreeChart createChart(final XYDataset dataSet) {
    JFreeChart chart = ChartFactory.createXYLineChart("", ClientConstants.TIME_IN_SECONDS,
        "", dataSet, PlotOrientation.VERTICAL, true, true,
        false);

    XYPlot plot = chart.getXYPlot();

    ValueAxis range = plot.getRangeAxis();
    range.setVisible(false);
    range = plot.getDomainAxis();
    range.setRange(0, graphModel.getXLength());


    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    if(graphModel.getChannelColors() != null) {
      for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
        renderer.setSeriesPaint(i, graphModel.getChannelColors()[i]);
      }
    }

    plot.setRenderer(renderer);
    plot.setBackgroundPaint(Color.GRAY);

    plot.setRangeGridlinesVisible(false);
    plot.setDomainGridlinesVisible(false);

    chart.getLegend().setFrame(BlockBorder.NONE);

    return chart;
  }
}