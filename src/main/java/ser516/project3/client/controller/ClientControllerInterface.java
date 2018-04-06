package ser516.project3.client.controller;

public interface ClientControllerInterface {
	/**
	 * Method to connect to a server end point
	 * @param ipAddress
	 * @param port
	 */
	void toggleConnectionToServer(final String ipAddress, final int port);
	
	/**
	 * Forces the client to stop
	 */
	void stopClientConnector();

	/**
	 * Creates the Client View
	 */
	void initializeClientView();
}
