package ser516.project3.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * GraphModel is a class to represent the model for a graph. The model
 * will contain information needed to draw a graph. This information includes:
 * <ul>
 *   <li>No of channels to display</li>
 *   <li>Length of the X-axis</li>
 *   <li>Colors for each channel</li>
 *   <li>List of Coordinate values for each channel</li>
 * </ul>
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-03-30
 *
 */
public class GraphModel {
  private int XLength;
  private int noOfChannels;
  private Color channelColors[];
  private ArrayList<ArrayList<CoordinatesModel>> graphData;

  /**
   * Sets the X-axis display length.
   *
   * @param XLength length of X-axis
   */
  public void setXLength(int XLength) {
    this.XLength = XLength;
  }

  /**
   * Gets the X-axis display length.
   *
   * @return length of X-axis
   */
  public int getXLength() {
    return XLength;
  }

  /**
   * Sets the no of channels in the graph.
   *
   * @param noOfChannels no of channels in the graph
   */
  public void setNoOfChannels(int noOfChannels) {
    this.noOfChannels = noOfChannels;
  }

  /**
   * Gets the no of channels in the graph.
   *
   * @return no of channels in the graph.
   */
  public int getNoOfChannels() {
    return noOfChannels;
  }

  /**
   * Sets the list of colors for each channel in the graph.
   *
   * @param channelColors list of colors for each channel in the graph
   */
  public void setChannelColors(Color channelColors[]) {
    this.channelColors = channelColors;
  }

  /**
   * Gets the list of colors for each channel in the graph.
   *
   * @return list of colors for each channel in the graph
   */
  public Color[] getChannelColors() {
    return channelColors;
  }

  /**
   * Sets the coordinate values for each channel in the graph.
   *
   * @param graphData list of coordinate values for each channel in the graph
   */
  public void setGraphData(ArrayList<ArrayList<CoordinatesModel>> graphData) {
    this.graphData = graphData;
  }

  /**
   * Gets the coordinate values for each channel in the graph.
   *
   * @return list of coordinate values for each channel in the graph
   */
  public ArrayList<ArrayList<CoordinatesModel>> getGraphData() {
    return graphData;
  }
}
