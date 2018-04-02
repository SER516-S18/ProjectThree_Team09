package ser516.project3.client.controller;

import ser516.project3.client.view.ConnectionPopUpView;
import ser516.project3.model.ConnectionPopUpModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionPopUpController {
  private ConnectionPopUpView connectionPopUpView;
  private ConnectionPopUpModel connectionPopUpModel;

  public ConnectionPopUpController() {
    connectionPopUpModel = new ConnectionPopUpModel();
    connectionPopUpView = new ConnectionPopUpView(connectionPopUpModel);

    connectionPopUpView.addConnectButtonListener(new ConnectListener());
  }

  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      ClientControllerInterface clientControllerImpl = new ClientControllerImpl();
      clientControllerImpl.toggleConnectionToServer(connectionPopUpModel.getIpAddress(), connectionPopUpModel.getPortNumber());
    }
  }
}
