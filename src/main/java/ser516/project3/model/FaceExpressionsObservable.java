package ser516.project3.model;

import java.util.Observable;

public class FaceExpressionsObservable extends Observable{

	private MessageModel messageBean;

	private static FaceExpressionsObservable instance;
	
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

	 
	
	public MessageModel getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageModel messageBean) {

		this.messageBean = messageBean;
		setChanged();
		notifyObservers();
	}
	
	
	
}
