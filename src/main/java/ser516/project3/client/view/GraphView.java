package ser516.project3.client.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.GraphModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

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
public class GraphView extends JPanel implements ViewInterface {
  private JFreeChart chart;
  private ChartPanel chartPanel;
  private GraphModel graphModel;
  private boolean legendDisplay;
  private double currentXCoordinate;

  private static final int TITLE_FONT_SIZE = 17;
  private static final int GRAPH_AXIS_FONT_SIZE = 14;

  /**
   * Initializes a graph instance and creates a default empty
   * graph.
   *
   */
  public GraphView(GraphModel graphModel) {
    this.graphModel = graphModel;
    currentXCoordinate = 0;
  }

  @Override
  public void initializeView(ViewInterface[] subViews) {
    setLayout(new GridLayout(1, 1, 8, 8));
    setBorder(new TitledBorder(null, ClientConstants.GRAPH,
        TitledBorder.CENTER, TitledBorder.TOP, new Font(ClientConstants.FONT_NAME, Font.BOLD, TITLE_FONT_SIZE), null));
    setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));
    XYSeriesCollection dataSet = new XYSeriesCollection();
    chart = createChart(dataSet);
    chartPanel = new ChartPanel(chart);
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
    legendDisplay = true;
    if(graphModel.getNoOfChannels() == 6)
      legendDisplay = false;
    remove(chartPanel);
    XYDataset dataSet = createDataSet();
    chart = createChart(dataSet);
    chartPanel = new ChartPanel(chart);
    add(chartPanel);
    setVisible(true);
  }

  private XYDataset createDataSet() {
    XYSeries series[] = new XYSeries[graphModel.getNoOfChannels()];
    XYSeriesCollection dataSet = new XYSeriesCollection();

    for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
      if(legendDisplay)
        series[i] = new XYSeries(graphModel.getLegendNames()[i]);
      else
        series[i] = new XYSeries(i);
    }

    if(graphModel.getGraphData() != null) {
      for (ArrayList<CoordinatesModel> data: graphModel.getGraphData()) {
        for(int i = 0; i < graphModel.getNoOfChannels(); i++) {
          double xCoordinate = data.get(i).getXCoordinate();
          double yCoordinate = data.get(i).getYCoordinate();
          if(graphModel.getNoOfChannels() == 6)
            series[i].add(graphModel.getXLength() - xCoordinate, yCoordinate);
          else
            series[i].add(xCoordinate, yCoordinate);
          currentXCoordinate = xCoordinate;
        }
      }
    }

    for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
      dataSet.addSeries(series[i]);
    }

    return dataSet;
  }

  private JFreeChart createChart(final XYDataset dataSet) {
    JFreeChart chart = ChartFactory.createXYLineChart("", "",
        "", dataSet, PlotOrientation.VERTICAL, legendDisplay, true,
        false);
    chart.setBackgroundPaint(Color.decode(ClientConstants.PANEL_COLOR_HEX));

    XYPlot plot = chart.getXYPlot();

    ValueAxis range = plot.getRangeAxis();
    if(graphModel.getNoOfChannels() == 6) {
      range.setTickLabelPaint(Color.WHITE);
      range.setTickLabelFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, GRAPH_AXIS_FONT_SIZE));
    } else {
      range.setTickLabelsVisible(false);
      range.setTickMarksVisible(false);
      range.setAxisLineVisible(false);
    }

    range = plot.getDomainAxis();
    if(graphModel.getNoOfChannels() == 12 && currentXCoordinate > graphModel.getXLength()) {
      int diff = (int)currentXCoordinate - graphModel.getXLength();
      graphModel.setXStartPoint(graphModel.getXStartPoint() + diff);
      graphModel.setXLength(graphModel.getXLength() + diff);
      range.setRange(graphModel.getXStartPoint(), graphModel.getXLength());
    } else {
      range.setRange(0, graphModel.getXLength());
    }
    range.setTickLabelPaint(Color.WHITE);
    range.setTickLabelFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, GRAPH_AXIS_FONT_SIZE));


    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    for (int i = 0; i < graphModel.getNoOfChannels(); i++) {
      if(graphModel.getChannelColors() != null)
        renderer.setSeriesPaint(i, graphModel.getChannelColors()[i]);
      renderer.setSeriesShapesVisible(i, false);
    }

    plot.setRenderer(renderer);
    plot.setBackgroundPaint(Color.decode(ClientConstants.GRAPH_COLOR_HEX));

    plot.setRangeGridlinesVisible(false);
    plot.setDomainGridlinesVisible(false);

    return chart;
  }
}