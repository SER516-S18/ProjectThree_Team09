package ser516.project3.client.view;

import ser516.project3.client.controller.GraphControllerImpl;
import ser516.project3.client.controller.GraphControllerInterface;
import ser516.project3.model.GraphModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/*This class contains performance metrics view
 * where emotion button is displayed on the right
 * and graph is displayed on the left.
 * 
 * @author Mohan Vasantrao Yadav 
 */

public class PerformanceMetricView extends JPanel{
	private static final Color LIGHTGREY = new Color(245, 245, 245);
	private static final Color BLACK = new Color(0, 0, 0);
	private static final Color LIGHTPINK = new Color(255, 228, 225);
	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
	
	
	public PerformanceMetricView(){
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
		mainPanel.setBackground(LIGHTGREY);
		mainPanel.setBorder(new LineBorder(LIGHTGREY));
		mainPanel.setBounds(10, 56, 758, 379);
		mainPanel.setLayout(null);

		mainPanel.add(getEmotionButton("<html>Interest</html>",new Color(240, 248, 255),62, 34, 131, 68));
		mainPanel.add(getEmotionButton("<html>Relaxation</html>",new Color(255, 228, 225),62, 119, 131, 68));
		mainPanel.add(getEmotionButton("<html>Engagement</html>",new Color(138,43,226),198, 34, 131, 68));
		mainPanel.add(getEmotionButton("<html>Focus</html>",new Color(255, 228, 225),198, 119, 131, 68));
		mainPanel.add(getEmotionButton("<html>Stress</html>",new Color(240, 248, 255),334, 34, 131, 68));
		mainPanel.add(getEmotionButton("<html>Excitement</html>",new Color(138,43,226),334, 119, 131, 68));
		
		displaylengthLabel = new JLabel("<html>Display <br>Length</html>");
		displaylengthLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		displaylengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displaylengthLabel.setFont(FONT);
		displaylengthLabel.setBounds(62, 204, 131, 68);
		mainPanel.add(displaylengthLabel);
		
		secondsLabel = new JLabel("<html>Seconds</html>");
		secondsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		secondsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondsLabel.setFont(FONT);
		secondsLabel.setBounds(334, 204, 131, 68);
		mainPanel.add(secondsLabel);
		
		displayLengthField = new JTextField();
		displayLengthField.setBackground(LIGHTPINK);
		displayLengthField.setHorizontalAlignment(SwingConstants.CENTER);
		displayLengthField.setFont(FONT);
		displayLengthField.setBorder(new LineBorder(BLACK));
		displayLengthField.setBounds(198, 204, 131, 68);
		mainPanel.add(displayLengthField);
		displayLengthField.setColumns(10);

		return mainPanel;
	}
	
	/**
	 * 
	 * This method adds Emotion buttons into the panel where dimensions,color
	 * and emotion name is passed as arguments
	 * 
	 *
	 */
	private JButton getEmotionButton(String emotion, Color color, int x, int y, int width, int height)
	{
		JButton emotionButton = new JButton(emotion);
		emotionButton.setBackground(color);
		emotionButton.setOpaque(true);
		emotionButton.setHorizontalTextPosition(SwingConstants.CENTER);
		emotionButton.setBorder(new LineBorder(BLACK));
		emotionButton.setHorizontalAlignment(SwingConstants.CENTER);
		emotionButton.setFont(FONT);
		emotionButton.setBounds(x,y,width,height);
		return emotionButton;
	}
}
