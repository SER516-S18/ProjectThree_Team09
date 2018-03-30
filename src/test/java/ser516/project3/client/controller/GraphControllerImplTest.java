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

    int x = 0;
    ArrayList<ArrayList<CoordinatesModel>> graphData = new ArrayList<ArrayList<CoordinatesModel>>();
    for(int i = 0; i < 10; i++, x++) {
      ArrayList<CoordinatesModel> coordinatesList = new ArrayList<CoordinatesModel>();
      for(int j = 0; j < graphControllerInterface.getNoOfChannels(); j++) {
        Random rand = new Random();
        double y = rand.nextDouble();
        coordinatesList.add(new CoordinatesModel(x, y + j));
      }
      graphData.add(coordinatesList);
    }
    graphControllerInterface.setGraphData(graphData);
    graphControllerInterface.updateGraphView();
  }
}