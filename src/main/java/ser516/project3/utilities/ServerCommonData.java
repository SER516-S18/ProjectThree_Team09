package ser516.project3.utilities;

import ser516.project3.model.Message;

public class ServerCommonData {

	private static ServerCommonData instance = null;
	private static Message message;


	private int interval;
	private boolean autoRepeat;
	private boolean serverStarted = false;

	protected ServerCommonData() {

	}

	public static ServerCommonData getInstance() {
		if (instance == null) {
			instance = new ServerCommonData();
			message = new Message();
		}
		return instance;
	}

	
	public static void setMessage(Message message) {
		ServerCommonData.message = message;
	}
	
	public Message getMessage() {
		return message;
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
