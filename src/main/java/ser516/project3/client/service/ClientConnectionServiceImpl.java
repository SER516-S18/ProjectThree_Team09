package ser516.project3.client.service;

public class ClientConnectionServiceImpl implements ClientConnectionServiceInterface {
	
	private static final int PORT = 1516;
	
	@Override
	public void createClientConnection() {
		ClientSocketThread clientSocketThread = new ClientSocketThread("localhost", PORT);
		new Thread(clientSocketThread).start();
	}
	
	/**
	 * Just for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientConnectionServiceImpl().createClientConnection();
	}

}
