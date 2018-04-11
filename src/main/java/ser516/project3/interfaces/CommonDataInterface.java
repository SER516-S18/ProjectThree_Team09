package ser516.project3.interfaces;

/**
 * Handles common functionalities across different modules
 *
 * @author Adhiraj Tikku
 */

public interface CommonDataInterface {
    /**
     * Sets the status whether connection between client and server is established.
     *
     * @param status Connection Status
     */
    void setConnectionStatus(boolean status);

    /**
     * Sets the current selected tab.
     *
     * @param tabSelected Current selected tab.
     */
    void setTabSelected(boolean tabSelected);
}
