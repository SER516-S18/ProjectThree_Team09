package ser516.project3.client.view;

import ser516.project3.constants.ClientConstants;
import ser516.project3.model.PerformanceMetricModel;
import ser516.project3.utilities.NumberTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/*This class contains performance metrics view
 * where emotion button is displayed on the right
 * and graph is displayed on the left.
 * 
 * @author Mohan Vasantrao Yadav, Adhiraj Tikku
 */
public class PerformanceMetricView extends JPanel{
	private PerformanceMetricModel performanceMetricModel;

	private NumberTextField displayLengthField;

	private JButton interestButton;
	private JButton engagementButton;
	private JButton stressButton;
	private JButton relaxationButton;
	private JButton excitementButton;
	private JButton focusButton;

	private static final Color LIGHTGREY = new Color(245, 245, 245);
	private static final Color BLACK = new Color(0, 0, 0);
	private static final Color LIGHTPINK = new Color(255, 228, 225);
	private static final Font FONT = new Font("Courier New", Font.BOLD, 16);
	
	
	public PerformanceMetricView(PerformanceMetricModel performanceMetricModel){
		this.performanceMetricModel = performanceMetricModel;
		setLayout(new GridLayout(1, 2, 8, 8 ));
		setBackground(LIGHTGREY);
	}

	public void initializePerformanceMetricUI(GraphView graphView) {
		graphView.setLayout(new GridLayout(1, 1, 8, 8));
		graphView.setOpaque(false);
		graphView.setBorder(new TitledBorder(null, "Graph",
				TitledBorder.LEADING, TitledBorder.TOP, FONT, null));
		add(graphView, BorderLayout.LINE_START );
		add(getEmotionPanel(), BorderLayout.LINE_END );
		setVisible(true);
	}
	
	/* This method returns a panel of 6 buttons,
	 * 2 labels and 1 text field.
	 */
	private Component getEmotionPanel() {
		JPanel mainPanel;
		JLabel displaylengthLabel;
		JLabel secondsLabel;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(new TitledBorder(null, ClientConstants.EMOTIONS, TitledBorder.LEADING,
				TitledBorder.TOP, FONT, null));

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 50;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		interestButton = getEmotionButton(ClientConstants.INTEREST, performanceMetricModel.getInterestColor());
		mainPanel.add(interestButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		engagementButton = getEmotionButton(ClientConstants.ENGAGEMENT, performanceMetricModel.getEngagementColor());
		mainPanel.add(engagementButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		stressButton = getEmotionButton(ClientConstants.STRESS, performanceMetricModel.getStressColor());
		mainPanel.add(stressButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		relaxationButton = getEmotionButton(ClientConstants.RELAXATION, performanceMetricModel.getRelaxationColor());
		mainPanel.add(relaxationButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		excitementButton = getEmotionButton(ClientConstants.EXCITEMENT, performanceMetricModel.getExcitementColor());
		mainPanel.add(excitementButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		focusButton = getEmotionButton(ClientConstants.FOCUS, performanceMetricModel.getFocusColor());
		mainPanel.add(focusButton, gridBagConstraints);

		gridBagConstraints.insets = new Insets(10, 5, 10, 5);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		displaylengthLabel = new JLabel(ClientConstants.DISPLAYLENGTH);
		displaylengthLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		displaylengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displaylengthLabel.setFont(FONT);
		mainPanel.add(displaylengthLabel, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		displayLengthField = new NumberTextField("" + performanceMetricModel.getDisplayLength());
		displayLengthField.setBackground(LIGHTPINK);
		displayLengthField.setHorizontalAlignment(SwingConstants.CENTER);
		displayLengthField.setFont(FONT);
		displayLengthField.setBorder(new LineBorder(BLACK));
		displayLengthField.setColumns(10);
		mainPanel.add(displayLengthField, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		secondsLabel = new JLabel(ClientConstants.SECONDS);
		secondsLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		secondsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		secondsLabel.setFont(FONT);
		mainPanel.add(secondsLabel, gridBagConstraints);

		return mainPanel;
	}
	
	/**
	 * 
	 * This method adds Emotion buttons into the panel where dimensions,color
	 * and emotion name is passed as arguments
	 * 
	 *
	 */
	private JButton getEmotionButton(String emotion, Color color)
	{
		JButton emotionButton = new JButton(emotion);
		emotionButton.setBackground(color);
		emotionButton.setOpaque(true);
		emotionButton.setHorizontalTextPosition(SwingConstants.CENTER);
		emotionButton.setBorder(new LineBorder(BLACK));
		emotionButton.setHorizontalAlignment(SwingConstants.CENTER);
		emotionButton.setFont(FONT);
		return emotionButton;
	}

	public void addEmotionButtonsListener(ActionListener actionListener) {
		interestButton.addActionListener(actionListener);
		engagementButton.addActionListener(actionListener);
		stressButton.addActionListener(actionListener);
		relaxationButton.addActionListener(actionListener);
		excitementButton.addActionListener(actionListener);
		focusButton.addActionListener(actionListener);
	}

	public void updatePerformanceMetricView(PerformanceMetricModel performanceMetricModel) {
		this.performanceMetricModel = performanceMetricModel;
		interestButton.setBackground(this.performanceMetricModel.getInterestColor());
		engagementButton.setBackground(this.performanceMetricModel.getEngagementColor());
		stressButton.setBackground(this.performanceMetricModel.getStressColor());
		relaxationButton.setBackground(this.performanceMetricModel.getRelaxationColor());
		excitementButton.setBackground(this.performanceMetricModel.getExcitementColor());
		focusButton.setBackground(this.performanceMetricModel.getFocusColor());
	}
}
