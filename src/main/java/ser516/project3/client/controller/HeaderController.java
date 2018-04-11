package ser516.project3.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ser516.project3.client.view.HeaderView;
import ser516.project3.interfaces.CommonDataInterface;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.HeaderModel;
import ser516.project3.utilities.ControllerFactory;

/**
 * This class controls the UI for the header view on client which helps in
 * connection and shows the connection status.
 *
 * @author Adhiraj Tikku, Vishakha Singal
 *
 */

public class HeaderController implements ControllerInterface, CommonDataInterface {

	private HeaderView headerView;
	private HeaderModel headerModel;
	private ControllerInterface connectionPopUpController;
	private boolean tabSelected;


	/**
	 * Constructor overloaded to initiate the model and view as well
	 *
	 * @param headerModel
	 * @param headerView
	 */
	public HeaderController(HeaderModel headerModel, HeaderView headerView,
			ConnectionPopUpController connectionPopUpController) {
		this.headerView = headerView;
		this.headerModel = headerModel;
		this.connectionPopUpController = connectionPopUpController;
	}

	@Override
	public void initializeView() {
		headerView.initializeView(null);
		headerView.addConnectButtonListener(new ConnectListener());
		headerView.addServerOpenButtonListener(new ServerOpenListener());
	}

	@Override
	public HeaderView getView() {
		return headerView;
	}

	@Override
	public ControllerInterface[] getSubControllers() {
		ControllerInterface[] subControllers = {connectionPopUpController};
		return subControllers;
	}

	@Override
	public void setConnectionStatus(boolean connectionStatus) {
		headerModel.setConnectionStatus(connectionStatus);
		headerView.updateConnectionLabel();
	}

	@Override
	public void setTabSelected(boolean tabSelected) {
		this.tabSelected = tabSelected;
	}

	class ServerOpenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ControllerFactory.getInstance().getClientController().openServer();
		}
	}

	class ConnectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (headerModel.isConnectionStatus()) {
				ControllerFactory.getInstance().getClientController().toggleConnectionToServer(null, 0);
			} else {
				connectionPopUpController.initializeView();
			}
		}
	}

	public void setHeaderTimeStamp(double timeStamp) {
		headerModel.setTimeStamp(timeStamp);
		headerView.updateTimeStamp();
	}
}
