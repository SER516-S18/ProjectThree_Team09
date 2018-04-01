package ser516.project3.server.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import ser516.project3.server.controller.ServerControllerImpl;
import ser516.project3.utilities.InputVerifierNumericals;
import ser516.project3.utilities.ServerCommonData;

public class ServerPanelGenerator {

	final static Logger logger = Logger.getLogger(ServerPanelGenerator.class);
	
	private static ServerControllerImpl serverControllerImpl = new ServerControllerImpl();;

	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	private static final String INTERVAL_LABEL_NAME="Interval (seconds):  ";
	private static final String AUTO_REPEAT_CHECKBOX_NAME="Auto Repeat";
	private static final String TOGGLE_START_STOP="Start / Stop";


	/**
	 * This method will initialize the top JPanels of the server application
	 * 
	 * @return the top JPanel
	 */
	public static JPanel createTopPanels() {
		JPanel topPanel = new JPanel();

		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraint = new GridBagConstraints();

		topPanel.setOpaque(false);

		Border titledBorder = new TitledBorder(null, "Graph", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 10, 10);

		Border compoundBorder = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
		topPanel.setBorder(compoundBorder);

		JLabel intervalLabel = new JLabel(INTERVAL_LABEL_NAME);
		intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intervalLabel.setOpaque(true);

		JTextField intervalInputTextField = new JTextField("1");
		intervalInputTextField.setInputVerifier(new InputVerifierNumericals());
		intervalInputTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		intervalInputTextField.setColumns(3);
		intervalInputTextField.setHorizontalAlignment(SwingConstants.CENTER);
		logger.info("Testing stuff");
		intervalInputTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				logger.info("Removed value of interval");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateIntervalInputTextField(intervalInputTextField);
				logger.info("Changed value of interval: " + intervalInputTextField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

		});


		JCheckBox autoRepeatCheckBox = new JCheckBox(AUTO_REPEAT_CHECKBOX_NAME, false);
		autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		autoRepeatCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Value of auto Repeat toggle changed: " + autoRepeatCheckBox.isSelected());
				ServerCommonData.getInstance().setAutoRepeat(autoRepeatCheckBox.isSelected());
			}

		});
		
		JButton buttonToggle = new JButton(TOGGLE_START_STOP);
		buttonToggle.setHorizontalAlignment(SwingConstants.CENTER);
		buttonToggle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Start button pressed");
				updateIntervalInputTextField(intervalInputTextField);
				serverControllerImpl.startServer();
			}
		});

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 40;
		topPanel.add(intervalLabel, gridBagConstraint);

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 0.5;
		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 10;
		topPanel.add(intervalInputTextField, gridBagConstraint);

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weighty = 2.0;
		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 40;
		gridBagConstraint.insets = new Insets(0, 50, 0, 50); // left-right padding
		topPanel.add(buttonToggle, gridBagConstraint);

		gridBagConstraint.ipady = 10;
		gridBagConstraint.insets = new Insets(0, 0, 0, 0); // reset
		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 0.5;
		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;

		topPanel.add(Box.createGlue(), gridBagConstraint);

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 0.5;
		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 1;
		topPanel.add(autoRepeatCheckBox, gridBagConstraint);

		return topPanel;

	}

	/**
	 * This method will initialize the second sub panel of the Server window
	 * 
	 * @return the second sub-panel
	 * @wbp.parser.entryPoint
	 */
	public static Component createConfigurationPanels() {
		JPanel configPanel = new JPanel();
		JPanel timerPanel = new JPanel();
		JPanel emotionsPanel = new JPanel();
		JPanel expressionPanel = new JPanel();
		JPanel consolePanel = new JPanel();

		JSplitPane splitPane1 = new JSplitPane();
		JSplitPane splitPane2 = new JSplitPane();
		JSplitPane splitPane3 = new JSplitPane();

		String[] lowerFaceList = { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" };
		String[] upperFaceList = { "Raise Brow", "Furrow Brow" };
		String[] eyeList = { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" };

		configPanel.setOpaque(false);
		Border titledBorder = new TitledBorder(null, "Configuration", TitledBorder.LEADING, TitledBorder.TOP, FONT,
				null);
		Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 30, 10);

		Border compound = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
		configPanel.setBorder(compound);

		configPanel.setLayout(new BorderLayout(0, 0));

		expressionPanel.setLayout(new GridBagLayout());

		emotionsPanel
				.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));
		expressionPanel.setBorder(
				new TitledBorder(null, "Expressions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));
		consolePanel
				.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));

		JLabel lowerFaceLabel = new JLabel("Lower Face");
		GridBagConstraints lowerFaceGridConstraints = new GridBagConstraints();
		lowerFaceGridConstraints.gridx = 1;
		lowerFaceGridConstraints.gridy = 1;
		expressionPanel.add(lowerFaceLabel, lowerFaceGridConstraints);

		JComboBox<Object> lowerFaceCombo = new JComboBox<Object>();
		lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
		GridBagConstraints lowerFaceComboGbc = new GridBagConstraints();
		lowerFaceComboGbc.gridx = 2;
		lowerFaceComboGbc.gridy = 1;
		expressionPanel.add(lowerFaceCombo, lowerFaceComboGbc);

		lowerFaceCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateLowerFace(String.valueOf(lowerFaceCombo.getSelectedItem()));
			}
		});

		JToggleButton lowerFaceActivateButton = new JToggleButton("Activate");
		GridBagConstraints lowerFaceActivateButtonConstraints = new GridBagConstraints();
		lowerFaceActivateButtonConstraints.gridx = 3;
		lowerFaceActivateButtonConstraints.gridy = 1;
		expressionPanel.add(lowerFaceActivateButton, lowerFaceActivateButtonConstraints);

		lowerFaceActivateButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					updateLowerFaceAct(true);
				} else {
					updateLowerFaceAct(false);
				}
			}
		});

		JLabel upperFaceLbl = new JLabel("Upper Face");
		GridBagConstraints upperFaceGbc = new GridBagConstraints();
		upperFaceGbc.gridx = 1;
		upperFaceGbc.gridy = 2;
		expressionPanel.add(upperFaceLbl, upperFaceGbc);

		JComboBox<Object> upperFaceCombo = new JComboBox<Object>();
		upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
		GridBagConstraints upperFaceComboConstraints = new GridBagConstraints();
		upperFaceComboConstraints.gridx = 2;
		upperFaceComboConstraints.gridy = 2;
		expressionPanel.add(upperFaceCombo, upperFaceComboConstraints);

		upperFaceCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				updateUpperFace(String.valueOf(upperFaceCombo.getSelectedItem()));
			}
		});

		JToggleButton upperFaceAct = new JToggleButton("Activate");
		GridBagConstraints upperFaceActGbc = new GridBagConstraints();
		upperFaceActGbc.gridx = 3;
		upperFaceActGbc.gridy = 2;
		expressionPanel.add(upperFaceAct, upperFaceActGbc);

		upperFaceAct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					updateUpperFaceAct(true);
				} else {
					updateUpperFaceAct(false);
				}
			}
		});

		JLabel eyeLabel = new JLabel("Eye");
		GridBagConstraints eyeGbc = new GridBagConstraints();
		eyeGbc.gridx = 1;
		eyeGbc.gridy = 3;
		expressionPanel.add(eyeLabel, eyeGbc);

		JComboBox<Object> eyeCombo = new JComboBox<Object>();
		eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
		GridBagConstraints eyeComboConstraints = new GridBagConstraints();
		eyeComboConstraints.gridx = 2;
		eyeComboConstraints.gridy = 3;
		expressionPanel.add(eyeCombo, eyeComboConstraints);

		eyeCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateEye(String.valueOf(eyeCombo.getSelectedItem()));
			}
		});

		JToggleButton eyeActivateButton = new JToggleButton("Activate");
		GridBagConstraints eyeActConstraints = new GridBagConstraints();
		eyeActConstraints.gridx = 3;
		eyeActConstraints.gridy = 3;
		expressionPanel.add(eyeActivateButton, eyeActConstraints);

		eyeActivateButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					updateEyeAct(true);
				} else {
					updateEyeAct(false);
				}
			}
		});

		JCheckBox eyeCheckBox = new JCheckBox("Auto Reset");
		GridBagConstraints eyeCheckBoxConstraints = new GridBagConstraints();
		eyeCheckBoxConstraints.gridx = 4;
		eyeCheckBoxConstraints.gridy = 3;
		expressionPanel.add(eyeCheckBox, eyeCheckBoxConstraints);

		eyeCheckBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				updateEyeAutoReset(abstractButton.getModel().isSelected());
			}
		});

		splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane3.setDividerLocation(150);
		splitPane3.setTopComponent(expressionPanel);
		splitPane3.setBottomComponent(consolePanel);
		splitPane3.setDividerSize(0);
		splitPane3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setDividerLocation(150);
		splitPane2.setTopComponent(emotionsPanel);
		splitPane2.setBottomComponent(splitPane3);
		splitPane2.setDividerSize(0);
		splitPane2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane1.setDividerLocation(50);
		splitPane1.setTopComponent(timerPanel);
		splitPane1.setBottomComponent(splitPane2);
		splitPane1.setDividerSize(0);
		splitPane1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		configPanel.add(splitPane1);
		return configPanel;
	}

	private static void updateIntervalInputTextField(JTextField intervalInputTextField) {
		try {

			ServerCommonData.getInstance().setInterval(Integer.parseInt(intervalInputTextField.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
		}
	}

	private static void updateLowerFace(String lowerFaceValue) {
		ServerCommonData.getInstance().setLowerFace(lowerFaceValue);
	}

	private static void updateUpperFace(String upperFaceValue) {
		ServerCommonData.getInstance().setUpperFace(upperFaceValue);
	}

	private static void updateEye(String eyeValue) {
		ServerCommonData.getInstance().setEye(eyeValue);
	}

	private static void updateLowerFaceAct(Boolean lowerFaceValue) {
		ServerCommonData.getInstance().setLowerFaceAct(lowerFaceValue);
	}

	private static void updateUpperFaceAct(Boolean upperFaceValue) {
		ServerCommonData.getInstance().setUpperFaceAct(upperFaceValue);
	}

	private static void updateEyeAct(Boolean eyeVal) {
		ServerCommonData.getInstance().setEyeAct(eyeVal);
	}

	private static void updateEyeAutoReset(Boolean eyeAutoResetVal) {
		ServerCommonData.getInstance().setEyeAutoReset(eyeAutoResetVal);
	}

	/**
	 * @return the serverControllerImpl
	 */
	public static ServerControllerImpl getServerControllerImpl() {
		return serverControllerImpl;
	}
}
