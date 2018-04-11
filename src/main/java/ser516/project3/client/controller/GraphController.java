package ser516.project3.client.controller;

import java.awt.Color;
import java.util.ArrayList;

import ser516.project3.client.view.GraphView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.GraphModel;

/**
 * GraphController is a class to communicate between the GraphModel and the
 * GraphView. The controller can receive and update data from the GraphModel,
 * and use this data to update the GraphView.
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-03-30
 *
 */
public class GraphController implements ControllerInterface {
	private GraphModel graphModel;
	private GraphView graphView;

	/**
	 * Initializes an instance the graph controller with <code>GraphModel</code> and
	 * <code>GraphView</code> objects.
	 *
	 * @param graphModel
	 *            a model object containing required graph data.
	 * @param graphView
	 *            a view object used to display the graph.
	 * @see GraphModel
	 * @see GraphView
	 */
	public GraphController(GraphModel graphModel, GraphView graphView) {
		this.graphModel = graphModel;
		this.graphView = graphView;
	}

	/**
	 * Sets the X-axis display length in the <code>GraphModel</code>.
	 *
	 * @param XLength
	 *            length of X-axis
	 */
	public void setXLength(int XLength) {
		graphModel.setXLength(XLength);
	}

	/**
	 * Gets the X-axis display length in the <code>GraphModel</code>.
	 *
	 * @return length of X-axis
	 */
	public int getXLength() {
		return graphModel.getXLength();
	}

	/**
	 * Sets the no of channels in the <code>GraphModel</code>.
	 *
	 * @param noOfChannels
	 *            no of channels in the <code>GraphModel</code>
	 */
	public void setNoOfChannels(int noOfChannels) {
		graphModel.setNoOfChannels(noOfChannels);
	}

	/**
	 * Gets the no of channels in the <code>GraphModel</code>.
	 *
	 * @return no of channels in the <code>GraphModel</code>.
	 */
	public int getNoOfChannels() {
		return graphModel.getNoOfChannels();
	}

	/**
	 * Sets the list of colors for each channel in the <code>GraphModel</code>.
	 *
	 * @param channelColors
	 *            list of colors for each channel in the <code>GraphModel</code>
	 */
	public void setChannelColors(Color channelColors[]) {
		graphModel.setChannelColors(channelColors);
	}

	/**
	 * Gets the list of colors for each channel in the <code>GraphModel</code>.
	 *
	 * @return list of colors for each channel in the <code>GraphModel</code>
	 */
	public Color[] getChannelColors() {
		return graphModel.getChannelColors();
	}

	/**
	 * Sets the coordinate values for each channel in the <code>GraphModel</code>.
	 *
	 * @param graphData
	 *            list of coordinate values for each channel in the
	 *            <code>GraphModel</code>
	 */
	public void setGraphData(ArrayList<ArrayList<CoordinatesModel>> graphData) {
		graphModel.setGraphData(graphData);
	}

	/**
	 * Gets the coordinate values for each channel in the <code>GraphModel</code>.
	 *
	 * @return list of coordinate values for each channel in the
	 *         <code>GraphModel</code>
	 */
	public ArrayList<ArrayList<CoordinatesModel>> getGraphData() {
		return graphModel.getGraphData();
	}

	/**
	 * Sets the names of each legend in the graph.
	 *
	 * @param legendNames
	 *            the names of each legend in the graph
	 */
	public void setLegendNames(String[] legendNames) {
		graphModel.setLegendNames(legendNames);
	}

	/**
	 * Gets the names of each legend in the graph.
	 * 
	 * @return names of each legend in the graph.
	 */
	public String[] getLegendNames() {
		return graphModel.getLegendNames();
	}

	/**
	 * Updates the GraphView using the new data from the <code>GraphModel</code>.
	 */
	public void updateGraphView() {
		graphView.updateGraphView(graphModel);
	}

	/**
	 * Method to get the Graph View
	 */
	public GraphView getGraphView() {
		return graphView;
	}

	/**
	 * Method to get  the Graph Model
	 */
	public GraphModel getGraphModel() {
		return graphModel;
	}

	@Override
	public void initializeView() {
		graphView.initializeView(null);
	}
}
