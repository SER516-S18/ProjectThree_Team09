package ser516.project3.client.service;

import org.junit.jupiter.api.Test;

class ClientConnectionServiceTest {

	@Test
	void testCreateClientConnection() {
		ClientConnectionServiceInterface clientConnectionServiceInterface = new ClientConnectionServiceImpl();
		clientConnectionServiceInterface.createClientConnection("localhost", 1516, "server");
	}

}
