package ser516.project3.server.view;

import org.apache.log4j.Logger;
import ser516.project3.interfaces.ViewInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The JFrame class of Server application
 * 
 * @author User
 *
 */
@SuppressWarnings("serial")
public class ServerView extends JFrame implements ViewInterface {
	private static ServerView serverViewInstance = null;

	private TopView topView;
	private TimerView timerView;
	private EmotionsView emotionsView;
	private ExpressionsView expressionsView;
	private ConsoleView consoleView;

	private static final Font FONT = new Font("Courier New", Font.BOLD, 17);

	/** 
     * Method to return the ServerView instance
	 * 
	 */
	public static ServerView getServerView() {
		if (serverViewInstance == null) {
			serverViewInstance = new ServerView();
		}
		return serverViewInstance;
	}
	
	/** 
     * Method to initialize the expressions view panel
	 * @param subViews object of type ViewInterface
	 * 
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {
		topView = (TopView) subViews[0];
		timerView = (TimerView) subViews[1];
		emotionsView = (EmotionsView) subViews[2];
		expressionsView = (ExpressionsView) subViews[3];
		consoleView = (ConsoleView) subViews[4];

		setLayout(new BorderLayout());
		add(topView, BorderLayout.PAGE_START);
		add(createConfigurationPanels(), BorderLayout.CENTER);

		setMinimumSize(new Dimension(500, 800));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Server");
		setVisible(true);
	}

	/**
	 * This method will initialize the second sub panel of the Server window
	 *
	 * @return the second sub-panel
	 */
	private Component createConfigurationPanels() {
		JPanel configPanel = new JPanel();
		JPanel timerPanel = timerView;
		JPanel emotionsPanel = emotionsView;
		JPanel expressionPanel = expressionsView;
		JPanel consolePanel = consoleView;

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

	/** 
     * Method to WindowListener to the Server window
	 * @param windowAdapter WindowAdapter object
	 * 
	 */
	public void addServerWindowListener(WindowAdapter windowAdapter) {
		addWindowListener(windowAdapter);
	}
}
