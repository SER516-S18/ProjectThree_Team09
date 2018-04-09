/**
 * 
 */
package ser516.project3.server.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.apache.log4j.Logger;

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
import ser516.project3.utilities.ControllerFactory;
import ser516.project3.utilities.ViewFactory;

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
	private ServerView serverView;
	private TopController topController;
	private TimerController timerController;
	private EmotionsController emotionsController;
	private ExpressionsController expressionsController;
	private ConsoleController consoleController;
	private ServerConnectionServiceInterface serverConnectionService;

	private static ServerController instance;

	public ServerController() {
		viewFactory = new ViewFactory();
		ControllerFactory controllerFactory = new ControllerFactory();
		serverConnectionService = new ServerConnectionServiceImpl();
		initializeTop(viewFactory, controllerFactory);
		initializeTimer(viewFactory, controllerFactory);
		initializeEmotions(viewFactory, controllerFactory);
		initializeExpressions(viewFactory, controllerFactory);
		initializeConsole(viewFactory, controllerFactory);
	}

	public static ServerController getInstance() {
		if (instance == null) {
			instance = new ServerController();
		}
		return instance;
	}

	@Override
	public void initializeView() {
		serverView = (ServerView) viewFactory.getView("SERVER", null);
		serverView = ServerView.getServerView();
		ViewInterface subViews[] = { topController.getTopView(), timerController.getTimerView(),
				emotionsController.getEmotionsView(), expressionsController.getExpressionsView(),
				consoleController.getConsoleView() };
		serverView.initializeView(subViews);
		serverView.addServerWindowListener(new ServerWindowsListener());
	}

	private void initializeTop(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		TopModel topModel = new TopModel();
		TopView topView = (TopView) viewFactory.getView("TOP", topModel);
		topController = (TopController) controllerFactory.getController("TOP", topModel, topView, null);
		topController.setServerConnectionService(serverConnectionService);
		topController.initializeView();
	}

	private void initializeTimer(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		TimerModel timerModel = new TimerModel();
		TimerView timerView = (TimerView) viewFactory.getView("TIMER", timerModel);
		timerController = (TimerController) controllerFactory.getController("TIMER", timerModel, timerView, null);
		timerController.initializeView();
	}

	private void initializeEmotions(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		EmotionsModel emotionsModel = new EmotionsModel();
		EmotionsView emotionsView = (EmotionsView) viewFactory.getView("EMOTIONS", emotionsModel);
		emotionsController = (EmotionsController) controllerFactory.getController("EMOTIONS", emotionsModel,
				emotionsView, null);
		emotionsController.initializeView();
	}

	private void initializeExpressions(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		ExpressionsModel expressionsModel = new ExpressionsModel();
		ExpressionsView expressionsView = (ExpressionsView) viewFactory.getView("SERVER_EXPRESSIONS", expressionsModel);
		expressionsController = (ExpressionsController) controllerFactory.getController("SERVER_EXPRESSIONS",
				expressionsModel, expressionsView, null);
		expressionsController.initializeView();
	}

	private void initializeConsole(ViewFactory viewFactory, ControllerFactory controllerFactory) {
		ConsoleModel consoleModel = new ConsoleModel();
		ConsoleView consoleView = (ConsoleView) viewFactory.getView("CONSOLE", consoleModel);
		consoleController = (ConsoleController) controllerFactory.getController("CONSOLE", consoleModel, consoleView,
				null);
		consoleController.initializeView();
	}

	public void showServer() {
		serverView.setVisible(true);
	}

	class ServerWindowsListener extends WindowAdapter {
		public void windowClosed(WindowEvent e) {
			serverConnectionService.stopServerEndpoint();
			logger.info("server window closed");
		}
	}

	public TopController getTopController() {
		return topController;
	}

	public TimerController getTimerController() {
		return timerController;
	}

	public ConsoleController getConsoleController() {
		return consoleController;
	}
}
