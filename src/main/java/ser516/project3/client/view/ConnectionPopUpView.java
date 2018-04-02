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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.ClientControllerInterface;
import ser516.project3.model.ConnectionPopUpModel;
import ser516.project3.utilities.NumberTextField;

/**
 * ConnectioonPopUp class to show the pop up dialog in which user can enter the
 * server information to connect to the server like IP Address and Port Number.
 * 
 * @author Vishakha Singal, Adhiraj Tikku
 * @version 1.0
 */
public class ConnectionPopUpView extends JDialog {
	final static Logger logger = Logger.getLogger(ConnectionPopUpView.class);
	private ClientControllerInterface clientControllerImpl;
	private ConnectionPopUpModel connectionPopUpModel;
	private JPanel mainPanel;
	private JLabel ipAddressLabel;
	private JLabel portNumberLabel;
	private JTextField ipAddressTextField;
	private NumberTextField portNumberTextField;
	private JButton connectButton;

	public ConnectionPopUpView(ConnectionPopUpModel connectionPopUpModel) {

		this.connectionPopUpModel = connectionPopUpModel;
		clientControllerImpl = new ClientControllerImpl();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(280, 200));
		setResizable(false);
		setTitle("Connect to Server");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		initializeConnectionPopUpView();
	}

	private void initializeConnectionPopUpView() {
		createMainPanel();

		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		createLabels(bagConstraints);
		createTextFields(bagConstraints);
		createConnectButton(bagConstraints);

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

	private void createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setOpaque(false);
		mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);
	}

	private void createLabels(GridBagConstraints bagConstraints) {
		ipAddressLabel = new JLabel("IP Address: ");
		ipAddressLabel.setHorizontalAlignment(JLabel.RIGHT);
		ipAddressLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		mainPanel.add(ipAddressLabel, bagConstraints);

		portNumberLabel = new JLabel("Port Number:");
		portNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		portNumberLabel.setVerticalTextPosition(JLabel.CENTER);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(portNumberLabel, bagConstraints);
	}

	private void createTextFields(GridBagConstraints bagConstraints) {
		ipAddressTextField = new JTextField(connectionPopUpModel.getIpAddress());
		ipAddressTextField.setPreferredSize(new Dimension(120, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 0);
		mainPanel.add(ipAddressTextField, bagConstraints);

		portNumberTextField = new NumberTextField("" + connectionPopUpModel.getPortNumber());
		portNumberTextField.setPreferredSize(new Dimension(80, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(portNumberTextField, bagConstraints);
	}

	private void createConnectButton(GridBagConstraints bagConstraints) {
		connectButton = new JButton("Connect");
		connectButton.setBackground(Color.RED);
		connectButton.setPreferredSize(new Dimension(120, 35));
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(20, 20, 0, 20);
		mainPanel.add(connectButton, bagConstraints);
	}

	public void addConnectButtonListener(ActionListener actionListener) {
		connectButton.addActionListener(actionListener);
	}

	public void addIPDocumentListener(DocumentListener documentListener) {
		ipAddressTextField.getDocument().addDocumentListener(documentListener);
	}

	public void addPortDocumentListener(DocumentListener documentListener) {
		portNumberTextField.getDocument().addDocumentListener(documentListener);
	}
}
