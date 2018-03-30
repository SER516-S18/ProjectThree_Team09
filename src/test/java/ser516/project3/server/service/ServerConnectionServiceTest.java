package ser516.project3.server.service;

import org.junit.jupiter.api.Test;

import ser516.project3.server.service.ServerConnectionServiceImpl;
import ser516.project3.server.service.ServerConnectionServiceInterface;

class ServerConnectionServiceTest {

	@Test
	void testCreateServerSocketThread() {
		ServerConnectionServiceInterface serverConnectionServiceInterface = new ServerConnectionServiceImpl();
		serverConnectionServiceInterface.initServerEndpoint();
	}

}
