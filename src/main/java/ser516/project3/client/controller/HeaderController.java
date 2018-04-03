package ser516.project3.client.controller;

import ser516.project3.client.view.HeaderView;
import ser516.project3.model.ConnectionPopUpModel;
import ser516.project3.model.HeaderModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the UI for the header view on
 * client which helps in connection and shows the
 * connection status.
 *
 * @author Adhiraj Tikku, Vishakha Singal
 *
 */
public class HeaderController {

  private HeaderView headerView;
  private HeaderModel headerModel;
  private ConnectionPopUpController connectionPopUpController;
  private ConnectionPopUpModel connectionPopUpModel;

  /**
   * Constructor overloaded to initiate the model and view as well
   *
   * @param headerModel
   * @param headerView
   */
  public HeaderController(HeaderModel headerModel, HeaderView headerView) {
    connectionPopUpModel = new ConnectionPopUpModel();
    this.headerView = headerView;
    this.headerModel = headerModel;

    this.headerView.addConnectButtonListener(new ConnectListener());
  }

  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      connectionPopUpController = new ConnectionPopUpController(connectionPopUpModel);
    }
  }

  public HeaderView getHeaderView() {
    return headerView;
  }

  public void setConnectionStatus(boolean connectionStatus) {
    headerModel.setConnectionStatus(connectionStatus);
    headerView.updateConnectionLabel();
  }
}
