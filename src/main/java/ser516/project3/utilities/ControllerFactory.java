package ser516.project3.utilities;

import ser516.project3.client.controller.*;
import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.model.*;

public class ControllerFactory {
  public ClientControllerInterface getController(String controllerType, ModelInterface model, ClientViewInterface view, GraphController graphController){
    if(controllerType == null){
      return null;
    }
    if(controllerType.equalsIgnoreCase(ClientConstants.HEADER)){
      return new HeaderController((HeaderModel) model, (HeaderView) view);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)){
      return new PerformanceMetricController((PerformanceMetricModel) model, (PerformanceMetricView) view, graphController);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)){
      return new ExpressionsController((ExpressionsModel) model, (ExpressionsView) view, graphController);
    } else if(controllerType.equalsIgnoreCase(ClientConstants.GRAPH)){
      return new GraphController((GraphModel) model, (GraphView) view);
    }

    return null;
  }
}
