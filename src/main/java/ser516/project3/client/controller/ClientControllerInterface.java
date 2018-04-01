package ser516.project3.client.controller;

public interface ClientControllerInterface {
	
	/**
	 * Method to handle the start event of client application
	 * 
	 */
	void startClient();
	
	/**
	 * Method to connect to a server end point
	 * @param ipAddress
	 * @param port
	 */
	void toggleConnectionToServer(final String ipAddress, final int port);
	
}
