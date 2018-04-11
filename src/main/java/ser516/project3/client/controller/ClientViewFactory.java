package ser516.project3.client.controller;

import ser516.project3.client.view.*;
import ser516.project3.client.view.ExpressionsView;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;

/**
 * The factory class to create specific views class instances based on arguments
 * @author vsriva12
 *
 */
public class ClientViewFactory {
	/**
	 * The function which creates specific views based on the viewtype argument
	 * @param viewType - the type of the view
	 * @param model - the model corresponding to the view
	 * @return - the instance of the view class
	 */
	public ViewInterface getView(String viewType, ModelInterface model) {
		if (viewType == null) {
			return null;
		}
		if (viewType.equalsIgnoreCase(ClientConstants.CLIENT)) {
			return ClientView.getClientView();
		} else if (viewType.equalsIgnoreCase(ClientConstants.HEADER)) {
			return new HeaderView((HeaderModel) model);
		} else if (viewType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)) {
			return new PerformanceMetricView((PerformanceMetricModel) model);
		} else if (viewType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)) {
			return new ExpressionsView((ExpressionsModel) model);
		} else if (viewType.equalsIgnoreCase(ClientConstants.GRAPH)) {
			return new GraphView((GraphModel) model);
		} else if (viewType.equalsIgnoreCase(ClientConstants.FACE)) {
			return new FaceView((FaceModel) model);
		} else if (viewType.equalsIgnoreCase(ClientConstants.CONNECTION_POP_UP)) {
			return new ConnectionPopUpView((ConnectionPopUpModel) model);
		}

		return null;
	}
}
