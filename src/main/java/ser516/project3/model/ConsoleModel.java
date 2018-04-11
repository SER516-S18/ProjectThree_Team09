package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

import java.util.ArrayList;

/**
 * It stores the messages to be displayed for console view
 *
 * @author Zain, Vishakha
 */
public class ConsoleModel extends java.util.Observable implements ModelInterface {

    private ArrayList<String> logArray;

    /**
     * Method which receives the message to be displayed on console and adds
     * to list and notifies the observers of change
     *
     * @param message teh string to be displayed on console
     */
    public void logMessage(String message) {
        if (logArray == null) {
            logArray = new ArrayList<>();
        }
        logArray.add(message);
        setChanged();
        this.notifyObservers();
    }

    /**
     * returns the messages to be displayed on the console
     *
     * @return ArrayList conatining all the messages to be displayed on console
     */
    public ArrayList<String> getLogArray() {
        return logArray;
    }

}
