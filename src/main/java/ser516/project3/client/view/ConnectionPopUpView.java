package ser516.project3.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.ClientControllerInterface;

/**
 * ConnectioonPopUp class to show the pop up dialog in which user can enter the
 * server information to connect to the server like IP Address and Port Number.
 * 
 * @author vishakhasingal
 * @version 1.0
 */

@SuppressWarnings("serial")
public class ConnectionPopUpView extends JDialog {
	final static Logger logger = Logger.getLogger(ConnectionPopUpView.class);
	private ClientControllerInterface clientControllerImpl;
	private String ipAddress;
	private int port;

	public ConnectionPopUpView() {

		clientControllerImpl = new ClientControllerImpl();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(280, 200));
		setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		mainPanel.setOpaque(false);
		mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);

		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		JLabel ipAddressLabel = new JLabel("IP Address: ");
		ipAddressLabel.setHorizontalAlignment(JLabel.RIGHT);
		ipAddressLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		mainPanel.add(ipAddressLabel, bagConstraints);

		JLabel portNumberLabel = new JLabel("Port Number:");
		portNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		portNumberLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(portNumberLabel, bagConstraints);

		JTextField ipAddressTextField = new JTextField();
		ipAddressTextField.setPreferredSize(new Dimension(120, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 0);
		mainPanel.add(ipAddressTextField, bagConstraints);
		ipAddressTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				ipAddress = ipAddressTextField.getText();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				ipAddress = ipAddressTextField.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		JTextField portNumberTextField = new JTextField();
		portNumberTextField.setPreferredSize(new Dimension(80, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(portNumberTextField, bagConstraints);
		portNumberTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					port = Integer.parseInt(portNumberTextField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					port = Integer.parseInt(portNumberTextField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		JButton connectButton = new JButton("Connect");
		connectButton.setBackground(Color.RED);
		connectButton.setPreferredSize(new Dimension(120, 35));
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(20, 20, 0, 20);
		mainPanel.add(connectButton, bagConstraints);
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				invokeConnectButtonListener(e);
			}
		});

		add(mainPanel);
		setVisible(true);

		// add a window listener
		ConnectionPopUpView.this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				clientControllerImpl.stopClientConnector();
				logger.info("popup window closed");
			}

		});
	}

	private void invokeConnectButtonListener(ActionEvent e) {
		clientControllerImpl.toggleConnectionToServer(ipAddress, port);
	}

}
