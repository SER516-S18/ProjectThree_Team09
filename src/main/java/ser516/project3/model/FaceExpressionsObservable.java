package ser516.project3.model;

import java.util.Observable;

/**
 * Observable class to notify the observers if any changes for the face
 * expressions are received from the server
 *
 * @author Manish Tandon
 */
public class FaceExpressionsObservable extends Observable {

    private MessageModel messageBean;

    private static FaceExpressionsObservable instance;

    /**
     * Constructor to initialize the class with default values.
     */
    private FaceExpressionsObservable() {
        messageBean = new MessageModel();
    }

    /**
     * Creates a singleton instance . If exists, returns it, else creates it.
     *
     * @return instance of the FaceExpressionsObservable
     */
    public static FaceExpressionsObservable getInstance() {
        if (instance == null) {
            instance = new FaceExpressionsObservable();
        }
        return instance;
    }

    /**
     * Returns the message model currently stored in the observable
     *
     * @return returns the messageModel
     */
    public MessageModel getMessageBean() {
        return messageBean;
    }

    /**
     * Updates the message model with the new values and notifies the
     * obsever of the changes
     *
     * @param messageBean the new model to be updated
     */
    public void setMessageBean(MessageModel messageBean) {
        this.messageBean = messageBean;
        setChanged();
        notifyObservers();
    }


}
