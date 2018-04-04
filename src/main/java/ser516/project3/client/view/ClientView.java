package ser516.project3.client.view;

import ser516.project3.constants.ClientConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ClientView extends JFrame {

	private static ClientView clientViewInstance = null;

	private JMenuBar menuBar;
	private JMenu optionsMenu;
	private JMenuItem serverMenuItem;
	private JTabbedPane expressionsEmotionsCombinedTab;

	private HeaderView headerView;
	private PerformanceMetricView performanceMetricView;
	private ExpressionsView expressionsView;

	private final static int FONT_SIZE = 15;
	private final static int FRAME_WIDTH = 1400;
	private final static int FRAME_HEIGHT = 700;

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
		this.headerView = headerView;
		this.performanceMetricView = performanceMetricView;
		this.expressionsView = expressionsView;
		
		createMenuBar();
		createTabs();
		createLayout();
		setJMenuBar(menuBar);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setVisible(true);
	}

	private void createMenuBar() {
		menuBar = new JMenuBar();
		optionsMenu = new JMenu(ClientConstants.OPTIONS);
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		serverMenuItem = new JMenuItem(ClientConstants.OPEN_SERVER);
		serverMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		optionsMenu.add(serverMenuItem);
		menuBar.add(optionsMenu);
	}

	private void createTabs() {
		expressionsEmotionsCombinedTab = new JTabbedPane();
		expressionsEmotionsCombinedTab.addTab(ClientConstants.PERFORMANCE_METRICS, performanceMetricView);
		expressionsEmotionsCombinedTab.addTab(ClientConstants.EXPRESSIONS, expressionsView);
		expressionsEmotionsCombinedTab.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
	}

	private void createLayout() {
		setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.decode(ClientConstants.FRAME_COLOR_HEX));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(15, 10, 10, 10);
		add(headerView, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.insets = new Insets(10, 10, 15, 10);
		add(expressionsEmotionsCombinedTab, gridBagConstraints);
	}

	public void addServerMenuItemListener(ActionListener actionListener) {
		serverMenuItem.addActionListener(actionListener);
	}
}
