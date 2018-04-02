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

		Border titledBorder = new TitledBorder(null, "Configuration", TitledBorder.LEADING,
                TitledBorder.TOP, FONT, null);
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
    public static JPanel createExpressionPanel(){
        JPanel expressionPanel = new JPanel();
        String[] lowerFaceList = { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" };
        String[] upperFaceList = { "Raise Brow", "Furrow Brow" };
        String[] eyeList = { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" };
        Dimension spinnerDimension = new Dimension(60, 30);
        JLabel lowerFaceLbl = new JLabel("Lower Face");

        expressionPanel.setLayout(new GridBagLayout());
        expressionPanel.setBorder(new TitledBorder(null, "Expressions", TitledBorder.LEADING,
                TitledBorder.TOP, SUBFONT, null));

        GridBagConstraints lowerFaceGbc = new GridBagConstraints();
        lowerFaceGbc.gridx = 1;
        lowerFaceGbc.gridy = 1;
        expressionPanel.add(lowerFaceLbl, lowerFaceGbc);

        JComboBox<Object> lowerFaceCombo = new JComboBox<Object>();
        lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
        lowerFaceCombo.setPreferredSize(new Dimension(120,30));
        GridBagConstraints lowerFaceComboGbc = new GridBagConstraints();
        lowerFaceComboGbc.gridx = 2;
        lowerFaceComboGbc.gridy = 1;
        expressionPanel.add(lowerFaceCombo, lowerFaceComboGbc);

        lowerFaceCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLowerFace(String.valueOf(lowerFaceCombo.getSelectedItem()));
            }
        });

        SpinnerModel lowerFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
        JSpinner lowerFaceSpinner = new JSpinner(lowerFaceModel);

        lowerFaceSpinner.setPreferredSize(spinnerDimension);
        GridBagConstraints lowerFaceActGbc = new GridBagConstraints();
        lowerFaceActGbc.gridx = 3;
        lowerFaceActGbc.gridy = 1;
        expressionPanel.add(lowerFaceSpinner, lowerFaceActGbc);

        lowerFaceSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });

        JLabel upperFaceLbl = new JLabel("Upper Face");
        GridBagConstraints upperFaceGbc = new GridBagConstraints();
        upperFaceGbc.gridx = 1;
        upperFaceGbc.gridy = 2;
        expressionPanel.add(upperFaceLbl, upperFaceGbc);

        JComboBox<Object> upperFaceCombo = new JComboBox<Object>();
        upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
        upperFaceCombo.setPreferredSize(new Dimension(120,30));

        GridBagConstraints upperFaceComboGbc = new GridBagConstraints();
        upperFaceComboGbc.gridx = 2;
        upperFaceComboGbc.gridy = 2;
        expressionPanel.add(upperFaceCombo, upperFaceComboGbc);

        upperFaceCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateUpperFace(String.valueOf(upperFaceCombo.getSelectedItem()));
            }
        });

        SpinnerModel upperFaceModel = new SpinnerNumberModel(0.00, 0.00, 1.00, 0.10);
        JSpinner upperFaceSpinner = new JSpinner(upperFaceModel);

        upperFaceSpinner.setPreferredSize(spinnerDimension);
        GridBagConstraints upperFaceActGbc = new GridBagConstraints();
        upperFaceActGbc.gridx = 3;
        upperFaceActGbc.gridy = 2;
        expressionPanel.add(upperFaceSpinner, upperFaceActGbc);

        upperFaceSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });

        JLabel eyeLabel = new JLabel("Eye");
        GridBagConstraints eyeGbc = new GridBagConstraints();
        eyeGbc.gridx = 1;
        eyeGbc.gridy = 3;
        expressionPanel.add(eyeLabel, eyeGbc);

        JComboBox<Object> eyeCombo = new JComboBox<Object>();
        eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
        eyeCombo.setPreferredSize(new Dimension(120,30));

        GridBagConstraints eyeComboGbc = new GridBagConstraints();
        eyeComboGbc.gridx = 2;
        eyeComboGbc.gridy = 3;
        expressionPanel.add(eyeCombo, eyeComboGbc);

        eyeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateEye(String.valueOf(eyeCombo.getSelectedItem()));
            }
        });

        JToggleButton eyeAct = new JToggleButton("Activate");
        eyeAct.setPreferredSize(new Dimension(90,30));
        GridBagConstraints eyeActGbc = new GridBagConstraints();
        eyeActGbc.gridx = 3;
        eyeActGbc.gridy = 3;
        expressionPanel.add(eyeAct, eyeActGbc);

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
        expressionPanel.add(eyeCheckBox, eyeCheckBoxGbc);

        eyeCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AbstractButton abstractButton = (AbstractButton) e.getSource();
                updateEyeAutoReset(abstractButton.getModel().isSelected());
            }
        });
        return expressionPanel;
    }

    public static JPanel createEmotionsPanel(){
        JPanel emotionsPanel=new JPanel();
        emotionsPanel.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING,
                TitledBorder.TOP, SUBFONT, null));
        
        Dimension spinnerDimension = new Dimension(65, 30);
        Double current = new Double(0.00);
        Double min = new Double(0.00);
        Double max = new Double(1.00);
        Double step = new Double(0.10);
        
        JLabel interest_label = new JLabel("Interest");
        GridBagConstraints interestGbc = new GridBagConstraints();
        interestGbc.gridx = 1;
        interestGbc.gridy = 1;
        emotionsPanel.add(interest_label, interestGbc);

        SpinnerModel interest_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner i_spinner = new JSpinner(interest_spinner);
        i_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints i_spinnerGbc = new GridBagConstraints();
        i_spinnerGbc.gridx = 3;
        i_spinnerGbc.gridy = 1;
        emotionsPanel.add(i_spinner, i_spinnerGbc);
        i_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });

        JLabel engagement_label = new JLabel("Engagement");
        GridBagConstraints engagementGbc = new GridBagConstraints();
        engagementGbc.gridx = 1;
        engagementGbc.gridy = 2;
        emotionsPanel.add(engagement_label, engagementGbc);

        SpinnerModel engagement_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner e_spinner = new JSpinner(engagement_spinner);
        e_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints e_spinnerGbc = new GridBagConstraints();
        e_spinnerGbc.gridx = 3;
        e_spinnerGbc.gridy = 2;
        emotionsPanel.add(e_spinner, e_spinnerGbc);
        e_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });

        JLabel excitement_label = new JLabel("Excitement");
        GridBagConstraints excitementGbc = new GridBagConstraints();
        excitementGbc.gridx = 1;
        excitementGbc.gridy = 3;
        emotionsPanel.add(excitement_label, excitementGbc);

        SpinnerModel excitement_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner ex_spinner = new JSpinner(excitement_spinner);
        ex_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints ex_spinnerGbc = new GridBagConstraints();
        ex_spinnerGbc.gridx = 3;
        ex_spinnerGbc.gridy = 3;
        emotionsPanel.add(ex_spinner, ex_spinnerGbc);
        ex_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });
        
        JLabel stress_label = new JLabel("Stress");
        GridBagConstraints stressGbc = new GridBagConstraints();
        stressGbc.gridx = 2;
        stressGbc.gridy = 2;
        emotionsPanel.add(stress_label, stressGbc);

        SpinnerModel stress_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner s_spinner = new JSpinner(stress_spinner);
        s_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints s_spinnerGbc = new GridBagConstraints();
        s_spinnerGbc.gridx = 3;
        s_spinnerGbc.gridy = 4;
        emotionsPanel.add(s_spinner, s_spinnerGbc);
        s_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });
        
        JLabel relaxation_label = new JLabel("Relaxation");
        GridBagConstraints relaxationGbc = new GridBagConstraints();
        relaxationGbc.gridx = 1;
        relaxationGbc.gridy = 5;
        emotionsPanel.add(relaxation_label, relaxationGbc);

        SpinnerModel relaxation_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner r_spinner = new JSpinner(relaxation_spinner);
        r_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints r_spinnerGbc = new GridBagConstraints();
        r_spinnerGbc.gridx = 3;
        r_spinnerGbc.gridy = 5;
        emotionsPanel.add(r_spinner, r_spinnerGbc);
        r_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });
        
        JLabel focus_label = new JLabel("Focus");
        GridBagConstraints focusGbc = new GridBagConstraints();
        focusGbc.gridx = 1;
        focusGbc.gridy = 6;
        emotionsPanel.add(focus_label, focusGbc);

        SpinnerModel focus_spinner = new SpinnerNumberModel(current, min, max, step);
        JSpinner f_spinner = new JSpinner(focus_spinner);
        f_spinner.setPreferredSize(spinnerDimension);
        GridBagConstraints f_spinnerGbc = new GridBagConstraints();
        f_spinnerGbc.gridx = 3;
        f_spinnerGbc.gridy = 6;
        emotionsPanel.add(f_spinner, f_spinnerGbc);
        f_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //To be implemented
            }
        });

        return emotionsPanel;
    }

    public static JPanel createConsolePanel(){
        JPanel consolePanel=new JPanel();
        consolePanel.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING,
                TitledBorder.TOP, SUBFONT, null));
        //Add Components to Console panel here
        return consolePanel;
    }

    public static JPanel createTimerPanel(){
        JPanel timerPanel=new JPanel();
        //Add Components to Timer panel here
        return timerPanel;
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
