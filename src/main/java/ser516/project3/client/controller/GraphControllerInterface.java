package ser516.project3.client.controller;

import ser516.project3.client.view.GraphView;
import ser516.project3.model.CoordinatesModel;

import java.awt.*;
import java.util.ArrayList;

/**
 * GraphControllerInterface is an interface for the GraphControllerImpl class.
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-03-30
 *
 */
public interface GraphControllerInterface {

  /**
   * Sets the X-axis display length in the <code>GraphModel</code>.
   *
   * @param XLength length of X-axis
   */
  void setXLength(int XLength);

  /**
   * Gets the X-axis display length in the <code>GraphModel</code>.
   *
   * @return length of X-axis
   */
  int getXLength();

  /**
   * Sets the no of channels in the <code>GraphModel</code>.
   *
   * @param noOfChannels no of channels in the <code>GraphModel</code>
   */
  void setNoOfChannels(int noOfChannels);

  /**
   * Gets the no of channels in the <code>GraphModel</code>.
   *
   * @return no of channels in the <code>GraphModel</code>.
   */
  int getNoOfChannels();

  /**
   * Sets the list of colors for each channel in the <code>GraphModel</code>.
   *
   * @param channelColors list of colors for each channel in the <code>GraphModel</code>
   */
  void setChannelColors(Color channelColors[]);

  /**
   * Gets the list of colors for each channel in the <code>GraphModel</code>.
   *
   * @return list of colors for each channel in the <code>GraphModel</code>
   */
  Color[] getChannelColors();

  /**
   * Sets the coordinate values for each channel in the <code>GraphModel</code>.
   *
   * @param graphData list of coordinate values for each channel in the <code>GraphModel</code>
   */
  void setGraphData(ArrayList<ArrayList<CoordinatesModel>> graphData);

  /**
   * Gets the coordinate values for each channel in the <code>GraphModel</code>.
   *
   * @return list of coordinate values for each channel in the <code>GraphModel</code>
   */
  ArrayList<ArrayList<CoordinatesModel>> getGraphData();

  /**
   * Updates the GraphView using the new data from the <code>GraphModel</code>.
   */
  void updateGraphView();

  /**
   * Gets the GraphView
   */
  GraphView getGraphView();
}
