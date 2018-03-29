package ser516.project3.server.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class ServerView extends JFrame{
	
	public ServerView(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server");
		setMinimumSize(new Dimension(500, 800));
//		setLayout(new GridLayout(0, 1));
		setLayout(new BorderLayout());
		GridBagConstraints c = new GridBagConstraints();
//		setBackground(BLUE);
		//TODO: Add panel rows vertically
		setVisible(true);
		add(ServerPanelGenerator.createTopPanels(), BorderLayout.PAGE_START);
		add(ServerPanelGenerator.createConfigurationPanels(), BorderLayout.CENTER);
		setVisible(true);
	}
	
}