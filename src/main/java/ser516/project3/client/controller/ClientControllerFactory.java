package ser516.project3.client.controller;

import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;

/**
 * The ControllerFactory class is a factory class that handles creation of
 * specific controllers throughout the application
 *
 * @author vsriva12
 */
public class ClientControllerFactory {
    private ClientController clientController;
    private HeaderController headerController;
    private FaceController faceController;
    private GraphController performanceMetricGraphController;
    private GraphController expressionsGraphController;

    private static ClientControllerFactory instance;

    /**
     * Creates a singleton instance of ControllerFactory.
     * If exists, returns it, else creates it.
     *
     * @return instance of the ControllerFactory
     */
    public static ClientControllerFactory getInstance() {
        if (instance == null) {
            instance = new ClientControllerFactory();
        }
        return instance;
    }

    /**
     * The getController method creates Controller classes based on the value of controller type
     *
     * @param controllerType - the Type of the controller
     * @param model          - the controllers model
     * @param view           - the controllers view
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
        } else if (controllerType.equalsIgnoreCase(ClientConstants.HEADER)) {
            headerController = new HeaderController((HeaderModel) model, (HeaderView) view,
                    (ConnectionPopUpController) subControllers[0]);
            return headerController;
        } else if (controllerType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)) {
            performanceMetricGraphController = (GraphController) subControllers[0];
            return new PerformanceMetricController((PerformanceMetricModel) model, (PerformanceMetricView) view,
                    performanceMetricGraphController);
        } else if (controllerType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)) {
            expressionsGraphController = (GraphController) subControllers[0];
            return new ExpressionsController((ExpressionsModel) model, (ExpressionsView) view,
                    expressionsGraphController, (FaceController) subControllers[1]);
        } else if (controllerType.equalsIgnoreCase(ClientConstants.GRAPH)) {
            return new GraphController((GraphModel) model, (GraphView) view);
        } else if (controllerType.equalsIgnoreCase(ClientConstants.FACE)) {
            faceController = new FaceController((FaceModel) model, (FaceView) view);
            return faceController;
        } else if (controllerType.equalsIgnoreCase(ClientConstants.CONNECTION_POP_UP)) {
            return new ConnectionPopUpController((ConnectionPopUpModel) model, (ConnectionPopUpView) view);
        }

        return null;
    }

    /**
     * @return the instance of the Client Controller
     */
    public ClientController getClientController() {
        return clientController;
    }

    /**
     * @return returns the instance of the header controller
     */
    public HeaderController getHeaderController() {
        return headerController;
    }

    /**
     * @return returns the instance of the face controller
     */
    public FaceController getFaceController() {
        return faceController;
    }

    /**
     * @return returns the instance of the Graph performance controller
     */
    public GraphController getPerformanceMetricGraphController() {
        return performanceMetricGraphController;
    }

    /**
     * @return returns the instance of the Graph expressions Controller
     */
    public GraphController getExpressionsGraphController() {
        return expressionsGraphController;
    }
}
