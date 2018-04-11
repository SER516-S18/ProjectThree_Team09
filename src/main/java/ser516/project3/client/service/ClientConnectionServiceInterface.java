package ser516.project3.client.service;

/**
 * Interface to define the methods to be implemented by classes whichever wants to connect to the server.
 *
 * @author Adhiraj Tikku
 */
public interface ClientConnectionServiceInterface {

	/**
	 * This method will create a connection to the server's web socket end point,
	 * read and decode the json into MessageModel bean
	 * 
	 * @param ipAddress
	 * @param port
	 * @param endpoint
	 */
	void createClientConnection(final String ipAddress, final int port, final String endpoint);
	
	/**
	 * Stops the connection to the server
	 */
	void stopClientConnection();

}
