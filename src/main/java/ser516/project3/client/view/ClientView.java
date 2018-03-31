package ser516.project3.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class ClientView extends JFrame{
	
	private static ClientView clientViewInstance=null;
	
	private static JSplitPane splitPane;
	private static PerformanceMetricView performanceMetricTabInstance;
	private static ExpressionsView expressionsTabInstance;
	private static JTabbedPane expressionsEmotionsCombinedTab;
	private static HeaderView headerPanel;
	
	public static ClientView getClientView() {
		if(clientViewInstance ==null) {
			clientViewInstance=new ClientView();
		}
		return clientViewInstance;
	}

	/**
	 *
	 */
	public void  initializeClientUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));

		headerPanel = new HeaderView();
		expressionsEmotionsCombinedTab = new JTabbedPane();

		performanceMetricTabInstance = new PerformanceMetricView();
		expressionsTabInstance = new ExpressionsView();
		expressionsEmotionsCombinedTab.addTab("Performance Metric", performanceMetricTabInstance);
		expressionsEmotionsCombinedTab.addTab("Expressions", expressionsTabInstance);

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  
        splitPane.setDividerLocation(100);                    
        splitPane.setTopComponent(headerPanel);
        splitPane.setBottomComponent(expressionsEmotionsCombinedTab);
		
		add(splitPane);
		setVisible(true);
	}
}
