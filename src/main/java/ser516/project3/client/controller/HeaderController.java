package ser516.project3.client.controller;

import ser516.project3.client.view.HeaderView;
import ser516.project3.model.HeaderModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderController {

  private HeaderView headerView;
  private HeaderModel headerModel;
  private ConnectionPopUpController connectionPopUpController;

  public HeaderController(HeaderModel headerModel, HeaderView headerView) {
    this.headerView = headerView;
    this.headerModel = headerModel;

    this.headerView.addConnectButtonListener(new ConnectListener());
  }

  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      connectionPopUpController = new ConnectionPopUpController();
    }
  }

  public HeaderView getHeaderView() {
    return headerView;
  }
}
