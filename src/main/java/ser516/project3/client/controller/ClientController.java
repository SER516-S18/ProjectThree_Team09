package ser516.project3.client.controller;

import ser516.project3.client.service.ClientConnectionServiceImpl;
import ser516.project3.client.service.ClientConnectionServiceInterface;
import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.CommonDataInterface;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;
import ser516.project3.server.controller.ServerController;
import ser516.project3.factory.ControllerFactory;
import ser516.project3.factory.ViewFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * The Controller class to handle requests from the Client UI
 * @author vsriva12
 *
 */
public class ClientController implements ControllerInterface, CommonDataInterface {
	private boolean connected = false;
	private ClientConnectionServiceInterface clientConnectionService;
	private ViewFactory viewFactory;
	private ClientView clientView;
	private ServerController serverController;
	private HeaderController headerController;
	private ControllerInterface performanceMetricController;
	private ExpressionsController expressionsController;
	private ControllerInterface performanceMetricsGraphController;
	private ControllerInterface expressionGraphController;
	private ControllerInterface faceController;
	private ControllerInterface connectionPopUpController;

	/**
	 * Constructor created to intialize
	 * Header, PerformanceMetrics and Face Expressions
	 *
	 */
	public ClientController() {
		viewFactory = new ViewFactory();
		ControllerFactory controllerFactory = ControllerFactory.getInstance();
		initializeHeader(viewFactory, controllerFactory);
		initializePerformanceMetrics(viewFactory, controllerFactory);
		initializeExpressions(viewFactory, controllerFactory);
	}

	/**
	 * Initializes Client view
	 */
	@Override
	public void initializeView() {
		clientView = (ClientView) viewFactory.getView(ClientConstants.CLIENT, null);
		ViewInterface subViews[] = {
				headerController.getView(),
				performanceMetricController.getView(),
				expressionsController.getView()};
		clientView.initializeView(subViews);
		clientView.addServerMenuItemListener(new ServerMenuItemListener());
		clientView.addClientWindowListener(new WindowClosingEventListener());
        clientView.addTabbedPaneSelectionListener(new TabSelectionListener());
        setTabSelected(false);
	}

	@Override
	public ViewInterface getView() {
		return null;
	}

	@Override
	public ControllerInterface[] getSubControllers() {
		ControllerInterface[] subControllers = {headerController, performanceMetricController, expressionsController,
				performanceMetricsGraphController, expressionGraphController, faceController, connectionPopUpController, serverController};
		return subControllers;
	}

	@Override
	public void setConnectionStatus(boolean connectionStatus) {
		connected = connectionStatus;
		headerController.setConnectionStatus(connectionStatus);
	}

	public void setTabSelected(boolean tabSelected) {
		expressionsController.setTabSelected(tabSelected);
	}

	/**
	 *  Header panel is initalized  where connection to server
	 *  dialog box is created.
	 */
	private void initializeHeader(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		ConnectionPopUpModel connectionPopUpModel = new ConnectionPopUpModel();
		ConnectionPopUpView connectionPopUpView = (ConnectionPopUpView) viewFactory.getView("CONNECTION_POP_UP", connectionPopUpModel);
		connectionPopUpController = controllerFactory.getController("CONNECTION_POP_UP", connectionPopUpModel, connectionPopUpView, null);

		ControllerInterface subControllers[] = {connectionPopUpController};

		HeaderModel headerModel = new HeaderModel();
		HeaderView headerView = (HeaderView) viewFactory.getView(ClientConstants.HEADER, headerModel);
		headerController = (HeaderController) controllerFactory.getController(ClientConstants.HEADER, headerModel, headerView, subControllers);
		headerController.initializeView();
	}
	/**
	 * Performance Metrics panel is created where graph controller and performance metric
	 * views are initialized.
	 *
	 */
	private void initializePerformanceMetrics(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		GraphModel performanceMetricGraphModel = new GraphModel();
		GraphView performanceMetricGraphView = (GraphView) viewFactory.getView(ClientConstants.GRAPH, performanceMetricGraphModel);
		performanceMetricsGraphController = controllerFactory.getController(ClientConstants.GRAPH, performanceMetricGraphModel, performanceMetricGraphView, null);
		performanceMetricsGraphController.initializeView();

		ControllerInterface subControllers[] = {performanceMetricsGraphController};

		PerformanceMetricModel performanceMetricModel = new PerformanceMetricModel();
		PerformanceMetricView performanceMetricView = (PerformanceMetricView) viewFactory.getView(ClientConstants.PERFORMANCE_METRICS, performanceMetricModel);
		performanceMetricController = controllerFactory.getController(ClientConstants.PERFORMANCE_METRICS, performanceMetricModel, performanceMetricView, subControllers);
		performanceMetricController.initializeView();
	}

	/**
	 * Expression panel is created where expression controller graph
	 * and expression controller views are created
	 */
	private void initializeExpressions(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		GraphModel expressionsGraphModel = new GraphModel();
		GraphView expressionsGraphView = (GraphView) viewFactory.getView(ClientConstants.GRAPH, expressionsGraphModel);
		expressionGraphController = controllerFactory.getController(ClientConstants.GRAPH, expressionsGraphModel, expressionsGraphView, null);
		expressionGraphController.initializeView();

		FaceModel faceModel = new FaceModel();
		FaceView faceView = (FaceView) viewFactory.getView("FACE", faceModel);
		faceController = controllerFactory.getController("FACE", faceModel, faceView, null);
		faceController.initializeView();

		ControllerInterface subControllers[] = {expressionGraphController, faceController};
		ExpressionsModel expressionsModel = new ExpressionsModel();
		ExpressionsView expressionsView = (ExpressionsView) viewFactory.getView(ClientConstants.EXPRESSIONS, expressionsModel);
		expressionsController = (ExpressionsController) controllerFactory.getController(ClientConstants.EXPRESSIONS, expressionsModel, expressionsView, subControllers);
		expressionsController.initializeView();
	}

	/**
	 * Method to connect to a server end point
	 * @param ipAddress - the IP address field
	 * @param port - the port field
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
		if(clientConnectionService != null)
			clientConnectionService.stopClientConnection();
		connected = false;
	}

	/**
	 * Method to display server view if its not open
	 */
	public void openServer() {
        if(serverController == null) {
            ControllerFactory controllerFactory = ControllerFactory.getInstance();
            serverController = (ServerController) controllerFactory.getController("SERVER", null, null, null);
            serverController.initializeView();
        } else {
            serverController.showServer();
        }
    }
	/**
	 *
	 * Class implemented to handle action listener of all server menu item components
	 * like lower face, upper face.
	 */
	class ServerMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			openServer();
		}
	}
	/**
	 *
	 *Class to deal with windows status like
	 *opened, closed, activated or deactivated
	 */
	class WindowClosingEventListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent windowEvent) {
			stopClientConnector();
		}
		@Override
		public void windowOpened(WindowEvent arg0) {}
		@Override
		public void windowClosed(WindowEvent arg0) {}
		@Override
		public void windowIconified(WindowEvent arg0) {}
		@Override
		public void windowDeiconified(WindowEvent arg0) {}
		@Override
		public void windowActivated(WindowEvent arg0) {}
		@Override
		public void windowDeactivated(WindowEvent arg0) {}
	}

	/**
	 * Class implemented to handle changes in tab selection.
	 *
	 */
	class TabSelectionListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof JTabbedPane) {
				JTabbedPane pane = (JTabbedPane) e.getSource();
				int selectedIndex = pane.getSelectedIndex();
				expressionsController.setTabSelected((selectedIndex == 1) ? true : false);
			}
		}
	}
}
