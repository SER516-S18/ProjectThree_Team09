package ser516.project3.client.controller;

import ser516.project3.client.view.HeaderView;
import ser516.project3.model.ConnectionPopUpModel;
import ser516.project3.model.HeaderModel;
import ser516.project3.server.view.ServerPanelGenerator;
import ser516.project3.server.view.ServerView;
import ser516.project3.server.view.TimerView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class HeaderController {

  private HeaderView headerView;
  private HeaderModel headerModel;
  private ServerView serverDialog;
  private ConnectionPopUpController connectionPopUpController;
  private ConnectionPopUpModel connectionPopUpModel;
  

  public HeaderController(HeaderModel headerModel, HeaderView headerView) {
    connectionPopUpModel = new ConnectionPopUpModel();
    this.headerView = headerView;
    this.headerModel = headerModel;

    this.headerView.addConnectButtonListener(new ConnectListener());
    this.headerView.addServerOpenButtonListener(new ServerOpenListener());
  }
  
  class ServerOpenListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(serverDialog == null) {
			serverDialog = new ServerView();
		} else {
			serverDialog.setVisible(true);
		}
	}
	  
  }

  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (headerModel.isConnectionStatus()) {
        ClientControllerImpl.getInstance().toggleConnectionToServer(null, 0);
      } else {
        connectionPopUpController = new ConnectionPopUpController(connectionPopUpModel);
      }
    }
  }

  public HeaderView getHeaderView() {
    return headerView;
  }
  
  public static double getHeaderTimeStamp()
  {
	  
	  double interval = 0,elapsedTime = 0;
	  
	  JTextField intervalTimeField;
	  JTextField elapsedTimeField;
	  
	  if(ServerPanelGenerator.gettopPanel() == null)
	  {
		  return 0.0;
	  }

	  Component[] components = ServerPanelGenerator.gettopPanel().getComponents();
	  if(components == null)
	  {
		  return 0.0;
	  }

	  for (Component component : components) {
	      if (component.getClass().equals(JTextField.class)) {
	    	  intervalTimeField=(JTextField)component;
	    	  System.out.println(intervalTimeField.getText());
	    	  interval=Double.parseDouble(intervalTimeField.getText());
	      }
	  }
	  
	  Component[] components_timer = TimerView.getTimerPanel().getComponents();
	  if(components_timer == null)
	  {
		  return 0.0;
	  }

	  for (Component component : components_timer) {
	      if (component.getClass().equals(JTextField.class)) {
	    	  elapsedTimeField=(JTextField)component;
	    	  System.out.println(elapsedTimeField.getText());
	    	  elapsedTime=Double.parseDouble(elapsedTimeField.getText());
	      }
	  }
	return (elapsedTime-interval);
	
	  
  }

  public void setConnectionStatus(boolean connectionStatus) {
    headerModel.setConnectionStatus(connectionStatus);
    headerView.updateConnectionLabel();
    headerView.updateHeaderTimeStamp();
  }
}
