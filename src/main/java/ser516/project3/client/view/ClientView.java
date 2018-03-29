package ser516.project3.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class ClientView extends JFrame{
	
	private static ClientView clientViewInstance=null;
	
	JSplitPane splitPane;
	PerformanceMetricTab performanceMetricTabInstance;
	ExpressionsTab expressionTabInstance;
	JTabbedPane expressionsEmotionsCombinedTab;
	//to do : replace with header panel displaying connection info etc.
	JPanel toBeReplacedWithHeaderPanel;
	
	public static ClientView getClientView() {
		if(clientViewInstance ==null) {
			clientViewInstance=new ClientView();
		}
		return clientViewInstance;
	} 
	
	
	public void  initializeClientUI() {
		toBeReplacedWithHeaderPanel=new JPanel();
		splitPane = new JSplitPane();

		expressionsEmotionsCombinedTab=new JTabbedPane();
		performanceMetricTabInstance=new PerformanceMetricTab();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800, 600));
		
		expressionTabInstance=new ExpressionsTab();
		
		expressionsEmotionsCombinedTab.addTab("Performance Metric", performanceMetricTabInstance);
		expressionsEmotionsCombinedTab.addTab("Expressions", expressionTabInstance);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  
        splitPane.setDividerLocation(100);                    
        splitPane.setTopComponent(toBeReplacedWithHeaderPanel);                  
        splitPane.setBottomComponent(expressionsEmotionsCombinedTab);
		
		this.add(splitPane);
		this.setVisible(true);
		
	}

}
