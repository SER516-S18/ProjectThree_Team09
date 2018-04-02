package ser516.project3.client.view;

import ser516.project3.client.controller.HeaderController;
import ser516.project3.model.HeaderModel;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ClientView extends JFrame {

	private static ClientView clientViewInstance = null;

	private static JSplitPane splitPane;
	private static PerformanceMetricView performanceMetricTabInstance;
	private static ExpressionsView expressionsTabInstance;
	private static JTabbedPane expressionsEmotionsCombinedTab;
	private static HeaderView headerPanel;

	public static ClientView getClientView() {
		if (clientViewInstance == null) {
			clientViewInstance = new ClientView();
		}
		return clientViewInstance;
	}

	/**
	 *
	 */
	public void initializeClientUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1400, 650));

		headerPanel = new HeaderView();
		HeaderModel headerModel = new HeaderModel(); // Temporary. Will move to client controller.
		HeaderController headerController = new HeaderController(headerModel, headerPanel); // Temporary. Will move to client controller.

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
