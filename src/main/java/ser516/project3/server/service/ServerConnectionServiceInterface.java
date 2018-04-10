package ser516.project3.server.service;

/**
 * The interface ServerConnectionServiceInterface provides two methods to create
 * and stop the server's web-socket end-point
 * 
 * @author vsriva12
 *
 */
public interface ServerConnectionServiceInterface {

	/**
	 * Initializes the server socket end-point
	 */
	void initServerEndpoint();

	/**
	 * Stops the server web-socket end-point
	 */
	void stopServerEndpoint();

}
