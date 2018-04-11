package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Model for creating theconnection pop up view
 *
 * @author vishakhasingal
 *
 */
public class ConnectionPopUpModel implements ModelInterface{
  private String ipAddress;
  private int portNumber;

    /**
     * Constructor to create the connection to the server using initial values
     */
  public ConnectionPopUpModel() {
    ipAddress = "localhost";
    portNumber = 1516;
  }

    /**
     * Returns the IP Address configured at the client
     * @return IP Address string
     */
  public String getIpAddress() {
    return ipAddress;
  }

    /**
     * updates the IP Address in the model from the view
     *
     * @param ipAddress the ip address to be updated
     */
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

    /**
     * Returns the port number currently at the client side
     *
     * @return Port number
     */
  public int getPortNumber() {
    return portNumber;
  }

    /**
     * Updates the port number in the model from the view
     *
     * @param portNumber the port number to be updated
     */
  public void setPortNumber(int portNumber) {
    this.portNumber = portNumber;
  }
}
