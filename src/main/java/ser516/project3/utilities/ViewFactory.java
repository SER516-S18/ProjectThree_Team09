package ser516.project3.utilities;

import ser516.project3.client.view.*;
import ser516.project3.constants.ClientConstants;
import ser516.project3.model.*;

public class ViewFactory {
  public ClientViewInterface getView(String viewType, ModelInterface model){
    if(viewType == null){
      return null;
    }
    if(viewType.equalsIgnoreCase(ClientConstants.CLIENT)){
      return ClientView.getClientView();
    } else if(viewType.equalsIgnoreCase(ClientConstants.HEADER)){
      return new HeaderView((HeaderModel) model);
    } else if(viewType.equalsIgnoreCase(ClientConstants.PERFORMANCE_METRICS)){
      return new PerformanceMetricView((PerformanceMetricModel) model);
    } else if(viewType.equalsIgnoreCase(ClientConstants.EXPRESSIONS)){
      return new ExpressionsView((ExpressionsModel) model);
    } else if(viewType.equalsIgnoreCase(ClientConstants.GRAPH)){
      return new GraphView((GraphModel) model);
    }

    return null;
  }
}
