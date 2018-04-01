/**
 * 
 */
package ser516.project3.server.controller;

import ser516.project3.server.service.ServerConnectionServiceImpl;
import ser516.project3.server.service.ServerConnectionServiceInterface;
import ser516.project3.utilities.ServerCommonData;

/**
 * @author User
 *
 */
public class ServerControllerImpl implements ServerControllerInterface {
	
	private ServerConnectionServiceInterface serverConnectionService;
	
	public ServerControllerImpl() {
		serverConnectionService = new ServerConnectionServiceImpl();
	}

	@Override
	public void startServer() {
		if(ServerCommonData.getInstance().isServerStarted()) {
			serverConnectionService.stopServerEndpoint();
		} else {
			serverConnectionService.initServerEndpoint();
		}
	}

	@Override
	public void stopServer() {
		serverConnectionService.stopServerEndpoint();
	}

}
