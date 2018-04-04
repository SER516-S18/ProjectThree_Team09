package ser516.project3.client;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.ClientControllerInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Main class to initialize the client
 * @author User
 *
 */
public class Client 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                boolean seaGlassFound = false;
                try {
                    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                    seaGlassFound = true;
                } catch (Exception e) {
                    System.out.println("Seaglass Look and Feel UI not found");
                }
                if(!seaGlassFound)
                {
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
                ClientControllerInterface clientController = ClientControllerImpl.getInstance();
                clientController.initializeClientView();
            }
        } );
    }
    
}
