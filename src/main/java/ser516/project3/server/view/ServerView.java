package ser516.project3.server.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * The JFrame class of Server application
 * @author User
 *
 */
@SuppressWarnings("serial")
public class ServerView extends JFrame{
	
	/**
	 * Constructor to initialize all the components of the server application
	 */
	public ServerView(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server");
		setMinimumSize(new Dimension(500, 800));
		setLayout(new BorderLayout());
		setVisible(true);
		add(ServerPanelGenerator.createTopPanels(), BorderLayout.PAGE_START);
		add(ServerPanelGenerator.createConfigurationPanels(), BorderLayout.CENTER);
		setVisible(true);
	}
	
}
