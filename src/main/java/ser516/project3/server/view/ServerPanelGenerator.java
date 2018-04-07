package ser516.project3.server.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import ser516.project3.model.ConsoleModel;
import ser516.project3.model.TimerModel;
import ser516.project3.server.controller.ServerControllerImpl;
import ser516.project3.server.controller.TimerController;
import ser516.project3.utilities.InputVerifierNumericals;
import ser516.project3.utilities.ServerCommonData;

/**
 * Class to create components in expressions panel and listeners for each
 * component
 * 
 * @author Varun, Janani, Sangeetha, Ganesh
 *
 */

public class ServerPanelGenerator {
	
	static JPanel topPanel;

	final static Logger logger = Logger.getLogger(ServerPanelGenerator.class);

	private static ServerControllerImpl serverControllerImpl = new ServerControllerImpl();
	private static TimerController timerController;

	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
	private static final String INTERVAL_LABEL_NAME = "Interval (seconds):  ";
	private static final String AUTO_REPEAT_CHECKBOX_NAME = "Auto Repeat";
	private static final String TOGGLE_START = "Start Server";
    private static final String TOGGLE_STOP = "Stop Server";
	private static final String SEND_BUTTON = "Send";
    private static final String START = "Start";
    private static final String STOP = "Stop";

	private static StatusIndicator statusIndicator = new StatusIndicator();

	/**
	 * This method will initialize the top JPanels of the server application
	 * 
	 * @return the top JPanel
	 * @wbp.parser.entryPoint
	 */
	public static JPanel createTopPanels() {
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraint = new GridBagConstraints();

		topPanel.setOpaque(false);

		Border titledBorder = new TitledBorder(null, "Graph", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
		Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 10, 10);

		Border compoundBorder = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
		topPanel.setBorder(compoundBorder);

        JCheckBox autoRepeatCheckBox= new JCheckBox(AUTO_REPEAT_CHECKBOX_NAME, false);;

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

		JButton sendButton = new JButton(SEND_BUTTON);
		sendButton.setHorizontalAlignment(SwingConstants.CENTER);
		sendButton.setEnabled(false);
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Send button pressed");
				updateIntervalInputTextField(intervalInputTextField);
				serverControllerImpl.sendValues();
				if (ServerCommonData.getInstance().isAutoRepeat()) {
					if (intervalInputTextField.isEditable()) {
						intervalInputTextField.setEditable(false);
					} else {
						intervalInputTextField.setEditable(true);
					}
					if (autoRepeatCheckBox.isEnabled()) {
						autoRepeatCheckBox.setEnabled(false);
					} else {
						autoRepeatCheckBox.setEnabled(true);
					}
					if (ServerCommonData.getInstance().isShouldSend()) {
					    sendButton.setText(STOP);
                    } else {
					    sendButton.setText(START);
                    }
				}

			}
		});

        autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        autoRepeatCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("Value of auto Repeat toggle changed: " + autoRepeatCheckBox.isSelected());
                ServerCommonData.getInstance().setAutoRepeat(autoRepeatCheckBox.isSelected());
                if (autoRepeatCheckBox.isSelected()) {
                    sendButton.setText(START);
                } else {
                    sendButton.setText(SEND_BUTTON);
                }
            }

        });

		JButton buttonToggle = new JButton(TOGGLE_START);
		buttonToggle.setHorizontalAlignment(SwingConstants.CENTER);
		buttonToggle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("Start/Stop button pressed");
				updateIntervalInputTextField(intervalInputTextField);
				serverControllerImpl.startServer();
				
				if(sendButton.isEnabled()) {
					sendButton.setEnabled(false);
				}else {
					sendButton.setEnabled(true);
				}
					
			}
		});


		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 40;
		gridBagConstraint.insets = new Insets(0, 20, 0, 0);
		topPanel.add(intervalLabel, gridBagConstraint);

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 0.5;
		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 20;	
		gridBagConstraint.insets = new Insets(0, 20, 0, 20);
		topPanel.add(intervalInputTextField, gridBagConstraint);
		
		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 0;
		gridBagConstraint.ipady = 40;
		topPanel.add(autoRepeatCheckBox, gridBagConstraint);

		
/*
		gridBagConstraint.insets = new Insets(0, 0, 0, 0);
		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 0.5;
		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;	
		//gridBagConstraint.ipady = 40;
		topPanel.add(Box.createGlue(), gridBagConstraint);
	*/
		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weighty = 2.0;
		gridBagConstraint.gridx = 0;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.ipady = 20;
		gridBagConstraint.insets = new Insets(0, 30, 0, 30);
		topPanel.add(buttonToggle, gridBagConstraint);

		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weighty = 2.0;
		gridBagConstraint.gridx = 1;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.ipady = 20;
		gridBagConstraint.insets = new Insets(0, 30, 0, 30);
		topPanel.add(sendButton, gridBagConstraint);
		
		
		statusIndicator.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		statusIndicator.setBounds(100, 200, 50, 80);
		gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraint.weightx = 1;
		gridBagConstraint.gridx = 2;
		gridBagConstraint.gridy = 1;
		gridBagConstraint.ipady = 10;
		gridBagConstraint.insets = new Insets(0, 0, 0, 0);
		
		topPanel.add(statusIndicator,gridBagConstraint);


		return topPanel;

	}
	
	public static JPanel gettopPanel()
	{
		return topPanel;
		
	}

	/**
	 * This method will initialize the second sub panel of the Server window
	 * 
	 * @return the second sub-panel
	 */
	public static Component createConfigurationPanels() {
		JPanel configPanel = new JPanel();
		JPanel timerPanel = createTimerPanel();
		JPanel emotionsPanel = createEmotionsPanel();
		JPanel expressionPanel = createExpressionPanel();
		JPanel consolePanel = createConsolePanel();

		JSplitPane splitTimerPanel = new JSplitPane();
		JSplitPane splitEmotionsPanel = new JSplitPane();
		JSplitPane splitExpressionPanel = new JSplitPane();

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

		splitExpressionPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitExpressionPanel.setDividerLocation(150);
		splitExpressionPanel.setTopComponent(expressionPanel);
		splitExpressionPanel.setBottomComponent(consolePanel);
		splitExpressionPanel.setDividerSize(0);
		splitExpressionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		splitEmotionsPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitEmotionsPanel.setDividerLocation(150);
		splitEmotionsPanel.setTopComponent(emotionsPanel);
		splitEmotionsPanel.setBottomComponent(splitExpressionPanel);
		splitEmotionsPanel.setDividerSize(0);
		splitEmotionsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		splitTimerPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitTimerPanel.setDividerLocation(50);
		splitTimerPanel.setTopComponent(timerPanel);
		splitTimerPanel.setBottomComponent(splitEmotionsPanel);
		splitTimerPanel.setDividerSize(0);
		splitTimerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

		configPanel.add(splitTimerPanel);
		return configPanel;
	}

	public static JPanel createExpressionPanel() {
		ExpressionsView expressionsView = new ExpressionsView();
		return expressionsView.getExpressionsPanel();
	}

	public static JPanel createEmotionsPanel() {
		EmotionsView emotionsView = new EmotionsView();
		return emotionsView.getEmotionsPanel();
	}

	public static JPanel createConsolePanel() {
		ConsoleView consoleView = new ConsoleView();
		ConsoleModel.getInstance().addObserver(consoleView);
		return consoleView.getConsolePanel();
	}

	public static JPanel createTimerPanel() {
		//Temporary. Will implement MVC and factory pattern.
		TimerModel timerModel = new TimerModel();
		TimerView timerView = new TimerView(timerModel);
		timerController = new TimerController(timerModel, timerView);
		return timerView.getTimerPanel();
	}

	private static void updateIntervalInputTextField(JTextField intervalInputTextField) {
		try {
			ServerCommonData.getInstance().getMessage().setInterval(Integer.parseInt(intervalInputTextField.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
		}
	}
	
	public static void setStatus(boolean status) {
		statusIndicator.setBlinking(status);
	}

	/**
	 * @return the serverControllerImpl
	 */
	public static ServerControllerImpl getServerControllerImpl() {
		return serverControllerImpl;
	}

	//Temporary. Will implement MVC and factory pattern.
	public static TimerController getTimerController() {
		return timerController;
	}
}
