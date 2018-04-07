package ser516.project3.utilities;

import ser516.project3.model.MessageModel;

public class ServerCommonData {

	private static ServerCommonData instance = null;
	private static MessageModel messageModel;


	private int interval;
	private boolean autoRepeat;
	private boolean serverStarted = false;

	protected ServerCommonData() {

	}

	public static ServerCommonData getInstance() {
		if (instance == null) {
			instance = new ServerCommonData();
			messageModel = new MessageModel();
		}
		return instance;
	}


	public static void setMessageModel(MessageModel messageModel) {
		ServerCommonData.messageModel = messageModel;
	}
	
	public MessageModel getMessage() {
		return messageModel;
	}

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @return the autoRepeat
	 */
	public boolean isAutoRepeat() {
		return autoRepeat;
	}

	/**
	 * @param autoRepeat
	 *            the autoRepeat to set
	 */
	public void setAutoRepeat(boolean autoRepeat) {
		this.autoRepeat = autoRepeat;
	}

	/**
	 * @return the serverStarted
	 */
	public boolean isServerStarted() {
		return serverStarted;
	}

	/**
	 * @param serverStarted
	 *            the serverStarted to set
	 */
	public void setServerStarted(boolean serverStarted) {
		this.serverStarted = serverStarted;
	}

}
