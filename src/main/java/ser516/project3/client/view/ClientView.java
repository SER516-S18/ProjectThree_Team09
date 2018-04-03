package ser516.project3.client.view;

import ser516.project3.constants.ClientConstants;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class ClientView extends JFrame {

	private static ClientView clientViewInstance = null;

	private static JSplitPane splitPane;
	private static JTabbedPane expressionsEmotionsCombinedTab;
	private JMenu optionsMenu;
	private JMenuItem serverMenuItem;
	private JMenuBar menuBar;


	public static ClientView getClientView() {
		if (clientViewInstance == null) {
			clientViewInstance = new ClientView();
		}
		return clientViewInstance;
	}

	/**
	 *
	 */
	public void initializeClientUI(HeaderView headerView, PerformanceMetricView performanceMetricView, ExpressionsView expressionsView) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1400, 650));
		
		menuBar = new JMenuBar();
		optionsMenu = new JMenu(ClientConstants.OPTIONS);
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		serverMenuItem = new JMenuItem(ClientConstants.OPEN_SERVER);
		serverMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		optionsMenu.add(serverMenuItem);
		menuBar.add(optionsMenu);

		expressionsEmotionsCombinedTab = new JTabbedPane();

		expressionsEmotionsCombinedTab.addTab(ClientConstants.PERFORMANCE_METRICS, performanceMetricView);
		expressionsEmotionsCombinedTab.addTab(ClientConstants.EXPRESSIONS, expressionsView);

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(100);
		splitPane.setTopComponent(headerView);
		splitPane.setBottomComponent(expressionsEmotionsCombinedTab);

		add(splitPane);
		setJMenuBar(menuBar);
		setVisible(true);
	}

	public void addServerMenuItemListener(ActionListener actionListener) {
		serverMenuItem.addActionListener(actionListener);
	}
}
