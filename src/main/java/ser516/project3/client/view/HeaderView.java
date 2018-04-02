package ser516.project3.client.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ser516.project3.server.view.*;

/**
 * HeaderView class to implement the header view for client to show and update
 * the client status
 * 
 * @author Vishakha Singal
 * @version 1.0
 */

@SuppressWarnings("serial")
public class HeaderView extends JPanel {

	JLabel connectionLabel;
	JLabel timeStampLabel;
	JButton connectButton;
	JButton serverButton;
	JDialog connectionPopUpView;
	JDialog serverDialog;

	public HeaderView() {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(8, 8, 8, 8));
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		JLabel connectionTextLabel = new JLabel("Status:");
		connectionTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		connectionTextLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		this.add(connectionTextLabel, bagConstraints);

		connectionLabel = new JLabel("Not Connected");
		connectionLabel.setHorizontalTextPosition(JLabel.LEFT);
		connectionLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		this.add(connectionLabel, bagConstraints);

		connectButton = new JButton("Connect");
		connectButton.setBackground(Color.RED);
		connectButton.setPreferredSize(new Dimension(120, 35));
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 0;
		bagConstraints.gridheight = 3;
		bagConstraints.insets = new Insets(0, 20, 0, 20);
		this.add(connectButton, bagConstraints);

		serverButton = new JButton("Open Server");
		serverButton.setBackground(Color.BLUE);
		serverButton.setPreferredSize(new Dimension(100, 100));
		bagConstraints.gridx = -1;
		bagConstraints.gridy = -1;
		bagConstraints.gridheight = 2;
		bagConstraints.insets = new Insets(7, 5, 5, 0);
		this.add(serverButton, bagConstraints);
		serverButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(serverDialog == null) {
					serverDialog = new ServerView();
				} else {
					serverDialog.setVisible(true);
				}
			}

		});

		JLabel timestampTextLabel = new JLabel("Time Stamp: ");
		timestampTextLabel.setHorizontalAlignment(JLabel.RIGHT);
		timestampTextLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		this.add(timestampTextLabel, bagConstraints);

		timeStampLabel = new JLabel("0.0");
		timeStampLabel.setHorizontalTextPosition(JLabel.LEFT);
		timeStampLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		this.add(timeStampLabel, bagConstraints);

	}

	public void addConnectButtonListener(ActionListener actionListener) {
		connectButton.addActionListener(actionListener);
	}

	public void updateConnectionLabel(boolean isConnected) {
		// May need to update this
		if (isConnected) {
			connectButton.setText("Disconnect");
			connectionLabel.setText("Connected");
		} else {
			connectButton.setText("Connect");
			connectionLabel.setText("Not Connected");
		}
	}
}
