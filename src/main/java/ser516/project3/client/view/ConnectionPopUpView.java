package ser516.project3.client.view;

import com.alee.laf.button.WebButton;
import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.ConnectionPopUpModel;
import ser516.project3.utilities.NumberTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * ConnectioonPopUp class to show the pop up dialog in which user can enter the
 * server information to connect to the server like IP Address and Port Number.
 * 
 * @author Vishakha Singal, Adhiraj Tikku
 * @version 1.0
 */
public class ConnectionPopUpView extends JDialog implements ViewInterface{
	private ConnectionPopUpModel connectionPopUpModel;
	private JPanel mainPanel;
	private JLabel ipAddressLabel;
	private JLabel portNumberLabel;
	private JTextField ipAddressTextField;
	private NumberTextField portNumberTextField;
	private WebButton okButton;

	private final static int FONT_SIZE = 15;

	/**
	 * This methods uses the model to get and set IP address and port number
	 * entered by the client.
	 * 
	 * @param connectionPopUpModel 
	 */
	public ConnectionPopUpView(ConnectionPopUpModel connectionPopUpModel) {
		this.connectionPopUpModel = connectionPopUpModel;
	}

	/** 
	 * Overriden method that creates a pop up menu to enter IP address and port number.
	 * 
	 * @param subViews
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(280, 200));
		setResizable(false);
		setTitle(ClientConstants.CONNECTION_POP_UP_TITLE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;

		createMainPanel();
		createLabels(bagConstraints);
		createTextFields(bagConstraints);
		createOkButton(bagConstraints);

		add(mainPanel);
		setVisible(true);
	}

	/**
	 * Creates a panel that contains labels and text fields.
	 * 
	 */
	private void createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);
	}

	/** 
	 * Creates labels to ask for IP address and port number.
	 * 
	 * @param bagConstraints
	 */
	private void createLabels(GridBagConstraints bagConstraints) {
		ipAddressLabel = new JLabel(ClientConstants.IP_ADDRESS);
		ipAddressLabel.setHorizontalAlignment(JLabel.RIGHT);
		ipAddressLabel.setVerticalTextPosition(JLabel.CENTER);
		ipAddressLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 10);
		mainPanel.add(ipAddressLabel, bagConstraints);

		portNumberLabel = new JLabel(ClientConstants.PORT_NUMBER);
		portNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		portNumberLabel.setVerticalTextPosition(JLabel.CENTER);
		portNumberLabel.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(portNumberLabel, bagConstraints);
	}

	/**
	 * Creates text fields for the client to enter IP address and port number
	 * 
	 * @param bagConstraints
	 */
	private void createTextFields(GridBagConstraints bagConstraints) {
		ipAddressTextField = new JTextField(connectionPopUpModel.getIpAddress());
		ipAddressTextField.setPreferredSize(new Dimension(120, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 0, 10, 0);
		mainPanel.add(ipAddressTextField, bagConstraints);

		portNumberTextField = new NumberTextField("" + connectionPopUpModel.getPortNumber(), false);
		portNumberTextField.setPreferredSize(new Dimension(80, 20));
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(portNumberTextField, bagConstraints);
	}

	/**
	 * Creates a button that confirms the IP address and port number entered.
	 * 
	 * @param bagConstraints
	 */
	private void createOkButton(GridBagConstraints bagConstraints) {
		okButton = new WebButton(ClientConstants.OK);
		okButton.setPreferredSize(new Dimension(120, 35));
		okButton.setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));
		okButton.setBottomBgColor(Color.BLACK);
		okButton.setTopBgColor(Color.BLACK);
		okButton.setBottomSelectedBgColor(Color.WHITE);
		okButton.setTopSelectedBgColor(Color.WHITE);
		okButton.setForeground(Color.WHITE);
		okButton.setDrawShade(false);
		okButton.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(20, 20, 0, 20);
		mainPanel.add(okButton, bagConstraints);
	}

	/** 
	 * This method is called when the OK button is clicked.
	 * 
	 * @param actionListener
	 */
	public void addConnectButtonListener(ActionListener actionListener) {
		okButton.addActionListener(actionListener);
	}

	/**
	 * This method gets the value entered for the IP address.
	 * 
	 * @param documentListener
	 */
	public void addIPDocumentListener(DocumentListener documentListener) {
		ipAddressTextField.getDocument().addDocumentListener(documentListener);
	}

	/**
	 * This method gets the value entered for port number.
	 * 
	 * @param documentListener
	 */
	public void addPortDocumentListener(DocumentListener documentListener) {
		portNumberTextField.getDocument().addDocumentListener(documentListener);
	}
}
