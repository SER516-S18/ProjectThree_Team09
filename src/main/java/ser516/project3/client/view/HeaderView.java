package ser516.project3.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alee.laf.button.WebButton;

import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.HeaderModel;

/**
 * HeaderView class to implement the header view for client to show and update
 * the client status
 *
 * @author Vishakha Singal, Adhiraj Tikku
 * @version 1.0
 */
public class HeaderView extends JPanel implements ViewInterface {

	private JLabel connectionLabel;
	private JLabel timeStampLabel;
	private JLabel connectionTextLabel;
	private JLabel timestampTextLabel;
	private WebButton connectButton;
	private WebButton serverOpenButton;
	private HeaderModel headerModel;

	private final static int FONT_SIZE = 15;

	/**
	 * This constructor initializes the model of HeaderView
	 * @param headerModel
	 */
	public HeaderView(HeaderModel headerModel) {
		this.headerModel = headerModel;
	}
	
	/**
	 * This method initializes the view of Header and creates components
	 * on view.
	 * 
	 * @param subViews 
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {
		setBorder(null);
		setLayout(new GridBagLayout());
		setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));

		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		createLabels(bagConstraints);
		createConnectButton(bagConstraints);
		createServerOpenButton(bagConstraints);
	}

	/**
	 * This method creates labels on the panel of Header and
	 * configures them. 
	 * @param gridbagConstraints an instance of GridBagConstraints
	 * 							 for setting position of labels 
	 * 							 on panel 
	 */
	private void createLabels(GridBagConstraints gridbagConstraints) {
		connectionTextLabel = new JLabel(ClientConstants.STATUS);
		connectionTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		connectionTextLabel.setVerticalTextPosition(JLabel.CENTER);
		connectionTextLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		gridbagConstraints.gridx = 0;
		gridbagConstraints.gridy = 0;
		gridbagConstraints.insets = new Insets(0, 0, 10, 10);
		add(connectionTextLabel, gridbagConstraints);

		connectionLabel = new JLabel(ClientConstants.DISCONNECTED);
		connectionLabel.setHorizontalTextPosition(JLabel.LEFT);
		connectionLabel.setVerticalTextPosition(JLabel.CENTER);
		connectionLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		gridbagConstraints.gridx = 1;
		gridbagConstraints.gridy = 0;
		gridbagConstraints.insets = new Insets(0, 0, 10, 10);
		add(connectionLabel, gridbagConstraints);

		timestampTextLabel = new JLabel(ClientConstants.TIME_STAMP);
		timestampTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		timestampTextLabel.setVerticalTextPosition(JLabel.CENTER);
		timestampTextLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		gridbagConstraints.gridx = 0;
		gridbagConstraints.gridy = 1;
		gridbagConstraints.insets = new Insets(0, 0, 0, 10);
		add(timestampTextLabel, gridbagConstraints);

		timeStampLabel = new JLabel("0.0");
		timeStampLabel.setHorizontalTextPosition(JLabel.LEFT);
		timeStampLabel.setVerticalTextPosition(JLabel.CENTER);
		timeStampLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		gridbagConstraints.gridx = 1;
		gridbagConstraints.gridy = 1;
		gridbagConstraints.insets = new Insets(0, 0, 0, 10);
		add(timeStampLabel, gridbagConstraints);
	}

	/**
	 * This method creates connect button on the Panel.
	 * @param bagConstraints to set the position of button on panel.
	 */
	private void createConnectButton(GridBagConstraints bagConstraints) {
		connectButton = new WebButton(ClientConstants.CONNECT);
		connectButton.setPreferredSize(new Dimension(120, 35));
		connectButton.setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));
		connectButton.setBottomBgColor(Color.BLACK);
		connectButton.setTopBgColor(Color.BLACK);
		connectButton.setBottomSelectedBgColor(Color.WHITE);
		connectButton.setTopSelectedBgColor(Color.WHITE);
		connectButton.setForeground(Color.WHITE);
		connectButton.setDrawShade(false);
		connectButton.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 0;
		bagConstraints.gridheight = 3;
		bagConstraints.insets = new Insets(0, 20, 0, 20);
		add(connectButton, bagConstraints);
	}

	/**
	 * This method creates server open button on panel.
	 * @param bagConstraints to set position of button on panel.
	 */
	private void createServerOpenButton(GridBagConstraints bagConstraints) {
		serverOpenButton = new WebButton(ClientConstants.OPEN_SERVER);
		serverOpenButton.setPreferredSize(new Dimension(120, 35));
		serverOpenButton.setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));
		serverOpenButton.setBottomBgColor(Color.BLACK);
		serverOpenButton.setTopBgColor(Color.BLACK);
		serverOpenButton.setBottomSelectedBgColor(Color.WHITE);
		serverOpenButton.setTopSelectedBgColor(Color.WHITE);
		serverOpenButton.setForeground(Color.WHITE);
		serverOpenButton.setDrawShade(false);
		serverOpenButton.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		bagConstraints.gridx = 3;
		bagConstraints.gridy = 0;
		bagConstraints.gridheight = 3;
		bagConstraints.insets = new Insets(0, 20, 0, 20);
		add(serverOpenButton, bagConstraints);
	}

	/**
	 * This method handles events on the connect button on panel.
	 * @param actionListener
	 */
	public void addConnectButtonListener(ActionListener actionListener) {
		connectButton.addActionListener(actionListener);
	}

	/**
	 * This method handles events on the server open button on panel.
	 * @param actionListener
	 */
	public void addServerOpenButtonListener(ActionListener actionListener) {
		serverOpenButton.addActionListener(actionListener);
	}

	/**
	 * This method updates the connection status on panel.
	 */
	public void updateConnectionLabel() {
		// May need to update this
		if (headerModel.isConnectionStatus()) {
			connectButton.setText(ClientConstants.DISCONNECT);
			connectionLabel.setText(ClientConstants.CONNECTED);
		} else {
			connectButton.setText(ClientConstants.CONNECT);
			connectionLabel.setText(ClientConstants.DISCONNECTED);
		}
	}

	/**
	 * This method updates the time stamp on the panel.
	 */
	public void updateTimeStamp() {
		timeStampLabel.setText(String.valueOf(headerModel.getTimeStamp()));
	}
}
