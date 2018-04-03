package ser516.project3.client.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import ser516.project3.constants.ClientConstants;
import ser516.project3.model.HeaderModel;

/**
 * HeaderView class to implement the header view for client to show and update
 * the client status
 * 
 * @author Vishakha Singal, Adhiraj Tikku
 * @version 1.0
 */
public class HeaderView extends JPanel {

	private JLabel connectionLabel;
	private JLabel timeStampLabel;
	private JLabel connectionTextLabel;
	private JLabel timestampTextLabel;
	private JButton connectButton;
	private HeaderModel headerModel;

	public HeaderView(HeaderModel headerModel) {
		this.headerModel = headerModel;
		setLayout(new BorderLayout());
		setOpaque(false);
		setBorder(new EmptyBorder(8, 8, 8, 8));
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);

		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		createLabels(bagConstraints);
		createButtons(bagConstraints);
	}

	private void createLabels(GridBagConstraints bagConstraints) {
		connectionTextLabel = new JLabel(ClientConstants.STATUS);
		connectionTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		connectionTextLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		add(connectionTextLabel, bagConstraints);

		connectionLabel = new JLabel(ClientConstants.DISCONNECTED);
		connectionLabel.setHorizontalTextPosition(JLabel.LEFT);
		connectionLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		add(connectionLabel, bagConstraints);

		timestampTextLabel = new JLabel(ClientConstants.TIME_STAMP);
		timestampTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		timestampTextLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		add(timestampTextLabel, bagConstraints);

		timeStampLabel = new JLabel("0.0");
		timeStampLabel.setHorizontalTextPosition(JLabel.LEFT);
		timeStampLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		add(timeStampLabel, bagConstraints);
	}

	private void createButtons(GridBagConstraints bagConstraints) {
		connectButton = new JButton(ClientConstants.CONNECT);
		connectButton.setBackground(Color.RED);
		connectButton.setPreferredSize(new Dimension(120, 35));
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 0;
		bagConstraints.gridheight = 3;
		bagConstraints.insets = new Insets(0, 20, 0, 20);
		add(connectButton, bagConstraints);
	}

	public void addConnectButtonListener(ActionListener actionListener) {
		connectButton.addActionListener(actionListener);
	}

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
}
