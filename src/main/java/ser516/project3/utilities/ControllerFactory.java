package ser516.project3.utilities;

import ser516.project3.client.controller.*;
import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;
import ser516.project3.server.controller.ConsoleController;
import ser516.project3.server.controller.EmotionsController;
import ser516.project3.server.controller.ServerController;
import ser516.project3.server.controller.TimerController;
import ser516.project3.server.controller.TopController;
import ser516.project3.server.view.ConsoleView;
import ser516.project3.server.view.EmotionsView;
import ser516.project3.server.view.TimerView;
import ser516.project3.server.view.TopView;

/**
 * The ControllerFactory class is a factory class that handles creation of
 * specific controllers throughout the application
 * 
 * @author vsriva12
 *
 */
public class ControllerFactory {
	/**
	 * The getController method creates Controller classes based on the value of controller type
	 * @param controllerType - the Type of the controller
	 * @param model - the controllers model
	 * @param view - the controllers view
	 * @param subController - the sub controller
	 * @return the controller object
	 */
	public ControllerInterface getController(String controllerType, ModelInterface model, ViewInterface view,
			ControllerInterface subControllers[]) {
		if (controllerType == null) {
			return null;
		}
		if (controllerType.equalsIgnoreCase(ClientConstants.CLIENT)) {
			return ClientController.getInstance();
		} else if (controllerType.equalsIgnoreCase("SERVER")) {
			return ServerController.getInstance();
		} else if (controllerType.equalsIgnoreCase(ClientConstants.HEADER)) {
			return new HeaderController((HeaderModel) model, (HeaderView) view,
					(ConnectionPopUpController) subControllers[0]);
		} else if (controllerType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)) {
			return new PerformanceMetricController((PerformanceMetricModel) model, (PerformanceMetricView) view,
					(GraphController) subControllers[0]);
		} else if (controllerType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)) {
			return new ExpressionsController((ExpressionsModel) model, (ExpressionsView) view,
					(GraphController) subControllers[0], (FaceController) subControllers[1] );
		} else if (controllerType.equalsIgnoreCase(ClientConstants.GRAPH)) {
			return new GraphController((GraphModel) model, (GraphView) view);
		} else if (controllerType.equalsIgnoreCase("FACE")) {
			return new FaceController((FaceModel) model, (FaceView) view);
		} else if (controllerType.equalsIgnoreCase("CONNECTION_POP_UP")) {
			return new ConnectionPopUpController((ConnectionPopUpModel) model, (ConnectionPopUpView) view);
		} else if (controllerType.equalsIgnoreCase("TOP")) {
			return new TopController((TopModel) model, (TopView) view);
		} else if (controllerType.equalsIgnoreCase("TIMER")) {
			return new TimerController((TimerModel) model, (TimerView) view);
		} else if (controllerType.equalsIgnoreCase("EMOTIONS")) {
			return new EmotionsController((EmotionsModel) model, (EmotionsView) view);
		} else if (controllerType.equalsIgnoreCase("SERVER_EXPRESSIONS")) {
			return new ser516.project3.server.controller.ExpressionsController((ExpressionsModel) model,
					(ser516.project3.server.view.ExpressionsView) view);
		} else if (controllerType.equalsIgnoreCase("CONSOLE")) {
			return new ConsoleController((ConsoleModel) model, (ConsoleView) view);
		}

		return null;
	}
}
