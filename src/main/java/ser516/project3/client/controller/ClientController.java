package ser516.project3.client.controller;

import ser516.project3.client.service.ClientConnectionServiceImpl;
import ser516.project3.client.service.ClientConnectionServiceInterface;
import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.model.ExpressionsModel;
import ser516.project3.model.GraphModel;
import ser516.project3.model.HeaderModel;
import ser516.project3.model.PerformanceMetricModel;
import ser516.project3.server.view.ServerView;
import ser516.project3.utilities.ControllerFactory;
import ser516.project3.utilities.ViewFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController implements ClientControllerInterface{
	private boolean connected = false;
	private ClientConnectionServiceInterface clientConnectionService;
	private ClientView clientView;
	private ServerView serverDialog;
	private HeaderController headerController;
	private PerformanceMetricController performanceMetricController;
	private ExpressionsController expressionsController;
	private GraphController performanceMetricsGraphController;
	private GraphController expressionGraphController;

	private static ClientController instance;
	public ClientController() {
		ViewFactory viewFactory = new ViewFactory();
		ControllerFactory controllerFactory = new ControllerFactory();
		initializeHeader(viewFactory, controllerFactory);
		initializePerformanceMetrics(viewFactory, controllerFactory);
		initializeExpressions(viewFactory, controllerFactory);
	}

	@Override
	public void initializeView() {
		clientView = ClientView.getClientView();
		clientView.initializeClientUI(headerController.getHeaderView(),
				performanceMetricController.getPerformanceMetricView(),
				expressionsController.getExpressionsView());
		clientView.addServerMenuItemListener(new ServerMenuItemListener());
	}

	public void initializeHeader(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		HeaderModel headerModel = new HeaderModel();
		HeaderView headerView = (HeaderView) viewFactory.getView(ClientConstants.HEADER, headerModel);
		headerController = (HeaderController)controllerFactory.getController(ClientConstants.HEADER, headerModel, headerView, null);
		headerController.initializeView();
	}

	public void initializePerformanceMetrics(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		GraphModel performanceMetricGraphModel = new GraphModel();
		GraphView performanceMetricGraphView = (GraphView) viewFactory.getView(ClientConstants.GRAPH, performanceMetricGraphModel);
		performanceMetricsGraphController = (GraphController) controllerFactory.getController(ClientConstants.GRAPH, performanceMetricGraphModel, performanceMetricGraphView, null);
		performanceMetricsGraphController.initializeView();

		PerformanceMetricModel performanceMetricModel = new PerformanceMetricModel();
		PerformanceMetricView performanceMetricView = (PerformanceMetricView) viewFactory.getView(ClientConstants.PERFORMANCE_METRICS, performanceMetricModel);
		performanceMetricController = (PerformanceMetricController) controllerFactory.getController(ClientConstants.PERFORMANCE_METRICS, performanceMetricModel, performanceMetricView, performanceMetricsGraphController);
		performanceMetricController.initializeView();
	}

	public void initializeExpressions(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		GraphModel expressionsGraphModel = new GraphModel();
		GraphView expressionsGraphView = (GraphView) viewFactory.getView(ClientConstants.GRAPH, expressionsGraphModel);
		expressionGraphController = (GraphController) controllerFactory.getController(ClientConstants.GRAPH, expressionsGraphModel, expressionsGraphView, null);
		expressionGraphController.initializeView();

		ExpressionsModel expressionsModel = new ExpressionsModel();
		ExpressionsView expressionsView = (ExpressionsView) viewFactory.getView(ClientConstants.EXPRESSIONS, expressionsModel);
		expressionsController = (ExpressionsController) controllerFactory.getController(ClientConstants.EXPRESSIONS, expressionsModel, expressionsView, expressionGraphController);
		expressionsController.initializeView();
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
	
	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the ClientController
	 */
	public static ClientController getInstance() {
		if (instance == null) {
			instance = new ClientController();
		}
		return instance;
	}

	/**
	 * Method to connect to a server end point
	 * @param ipAddress
	 * @param port
	 */
	public void toggleConnectionToServer(String ipAddress, int port) {
		if (connected) {
			clientConnectionService.stopClientConnection();
			connected = false;
			// TODO: Find a way to stop the client container
		} else {
			clientConnectionService = new ClientConnectionServiceImpl();
			clientConnectionService.createClientConnection(ipAddress, port, ClientConstants.ENDPOINT);
			connected = true;
		}
	}

	/**
	 * Forces the client to stop
	 */
	public void stopClientConnector() {
		clientConnectionService.stopClientConnection();
		connected = false;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		connected = connectionStatus;
		headerController.setConnectionStatus(connectionStatus);
	}

	class ServerMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(serverDialog == null) {
				serverDialog = new ServerView();
			} else {
				serverDialog.setVisible(true);
			}
		}
	}
}
