package ser516.project3.server.view;

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
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ser516.project3.utilities.InputVerifierNumericals;
import ser516.project3.utilities.ServerCommonData;
import java.awt.BorderLayout;

public class ServerPanelGenerator {

	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);

	/**
	 * This method will initialize the top JPanels of the server application
	 * 
	 * @return the top JPanel
	 */
	public static JPanel createTopPanels() {
		JPanel topPanel = new JPanel();

		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		topPanel.setOpaque(false);

		Border titledBorder = new TitledBorder(null, "Graph", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 10, 10);

		Border compound = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
		topPanel.setBorder(compound);

		JLabel intervalLabel = new JLabel("Interval (seconds):  ");
		intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intervalLabel.setOpaque(true);

		JTextField intervalInputTextField = new JTextField("1");
		intervalInputTextField.setInputVerifier(new InputVerifierNumericals());
		intervalInputTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		intervalInputTextField.setColumns(3);
		intervalInputTextField.setHorizontalAlignment(SwingConstants.CENTER);
		intervalInputTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// updateIntervalInputTextField(intervalInputTextField);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// updateIntervalInputTextField(intervalInputTextField);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateIntervalInputTextField(intervalInputTextField);
			}

		});

		JButton buttonToggle = new JButton("Start / Stop");

		JCheckBox autoRepeatCheckBox = new JCheckBox("Auto Repeat", false);
		autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 40;
		topPanel.add(intervalLabel, c);

		buttonToggle.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 10;
		topPanel.add(intervalInputTextField, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 2.0;
		c.gridx = 2;
		c.gridy = 0;
		c.ipady = 40;
		c.insets = new Insets(0, 50, 0, 50); // left-right padding
		topPanel.add(buttonToggle, c);

		c.ipady = 10;
		c.insets = new Insets(0, 0, 0, 0); // reset
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;

		topPanel.add(Box.createGlue(), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		topPanel.add(autoRepeatCheckBox, c);

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
		JPanel exprPanel = new JPanel();
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

		exprPanel.setLayout(new GridBagLayout());

		emotionsPanel
				.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));
		exprPanel.setBorder(
				new TitledBorder(null, "Expressions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));
		consolePanel
				.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));

		JLabel lowerFaceLbl = new JLabel("Lower Face");
		GridBagConstraints lowerFaceGbc = new GridBagConstraints();
		lowerFaceGbc.gridx = 1;
		lowerFaceGbc.gridy = 1;
		exprPanel.add(lowerFaceLbl, lowerFaceGbc);

		JComboBox<Object> lowerFaceCombo = new JComboBox<Object>();
		lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
		GridBagConstraints lowerFaceComboGbc = new GridBagConstraints();
		lowerFaceComboGbc.gridx = 2;
		lowerFaceComboGbc.gridy = 1;
		exprPanel.add(lowerFaceCombo, lowerFaceComboGbc);

		lowerFaceCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateLowerFace(String.valueOf(lowerFaceCombo.getSelectedItem()));
			}
		});

		JToggleButton lowerFaceAct = new JToggleButton("Activate");
		GridBagConstraints lowerFaceActGbc = new GridBagConstraints();
		lowerFaceActGbc.gridx = 3;
		lowerFaceActGbc.gridy = 1;
		exprPanel.add(lowerFaceAct, lowerFaceActGbc);

		lowerFaceAct.addItemListener(new ItemListener() {
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
		exprPanel.add(upperFaceLbl, upperFaceGbc);

		JComboBox<Object> upperFaceCombo = new JComboBox<Object>();
		upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
		GridBagConstraints upperFaceComboGbc = new GridBagConstraints();
		upperFaceComboGbc.gridx = 2;
		upperFaceComboGbc.gridy = 2;
		exprPanel.add(upperFaceCombo, upperFaceComboGbc);

		upperFaceCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				updateUpperFace(String.valueOf(upperFaceCombo.getSelectedItem()));
			}
		});

		JToggleButton upperFaceAct = new JToggleButton("Activate");
		GridBagConstraints upperFaceActGbc = new GridBagConstraints();
		upperFaceActGbc.gridx = 3;
		upperFaceActGbc.gridy = 2;
		exprPanel.add(upperFaceAct, upperFaceActGbc);

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
		exprPanel.add(eyeLabel, eyeGbc);

		JComboBox<Object> eyeCombo = new JComboBox<Object>();
		eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
		GridBagConstraints eyeComboGbc = new GridBagConstraints();
		eyeComboGbc.gridx = 2;
		eyeComboGbc.gridy = 3;
		exprPanel.add(eyeCombo, eyeComboGbc);

		eyeCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateEye(String.valueOf(eyeCombo.getSelectedItem()));
			}
		});

		JToggleButton eyeAct = new JToggleButton("Activate");
		GridBagConstraints eyeActGbc = new GridBagConstraints();
		eyeActGbc.gridx = 3;
		eyeActGbc.gridy = 3;
		exprPanel.add(eyeAct, eyeActGbc);

		eyeAct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					updateEyeAct(true);
				} else {
					updateEyeAct(false);
				}
			}
		});

		JCheckBox eyeCheckBox = new JCheckBox("Auto Reset");
		GridBagConstraints eyeCheckBoxGbc = new GridBagConstraints();
		eyeCheckBoxGbc.gridx = 4;
		eyeCheckBoxGbc.gridy = 3;
		exprPanel.add(eyeCheckBox, eyeCheckBoxGbc);

		eyeCheckBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
				updateEyeAutoReset(abstractButton.getModel().isSelected());
			}
		});

		splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane3.setDividerLocation(150);
		splitPane3.setTopComponent(exprPanel);
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
		ServerCommonData.getInstance().setInterval(Integer.parseInt(intervalInputTextField.getText()));
	}

	private static void updateLowerFace(String lowerFaceVal) {
		ServerCommonData.getInstance().setLowerFace(lowerFaceVal);
	}

	private static void updateUpperFace(String UpperFaceVal) {
		ServerCommonData.getInstance().setUpperFace(UpperFaceVal);
	}

	private static void updateEye(String eyeVal) {
		ServerCommonData.getInstance().setEye(eyeVal);
	}

	private static void updateLowerFaceAct(Boolean lowerFaceVal) {
		ServerCommonData.getInstance().setLowerFaceAct(lowerFaceVal);
	}

	private static void updateUpperFaceAct(Boolean UpperFaceVal) {
		ServerCommonData.getInstance().setUpperFaceAct(UpperFaceVal);
	}

	private static void updateEyeAct(Boolean eyeVal) {
		ServerCommonData.getInstance().setEyeAct(eyeVal);
	}

	private static void updateEyeAutoReset(Boolean eyeAutoResetVal) {
		ServerCommonData.getInstance().setEyeAutoReset(eyeAutoResetVal);
	}
}
