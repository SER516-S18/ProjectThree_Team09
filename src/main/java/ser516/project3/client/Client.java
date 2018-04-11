package ser516.project3.client;

import java.awt.*;

import javax.swing.UIManager;

import ser516.project3.client.controller.ClientController;
import ser516.project3.client.controller.ControllerFactory;
import ser516.project3.constants.ClientConstants;

/**
 * Main class to initialize the client
 * 
 * @author User
 *
 */
public class Client {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				boolean seaGlassFound = false;
				try {
					if (System.getProperty("os.name").substring(0, 7).equals("Windows")) {
						UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
					}
					seaGlassFound = true;
				} catch (Exception e) {
					System.out.println("Seaglass Look and Feel UI not found");
				}
				if (!seaGlassFound) {
					try {
						for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
							System.out.println(info.getName());
							if ("Nimbus".equals(info.getName())) {
								UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (Exception e) {
						System.out.println("Look and Feel UI not found");
					}
				}
				ControllerFactory controllerFactory = ControllerFactory.getInstance();
				ClientController clientController = (ClientController) controllerFactory
						.getController(ClientConstants.CLIENT, null, null, null);
				clientController.initializeView();
			}
		});
	}

}
