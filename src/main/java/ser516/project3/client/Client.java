package ser516.project3.client;

import ser516.project3.client.controller.ClientController;
import ser516.project3.client.controller.ClientControllerFactory;
import ser516.project3.constants.ClientConstants;

import javax.swing.*;
import java.awt.*;

/**
 * Main class to initialize the client
 *
 * @author Adhiraj Tikku, Manish Tandon
 */
public class Client {
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Client.class);

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

                    if (!seaGlassFound) {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                            System.out.println(info.getName());
                            if ("Nimbus".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        }

                    }

                } catch (Exception e) {
                    logger.error(ClientConstants.CLIENT_START_ERROR + e.getMessage());

                } finally {
                    ClientControllerFactory controllerFactory = ClientControllerFactory.getInstance();
                    ClientController clientController = (ClientController) controllerFactory
                            .getController(ClientConstants.CLIENT, null, null, null);
                    clientController.initializeView();
                }
            }
        });
    }

}
