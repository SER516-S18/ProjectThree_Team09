package ser516.project3.client.controller;

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
  void setXLength(int XLength);
  int getXLength();
  void setNoOfChannels(int noOfChannels);
  int getNoOfChannels();
  void setChannelColors(Color channelColors[]);
  Color[] getChannelColors();
  void setGraphData(ArrayList<ArrayList<CoordinatesModel>> graphData);
  ArrayList<ArrayList<CoordinatesModel>> getGraphData();
  void updateGraphView();
}
