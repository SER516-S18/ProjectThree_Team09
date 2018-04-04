package ser516.project3.server.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import ser516.project3.model.ConsoleModel;
import ser516.project3.model.Message.AbstractExpression;
import ser516.project3.server.controller.ServerControllerImpl;
import ser516.project3.utilities.InputVerifierNumericals;
import ser516.project3.utilities.ServerCommonData;

public class ServerPanelGenerator {

	final static Logger logger = Logger.getLogger(ServerPanelGenerator.class);

	private static ServerControllerImpl serverControllerImpl = new ServerControllerImpl();

	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	private static final String INTERVAL_LABEL_NAME = "Interval (seconds):  ";
	private static final String AUTO_REPEAT_CHECKBOX_NAME = "Auto Repeat";
	private static final String TOGGLE_START_STOP = "Start / Stop";

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
		JPanel timerPanel = createTimerPanel();
		JPanel emotionsPanel = createEmotionsPanel();
		JPanel expressionPanel = createExpressionPanel();
		JPanel consolePanel = createConsolePanel();

		JSplitPane splitPane1 = new JSplitPane();
		JSplitPane splitPane2 = new JSplitPane();
		JSplitPane splitPane3 = new JSplitPane();

		configPanel.setOpaque(false);

		configPanel.add(timerPanel);
		configPanel.add(emotionsPanel);
		configPanel.add(expressionPanel);
		configPanel.add(consolePanel);

		Border titledBorder = new TitledBorder(null, "Configuration", TitledBorder.LEADING, TitledBorder.TOP, FONT,
				null);
		Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 30, 10);

		Border compound = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
		configPanel.setBorder(compound);

		configPanel.setLayout(new BorderLayout(0, 0));

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

	public static JPanel createExpressionPanel() {
		JPanel expressionPanel = new JPanel();
		String[] lowerFaceList = { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" };
		String[] upperFaceList = { "Raise Brow", "Furrow Brow" };
		String[] eyeList = { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" };
		Dimension spinnerDimension = new Dimension(60, 30);
		JLabel lowerFaceLbl = new JLabel("Lower Face");

		expressionPanel.setLayout(new GridBagLayout());
		expressionPanel.setBorder(
				new TitledBorder(null, "Expressions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));

		GridBagConstraints lowerFaceGbc = new GridBagConstraints();
		lowerFaceGbc.gridx = 1;
		lowerFaceGbc.gridy = 1;
		expressionPanel.add(lowerFaceLbl, lowerFaceGbc);

		JComboBox<Object> lowerFaceCombo = new JComboBox<Object>();
		lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
		lowerFaceCombo.setPreferredSize(new Dimension(120, 30));
		GridBagConstraints lowerFaceComboGbc = new GridBagConstraints();
		lowerFaceComboGbc.gridx = 2;
		lowerFaceComboGbc.gridy = 1;
		expressionPanel.add(lowerFaceCombo, lowerFaceComboGbc);

		SpinnerModel lowerFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
		JSpinner lowerFaceSpinner = new JSpinner(lowerFaceModel);

		lowerFaceSpinner.setPreferredSize(spinnerDimension);
		GridBagConstraints lowerFaceActGbc = new GridBagConstraints();
		lowerFaceActGbc.gridx = 3;
		lowerFaceActGbc.gridy = 1;
		expressionPanel.add(lowerFaceSpinner, lowerFaceActGbc);

		JLabel upperFaceLbl = new JLabel("Upper Face");
		GridBagConstraints upperFaceGbc = new GridBagConstraints();
		upperFaceGbc.gridx = 1;
		upperFaceGbc.gridy = 2;
		expressionPanel.add(upperFaceLbl, upperFaceGbc);

		JComboBox<Object> upperFaceCombo = new JComboBox<Object>();
		upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
		upperFaceCombo.setPreferredSize(new Dimension(120, 30));

		GridBagConstraints upperFaceComboGbc = new GridBagConstraints();
		upperFaceComboGbc.gridx = 2;
		upperFaceComboGbc.gridy = 2;
		expressionPanel.add(upperFaceCombo, upperFaceComboGbc);

		SpinnerModel upperFaceModel = new SpinnerNumberModel(0.00, 0.00, 1.00, 0.10);
		JSpinner upperFaceSpinner = new JSpinner(upperFaceModel);

		upperFaceSpinner.setPreferredSize(spinnerDimension);
		GridBagConstraints upperFaceActGbc = new GridBagConstraints();
		upperFaceActGbc.gridx = 3;
		upperFaceActGbc.gridy = 2;
		expressionPanel.add(upperFaceSpinner, upperFaceActGbc);

		JLabel eyeLabel = new JLabel("Eye");
		GridBagConstraints eyeGbc = new GridBagConstraints();
		eyeGbc.gridx = 1;
		eyeGbc.gridy = 3;
		expressionPanel.add(eyeLabel, eyeGbc);

		JComboBox<Object> eyeCombo = new JComboBox<Object>();
		eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
		eyeCombo.setPreferredSize(new Dimension(120, 30));

		GridBagConstraints eyeComboGbc = new GridBagConstraints();
		eyeComboGbc.gridx = 2;
		eyeComboGbc.gridy = 3;
		expressionPanel.add(eyeCombo, eyeComboGbc);

		JToggleButton eyeAct = new JToggleButton("Activate");
		eyeAct.setPreferredSize(new Dimension(90, 30));
		GridBagConstraints eyeActGbc = new GridBagConstraints();
		eyeActGbc.gridx = 3;
		eyeActGbc.gridy = 3;
		expressionPanel.add(eyeAct, eyeActGbc);

		JCheckBox eyeCheckBox = new JCheckBox("Auto Reset");
		GridBagConstraints eyeCheckBoxGbc = new GridBagConstraints();
		eyeCheckBoxGbc.gridx = 4;
		eyeCheckBoxGbc.gridy = 3;
		expressionPanel.add(eyeCheckBox, eyeCheckBoxGbc);

		lowerFaceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(lowerFaceCombo.getSelectedItem());
				Double value = (Double) lowerFaceSpinner.getValue();
				updateLowerFace(attribute, value);
			}
		});

		lowerFaceSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String attribute = String.valueOf(lowerFaceCombo.getSelectedItem());
				Double value = (Double) lowerFaceSpinner.getValue();
				updateLowerFace(attribute, value);
			}
		});

		upperFaceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(upperFaceCombo.getSelectedItem());
				Double value = (Double) upperFaceSpinner.getValue();
				updateUpperFace(attribute, value);
			}
		});

		upperFaceSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String attribute = String.valueOf(upperFaceCombo.getSelectedItem());
				Double value = (Double) upperFaceSpinner.getValue();
				updateUpperFace(attribute, value);
			}
		});

		eyeCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(eyeCombo.getSelectedItem());
				Boolean eyeStatus = eyeAct.isSelected();
				updateEye(attribute, eyeStatus);
			}
		});

		eyeAct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				String attribute = String.valueOf(eyeCombo.getSelectedItem());
				Boolean eyeStatus = eyeAct.isSelected();
				updateEye(attribute, eyeStatus);
			}
		});

		eyeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// To be implemented
				// AbstractButton abstractButton = (AbstractButton) e.getSource();
				// updateEyeAutoReset(abstractButton.getModel().isSelected());

			}
		});

		return expressionPanel;
	}

	public enum EmotionPanel{
		Interest(1, 1, 3, 1), Engagement(1, 2, 3, 2), Excitement(1, 3, 3, 3), Stress(2, 2, 3, 4), Relaxation(1, 5, 3, 5), Focus(1, 6, 3, 6);
		int gbc_x, gbc_y, spinner_x, spinner_y;
		private EmotionPanel(int gbc_x, int gbc_y, int spinner_x, int spinner_y){
			this.gbc_x = gbc_x;
			this.gbc_y = gbc_y;
			this.spinner_x = spinner_x;
			this.spinner_y = spinner_y;
		}
	}
	
	public static JPanel createEmotionsPanel() {
		JPanel emotionsPanel = new JPanel();
		emotionsPanel
				.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));

		Dimension spinnerDimension = new Dimension(65, 30);
		Double current = new Double(0.00);
		Double min = new Double(0.00);
		Double max = new Double(1.00);
		Double step = new Double(0.10);

		for(EmotionPanel em : EmotionPanel.values()) {
			JLabel interest_label = new JLabel(em.name());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = em.gbc_x;
			gbc.gridy = em.gbc_y;
			emotionsPanel.add(interest_label, gbc);
			SpinnerModel spinner = new SpinnerNumberModel(current, min, max, step);
			JSpinner jspinner = new JSpinner(spinner);
			jspinner.setPreferredSize(spinnerDimension);
			GridBagConstraints spinnerGbc = new GridBagConstraints();
			spinnerGbc.gridx = em.spinner_x;
			spinnerGbc.gridy = em.spinner_y;
			emotionsPanel.add(jspinner, spinnerGbc);
			jspinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					ServerCommonData.getInstance().getMessage().setEmotion(em.name(), (Double) jspinner.getValue());
				}
			});
		}
		return emotionsPanel;
	}

	public static JPanel createConsolePanel() {
		ConsoleView consoleView = new ConsoleView();
		ConsoleModel.getInstance().addObserver(consoleView);
		return consoleView.getConsolePanel();
	}

	public static JPanel createTimerPanel() {
		JPanel timerPanel = new JPanel();
		// Add Components to Timer panel here
		return timerPanel;
	}

	private static void updateIntervalInputTextField(JTextField intervalInputTextField) {
		try {
			ServerCommonData.getInstance().getMessage().setInterval(Integer.parseInt(intervalInputTextField.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
		}
	}
	

	private static void updateLowerFace(String lowerFaceAttribute, Double lowerFaceVal) {
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.smile.name() , lowerFaceAttribute.equals("Smile") ? lowerFaceVal : 0.0);
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.clench.name(), lowerFaceAttribute.equals("Clench") ? lowerFaceVal : 0.0);
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.leftSmirk.name(), lowerFaceAttribute.equals("Smirk Left") ? lowerFaceVal : 0.0);
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.rightSmirk.name(), lowerFaceAttribute.equals("Smirk Right") ? lowerFaceVal : 0.0);
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.laugh.name(), lowerFaceAttribute.equals("Laugh") ? lowerFaceVal : 0.0);
	}

	private static void updateUpperFace(String upperFaceAttribute, Double upperFaceVal) {
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.raiseBrow.name(),  upperFaceAttribute.equals("Raise Brow") ? upperFaceVal : 0.0);
			ServerCommonData.getInstance().getMessage().setAbstractExpression(AbstractExpression.furrowBrow.name(),  upperFaceAttribute.equals("Furrow Brow") ? upperFaceVal : 0.0);		
	}

	private static void updateEye(String eyeAttribute, Boolean eyeVal) {
			ServerCommonData.getInstance().getMessage().setConcreteExpression(AbstractExpression.blink.name(), eyeAttribute.equals("Blink") ? eyeVal : false);
			ServerCommonData.getInstance().getMessage().setConcreteExpression(AbstractExpression.leftWink.name(), eyeAttribute.equals("Wink Left") ? eyeVal : false);
			ServerCommonData.getInstance().getMessage().setConcreteExpression(AbstractExpression.rightWink.name(), eyeAttribute.equals("Wink Right") ? eyeVal : false);
			ServerCommonData.getInstance().getMessage().setConcreteExpression(AbstractExpression.lookingLeft.name(), eyeAttribute.equals("Look Left") ? eyeVal : false);
			ServerCommonData.getInstance().getMessage().setConcreteExpression(AbstractExpression.lookingRight.name(), eyeAttribute.equals("Look Right") ? eyeVal : false);
	}

	/**
	 * @return the serverControllerImpl
	 */
	public static ServerControllerImpl getServerControllerImpl() {
		return serverControllerImpl;
	}
}
