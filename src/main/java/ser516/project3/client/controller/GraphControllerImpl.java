package ser516.project3.client.controller;

import ser516.project3.client.view.GraphView;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.GraphModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * GraphControllerImpl is a class to communicate between the GraphModel and
 * the GraphView. The controller can receive and update data from the GraphModel, and
 * use this data to update the GraphView.
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-03-30
 *
 */
public class GraphControllerImpl implements GraphControllerInterface {
  private GraphModel graphModel;
  private GraphView graphView;

  /**
   * Initializes an instance the graph controller with <code>GraphModel</code> and <code>GraphView</code> objects.
   *
   * @param graphModel a model object containing required graph data.
   * @param graphView a view object used to display the graph.
   * @see GraphModel
   * @see GraphView
   */
  public GraphControllerImpl(GraphModel graphModel, GraphView graphView) {
    this.graphModel = graphModel;
    this.graphView = graphView;
  }

  /**
   * @inheritDoc
   */
  public void setXLength(int XLength) {
    graphModel.setXLength(XLength);
  }

  /**
   * @inheritDoc
   */
  public int getXLength() {
    return graphModel.getXLength();
  }

  /**
   * @inheritDoc
   */
  public void setNoOfChannels(int noOfChannels) {
    graphModel.setNoOfChannels(noOfChannels);
  }

  /**
   * @inheritDoc
   */
  public int getNoOfChannels() {
    return graphModel.getNoOfChannels();
  }

  /**
   * @inheritDoc
   */
  public void setChannelColors(Color channelColors[]) {
    graphModel.setChannelColors(channelColors);
  }

  /**
   * @inheritDoc
   */
  public Color[] getChannelColors() {
    return graphModel.getChannelColors();
  }

  /**
   * @inheritDoc
   */
  public void setGraphData(ArrayList<ArrayList<CoordinatesModel>> graphData) {
    graphModel.setGraphData(graphData);
  }

  /**
   * @inheritDoc
   */
  public ArrayList<ArrayList<CoordinatesModel>> getGraphData() {
    return graphModel.getGraphData();
  }

  /**
   * @inheritDoc
   */
  public void updateGraphView() {
    graphView.updateGraphView(graphModel);
  }

  /**
   * @inheritDoc
   */
  public GraphView getGraphView() {
    return graphView;
  }

  /**
   * @inheritDoc
   */
  public GraphModel getGraphModel() {
    return graphModel;
  }
}
