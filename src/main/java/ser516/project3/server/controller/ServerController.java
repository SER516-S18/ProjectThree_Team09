package ser516.project3.server.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.apache.log4j.Logger;

import ser516.project3.constants.ServerConstants;
import ser516.project3.client.controller.ControllerFactory;
import ser516.project3.client.controller.ViewFactory;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.ConsoleModel;
import ser516.project3.model.EmotionsModel;
import ser516.project3.model.ExpressionsModel;
import ser516.project3.model.TimerModel;
import ser516.project3.model.TopModel;
import ser516.project3.server.service.ServerConnectionServiceImpl;
import ser516.project3.server.service.ServerConnectionServiceInterface;
import ser516.project3.server.view.ConsoleView;
import ser516.project3.server.view.EmotionsView;
import ser516.project3.server.view.ExpressionsView;
import ser516.project3.server.view.ServerView;
import ser516.project3.server.view.TimerView;
import ser516.project3.server.view.TopView;

/**
 * The ServerController class is the main controller class for the server
 * application. This class handles all the requests from the server UI and
 * interacts with the Server Service classes to perform the requested tasks
 * 
 * @author vsriva12
 *
 */
public class ServerController implements ControllerInterface {
	final static Logger logger = Logger.getLogger(ServerView.class);
	private ViewFactory viewFactory;
	private ControllerFactory controllerFactory;
	private ServerView serverView;
	private TopController topController;
	private TimerController timerController;
	private EmotionsController emotionsController;
	private ExpressionsController expressionsController;
	private ConsoleController consoleController;
	private ServerConnectionServiceInterface serverConnectionService;

	private static ServerController instance;

    /**
	 * Constructor to initialize all components in the 
	 * server UI and also the  set up a Server service object
	 * to perform requested tasks
	 */	
	public ServerController() {
		viewFactory = new ViewFactory();
		controllerFactory = ControllerFactory.getInstance();
		serverConnectionService = new ServerConnectionServiceImpl();
		initializeTop();
		initializeTimer();
		initializeEmotions();
		initializeExpressions();
		initializeConsole();
	}
	
	/**
	 * Creates a singleton instance of ServerController. 
	 * If exists, returns it, else creates it.
	 * @return instance of the ServerController
	 */
	public static ServerController getInstance() {
		if (instance == null) {
			instance = new ServerController();
		}
		return instance;
	}
	
	/**
	* Method create initialize all the sub panels in the server
	*/
	@Override
	public void initializeView() {
		serverView = (ServerView) viewFactory.getView(ServerConstants.SERVER, null);
		serverView = ServerView.getServerView();
		ViewInterface subViews[] = { topController.getView(), timerController.getView(),
				emotionsController.getView(), expressionsController.getView(),
				consoleController.getView() };
		serverView.initializeView(subViews);
		serverView.addServerWindowListener(new ServerWindowsListener());
	}

	@Override
	public ViewInterface getView() {
		return serverView;
	}

	@Override
	public ControllerInterface[] getSubControllers() {
		ControllerInterface subControllers[] = {topController, timerController, emotionsController, expressionsController, consoleController};
		return subControllers;
	}

	/**
	* Method to initialize the top server settings panel
	* @param viewFactory ViewFactory object
	* @param controllerFactory ControllerFactory object
	*/
	private void initializeTop() {
		TopModel topModel = new TopModel();
		TopView topView = (TopView) viewFactory.getView(ServerConstants.TOP, topModel);
		topController = (TopController) controllerFactory.getController(ServerConstants.TOP, topModel, topView, null);
		topController.setServerConnectionService(serverConnectionService);
		topController.initializeView();
	}

	/**
	* Method to initialize the server timer panel
	* @param viewFactory ViewFactory object
	* @param controllerFactory ControllerFactory object
	*/
	private void initializeTimer() {
		TimerModel timerModel = new TimerModel();
		TimerView timerView = (TimerView) viewFactory.getView(ServerConstants.TIMER, timerModel);
		timerController = (TimerController) controllerFactory.getController(ServerConstants.TIMER, timerModel, timerView, null);
		timerController.initializeView();
	}

	/**
	* Method to initialize the emotions panel
	* @param viewFactory ViewFactory object
	* @param controllerFactory ControllerFactory object
	*/
	private void initializeEmotions() {
		EmotionsModel emotionsModel = new EmotionsModel();
		EmotionsView emotionsView = (EmotionsView) viewFactory.getView(ServerConstants.EMOTIONS, emotionsModel);
		emotionsController = (EmotionsController) controllerFactory.getController(ServerConstants.EMOTIONS, emotionsModel,
				emotionsView, null);
		emotionsController.initializeView();
	}

	/**
	* Method to initialize the expressions panel
	* @param viewFactory ViewFactory object
	* @param controllerFactory ControllerFactory object
	*/
	private void initializeExpressions(){
		ExpressionsModel expressionsModel = new ExpressionsModel();
		ExpressionsView expressionsView = (ExpressionsView) viewFactory.getView(
				ServerConstants.SERVER_EXPRESSIONS, expressionsModel);
		expressionsController = (ExpressionsController) controllerFactory.getController(
				ServerConstants.SERVER_EXPRESSIONS, expressionsModel, expressionsView, null);
		expressionsController.initializeView();
	}

	/**
	* Method to initialize the console panel
	* @param viewFactory ViewFactory object
	* @param controllerFactory ControllerFactory object
	*/
	private void initializeConsole(){
		ConsoleModel consoleModel = new ConsoleModel();
		ConsoleView consoleView = (ConsoleView) viewFactory.getView(ServerConstants.CONSOLE, consoleModel);
		consoleController = (ConsoleController) controllerFactory.getController(ServerConstants.CONSOLE,
				consoleModel, consoleView, null);
		consoleController.initializeView();
	}

	/**
	* Method to make the server frame visible
	*/	
	public void showServer() {
		serverView.setVisible(true);
	}

	/**
	 * Inner class to add window listener to server window
	 */
	class ServerWindowsListener extends WindowAdapter {
		public void windowClosed(WindowEvent e) {
			serverConnectionService.stopServerEndpoint();
			logger.info(ServerConstants.SERVER_CLOSE_MESSAGE);
		}
	}

	/**
	 * Gets the Top panel controller object
	 * @return TopController object
	 */	
	public TopController getTopController() {
		return topController;
	}
	
	/**
	 * Gets the Timer panel controller object
	 * @return TimerController object
	 */	
	public TimerController getTimerController() {
		return timerController;
	}
	
	/**
	 * Gets the Console panel controller object
	 * @return ConsoleController object
	 */	
	public ConsoleController getConsoleController() {
		return consoleController;
	}
}
