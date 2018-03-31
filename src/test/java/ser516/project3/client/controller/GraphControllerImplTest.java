package ser516.project3.client.controller;

import org.junit.jupiter.api.Test;
import ser516.project3.client.view.GraphView;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.GraphModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Test class to test whether a graph gets updated with new values or not.
 */
class GraphControllerImplTest {

  @Test
  void testUpdateGraphView() {
    GraphModel graphModel = new GraphModel();
    GraphView graphView = new GraphView();
    GraphControllerInterface graphControllerInterface = new GraphControllerImpl(graphModel, graphView);

    graphControllerInterface.setNoOfChannels(6);
    Color channelColors[] = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.GRAY };
    graphControllerInterface.setChannelColors(channelColors);

    ArrayList<ArrayList<CoordinatesModel>> graphData = new ArrayList<ArrayList<CoordinatesModel>>();
    for(int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
      ArrayList<CoordinatesModel> coordinatesList = new ArrayList<CoordinatesModel>();
      for(int channelNo = 0; channelNo < graphControllerInterface.getNoOfChannels(); channelNo++) {
        Random rand = new Random();
        double yCoordinate = rand.nextDouble();
        coordinatesList.add(new CoordinatesModel(xCoordinate, yCoordinate + channelNo));
      }
      graphData.add(coordinatesList);
    }
    graphControllerInterface.setGraphData(graphData);
    graphControllerInterface.updateGraphView();
  }
}