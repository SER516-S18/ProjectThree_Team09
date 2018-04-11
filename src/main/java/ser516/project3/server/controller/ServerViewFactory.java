package ser516.project3.server.controller;

import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;
import ser516.project3.server.view.*;

/**
 * The factory class to create specific views class instances based on arguments
 *
 * @author vsriva12
 */
public class ServerViewFactory {
    /**
     * The function which creates specific views based on the viewtype argument
     *
     * @param viewType - the type of the view
     * @param model    - the model corresponding to the view
     * @return - the instance of the view class
     */
    public ViewInterface getView(String viewType, ModelInterface model) {
        if (viewType == null) {
            return null;
        }
        if (viewType.equalsIgnoreCase("SERVER")) {
            return ServerView.getServerView();
        } else if (viewType.equalsIgnoreCase("TOP")) {
            return new TopView((TopModel) model);
        } else if (viewType.equalsIgnoreCase("TIMER")) {
            return new TimerView((TimerModel) model);
        } else if (viewType.equalsIgnoreCase("EMOTIONS")) {
            return new EmotionsView((EmotionsModel) model);
        } else if (viewType.equalsIgnoreCase("SERVER_EXPRESSIONS")) {
            return new ser516.project3.server.view.ExpressionsView((ExpressionsModel) model);
        } else if (viewType.equalsIgnoreCase("CONSOLE")) {
            return new ConsoleView((ConsoleModel) model);
        }

        return null;
    }
}
