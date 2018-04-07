package ser516.project3.utilities;

import ser516.project3.client.controller.*;
import ser516.project3.client.controller.ExpressionsController;
import ser516.project3.client.view.ExpressionsView;
import ser516.project3.client.view.GraphView;
import ser516.project3.client.view.HeaderView;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ModelInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.*;
import ser516.project3.server.controller.*;
import ser516.project3.server.service.ServerConnectionServiceImpl;
import ser516.project3.server.view.ConsoleView;
import ser516.project3.server.view.EmotionsView;
import ser516.project3.server.view.TimerView;
import ser516.project3.server.view.TopView;

public class ControllerFactory {
  public ControllerInterface getController(String controllerType, ModelInterface model, ViewInterface view, GraphController graphController){
    if(controllerType == null){
      return null;
    }
    if(controllerType.equalsIgnoreCase(ClientConstants.CLIENT)){
      return ClientController.getInstance();
    } else if(controllerType.equalsIgnoreCase("SERVER")){
      return ServerController.getInstance();
    } else if(controllerType.equalsIgnoreCase(ClientConstants.HEADER)){
      return new HeaderController((HeaderModel) model, (HeaderView) view);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)){
      return new PerformanceMetricController((PerformanceMetricModel) model, (PerformanceMetricView) view, graphController);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)){
      return new ExpressionsController((ExpressionsModel) model, (ExpressionsView) view, graphController);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.GRAPH)){
      return new GraphController((GraphModel) model, (GraphView) view);
    } else if(controllerType.equalsIgnoreCase("TOP")){
      return new TopController((TopModel) model, (TopView) view);
    } else if(controllerType.equalsIgnoreCase("TIMER")){
      return new TimerController((TimerModel) model, (TimerView) view);
    } else if(controllerType.equalsIgnoreCase("EMOTIONS")){
      return new EmotionsController((EmotionsModel) model, (EmotionsView) view);
    } else if(controllerType.equalsIgnoreCase("SERVER_EXPRESSIONS")){
      return new ser516.project3.server.controller.ExpressionsController((ExpressionsModel) model, (ser516.project3.server.view.ExpressionsView) view);
    } else if(controllerType.equalsIgnoreCase("CONSOLE")){
      return new ConsoleController((ConsoleModel) model, (ConsoleView) view);
    }

    return null;
  }
}
