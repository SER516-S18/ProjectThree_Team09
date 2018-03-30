package ser516.project3.client.service;

public interface ClientConnectionServiceInterface {
	
	/**
	 * This method will create a connection to the server's web socket end point, read and decode the json into Message bean
	 * 
	 * @param ipAddress
	 * @param port
	 * @param endpoint
	 */
	void createClientConnection(final String ipAddress, final int port, final String endpoint );

}
