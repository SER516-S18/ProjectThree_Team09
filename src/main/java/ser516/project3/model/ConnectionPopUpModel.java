package ser516.project3.model;

public class ConnectionPopUpModel {
  private String ipAddress;
  private int portNumber;

  public ConnectionPopUpModel() {
    ipAddress = "localhost";
    portNumber = 1516;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public int getPortNumber() {
    return portNumber;
  }

  public void setPortNumber(int portNumber) {
    this.portNumber = portNumber;
  }
}
