package ser516.project3.factory;

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
	private ClientController clientController;
	private HeaderController headerController;
	private PerformanceMetricController performanceMetricController;
	private ExpressionsController expressionsController;
	private FaceController faceController;
	private GraphController performanceMetricGraphController;
	private GraphController expressionsGraphController;

	private static ControllerFactory instance;

	/**
	 * Creates a singleton instance of ControllerFactory.
	 * If exists, returns it, else creates it.
	 * @return instance of the ControllerFactory
	 */
	public static ControllerFactory getInstance() {
		if (instance == null) {
			instance = new ControllerFactory();
		}
		return instance;
	}

	/**
	 * The getController method creates Controller classes based on the value of controller type
	 * @param controllerType - the Type of the controller
	 * @param model - the controllers model
	 * @param view - the controllers view
	 * @param subControllers the sub controller
	 * @return the controller object
	 */
	public ControllerInterface getController(String controllerType, ModelInterface model, ViewInterface view,
			ControllerInterface subControllers[]) {
		if (controllerType == null) {
			return null;
		}
		if (controllerType.equalsIgnoreCase(ClientConstants.CLIENT)) {
			clientController = new ClientController();
			return clientController;
		} else if (controllerType.equalsIgnoreCase("SERVER")) {
			return ServerController.getInstance();
		} else if (controllerType.equalsIgnoreCase(ClientConstants.HEADER)) {
			headerController = new HeaderController((HeaderModel) model, (HeaderView) view,
					(ConnectionPopUpController) subControllers[0]);
			return headerController;
		} else if (controllerType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)) {
			performanceMetricGraphController = (GraphController) subControllers[0];
			performanceMetricController = new PerformanceMetricController((PerformanceMetricModel) model, (PerformanceMetricView) view,
					performanceMetricGraphController);
			return performanceMetricController;
		} else if (controllerType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)) {
			expressionsGraphController = (GraphController) subControllers[0];
			expressionsController = new ExpressionsController((ExpressionsModel) model, (ExpressionsView) view,
					expressionsGraphController, (FaceController) subControllers[1] );
			return expressionsController;
		} else if (controllerType.equalsIgnoreCase(ClientConstants.GRAPH)) {
			return new GraphController((GraphModel) model, (GraphView) view);
		} else if (controllerType.equalsIgnoreCase("FACE")) {
			faceController = new FaceController((FaceModel) model, (FaceView) view);
			return faceController;
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

	public ClientController getClientController() {
		return clientController;
	}

	public HeaderController getHeaderController() {
		return headerController;
	}

	public PerformanceMetricController getPerformanceMetricController() {
		return performanceMetricController;
	}

	public ExpressionsController getExpressionsController() {
		return expressionsController;
	}

	public FaceController getFaceController() {
		return faceController;
	}

	public GraphController getPerformanceMetricGraphController() {
		return performanceMetricGraphController;
	}

	public GraphController getExpressionsGraphController() {
		return expressionsGraphController;
	}
}
