package ser516.project3.client.controller;

import ser516.project3.client.view.HeaderView;
import ser516.project3.interfaces.CommonDataInterface;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.HeaderModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the UI for the header view on client which helps in
 * connection and shows the connection status.
 *
 * @author Adhiraj Tikku, Vishakha Singal
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

    /**
     * Method to add Connect and Server Open button in headerview
     */
    @Override
    public void initializeView() {
        headerView.initializeView(null);
        headerView.addConnectButtonListener(new ConnectListener());
        headerView.addServerOpenButtonListener(new ServerOpenListener());
    }

    /**
     * Returns the instance of headerView
     *
     * @return headerView instance which is on top of the screen UI
     */
    @Override
    public HeaderView getView() {
        return headerView;
    }

    /**
     * Returns the set of sub controllers in case any
     *
     * @return array containing connectionPopUp controller which is a sub
     * controller
     */
    @Override
    public ControllerInterface[] getSubControllers() {
        ControllerInterface[] subControllers = {connectionPopUpController};
        return subControllers;
    }

    /**
     * Updates the status of the connection to the server in the model and
     * subsequently, in the view
     *
     * @param connectionStatus The status of the current connection to server
     */
    @Override
    public void setConnectionStatus(boolean connectionStatus) {
        headerModel.setConnectionStatus(connectionStatus);
        headerView.updateConnectionLabel();
    }

    /**
     * Overrriden method from interface for selected tab on screen
     *
     * @param tabSelected Current selected tab.
     */
    @Override
    public void setTabSelected(boolean tabSelected) {
        this.tabSelected = tabSelected;
    }

    /**
     * Class implemented to handle action listener
     * of server open button
     */
    class ServerOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientControllerFactory.getInstance().getClientController().openServer();
        }
    }

    /**
     * Class implemented to handle action listener
     * of Connect to server button
     */
    class ConnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (headerModel.isConnectionStatus()) {
                ClientControllerFactory.getInstance().getClientController().toggleConnectionToServer(null, 0);
            } else {
                connectionPopUpController.initializeView();
            }
        }
    }

    /**
     * Method to set header time stamp
     * and update it once the interval and elapsed time is set in the server dialog
     *
     * @param timeStamp The timestamp is the current timestamp received from the server
     *                  to be updated on the UI
     */
    public void setHeaderTimeStamp(double timeStamp) {
        headerModel.setTimeStamp(timeStamp);
        headerView.updateTimeStamp();
    }
}
