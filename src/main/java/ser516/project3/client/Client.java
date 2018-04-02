package ser516.project3.client;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.ClientControllerInterface;

/**
 * Main class to initialize the client
 * @author User
 *
 */
public class Client 
{
    public static void main(String[] args)
    {
        ClientControllerInterface clientController = ClientControllerImpl.getInstance();
        clientController.initializeClientView();
    }
    
}
