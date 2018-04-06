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

  public void setConnectionStatus(boolean connectionStatus) {
    headerModel.setConnectionStatus(connectionStatus);
    headerView.updateConnectionLabel();
  }

  public void setHeaderTimeStamp(double timeStamp) {
  	headerModel.setTimeStamp(timeStamp);
  	headerView.updateTimeStamp();
  }
}
