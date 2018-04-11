package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;
import ser516.project3.server.view.ConsoleView;
import ser516.project3.server.view.EmotionsView;
import ser516.project3.server.view.TimerView;
import ser516.project3.server.view.TopView;

/**
 * The ControllerFactory class is a factory class that handles creation of
 * specific controllers throughout the application
 *
 * @author vsriva12
 */
public class ServerControllerFactory {
    private static ServerControllerFactory instance;

    /**
     * Creates a singleton instance of ControllerFactory. If exists, returns it,
     * else creates it.
     *
     * @return instance of the ControllerFactory
     */
    public static ServerControllerFactory getInstance() {
        if (instance == null) {
            instance = new ServerControllerFactory();
        }
        return instance;
    }

    /**
     * The getController method creates Controller classes based on the value of
     * controller type
     *
     * @param controllerType - the Type of the controller
     * @param model          - the controllers model
     * @param view           - the controllers view
     * @return the controller object
     */
    public ControllerInterface getController(String controllerType, ModelInterface model, ViewInterface view) {
        if (controllerType == null) {
            return null;
        }
        if (controllerType.equalsIgnoreCase("SERVER")) {
            return ServerController.getInstance();
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
