package ser516.project3.model;

import java.util.ArrayList;

/**
 * It stores the messages for console
 *
 * @author Zain, Vishakha
 *
 */
public class ConsoleModel extends java.util.Observable {

    private static ConsoleModel instance;
    private ArrayList<String> logArray;

    public static ConsoleModel getInstance() {
        if (instance == null) {
            instance = new ConsoleModel();
        }
        return instance;
    }

    public void logMessage(String message) {
        if (logArray == null) {
            logArray = new ArrayList<>();
        }
        logArray.add(message);
        setChanged();
        this.notifyObservers();
    }

    public void logError(String message) {
        if (logArray == null) {
            logArray = new ArrayList<>();
        }
        logArray.add(message);
        setChanged();
        this.notifyObservers();
    }

    public ArrayList<String> getLogArray() {
        return logArray;
    }

    public void setLogArray(ArrayList<String> logArray) {
        this.logArray = logArray;
    }
}
