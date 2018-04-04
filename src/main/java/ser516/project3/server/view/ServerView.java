package ser516.project3.server.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

/**
 * The JFrame class of Server application
 * 
 * @author User
 *
 */
@SuppressWarnings("serial")
public class ServerView extends JDialog {
	final static Logger logger = Logger.getLogger(ServerView.class);

	/**
	 * Constructor to initialize all the components of the server application
	 */
	public ServerView() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Server");
		setMinimumSize(new Dimension(500, 800));
		setLayout(new BorderLayout());
		setVisible(true);
		add(ServerPanelGenerator.createTopPanels(), BorderLayout.PAGE_START);
		add(ServerPanelGenerator.createConfigurationPanels(), BorderLayout.CENTER);
		setVisible(true);

		ServerView.this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ServerPanelGenerator.getServerControllerImpl().stopServer();
				logger.info("server window closed");
			}
		});
	}


}
