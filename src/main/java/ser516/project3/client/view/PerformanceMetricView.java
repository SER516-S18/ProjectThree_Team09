package ser516.project3.client.view;

import ser516.project3.constants.ClientConstants;
import ser516.project3.model.PerformanceMetricModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/*This class contains performance metrics view
 * where emotion button is displayed on the right
 * and graph is displayed on the left.
 * 
 * @author Mohan Vasantrao Yadav, Adhiraj Tikku
 */
public class PerformanceMetricView extends JPanel{
	private PerformanceMetricModel performanceMetricModel;

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
		add(graphView, BorderLayout.LINE_START );
		add(getEmotionPanel(), BorderLayout.LINE_END );
		setVisible(true);
	}
	
	/* This method returns a panel of 6 buttons,
	 * 2 labels and 1 text field.
	 */
	private Component getEmotionPanel() {
		JPanel mainPanel;
		JTextField displayLengthField;
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
		mainPanel.add(getEmotionButton(ClientConstants.INTEREST, performanceMetricModel.getInterestColor()), gridBagConstraints);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		mainPanel.add(getEmotionButton(ClientConstants.ENGAGEMENT, performanceMetricModel.getEngagementColor()), gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		mainPanel.add(getEmotionButton(ClientConstants.STRESS, performanceMetricModel.getStressColor()), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		mainPanel.add(getEmotionButton(ClientConstants.RELAXATION, performanceMetricModel.getRelaxationColor()), gridBagConstraints);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		mainPanel.add(getEmotionButton(ClientConstants.EXCITEMENT, performanceMetricModel.getExcitementColor()), gridBagConstraints);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		mainPanel.add(getEmotionButton(ClientConstants.FOCUS, performanceMetricModel.getFocusColor()), gridBagConstraints);

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
		displayLengthField = new JTextField();
		displayLengthField.setBackground(LIGHTPINK);
		displayLengthField.setHorizontalAlignment(SwingConstants.CENTER);
		displayLengthField.setFont(FONT);
		displayLengthField.setBorder(new LineBorder(BLACK));
		mainPanel.add(displayLengthField, gridBagConstraints);
		displayLengthField.setColumns(10);

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
}
