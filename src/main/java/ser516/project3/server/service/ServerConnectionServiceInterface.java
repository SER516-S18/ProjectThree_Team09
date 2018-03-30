package ser516.project3.server.service;

public interface ServerConnectionServiceInterface {
	
	/**
	 * Initializes the socket end point
	 */
	void initServerEndpoint();
	
	/**
	 * Stops the web socket endpoint
	 */
	void stopServerEndpoint();

}
