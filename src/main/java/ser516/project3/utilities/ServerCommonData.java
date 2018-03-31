package ser516.project3.utilities;

import ser516.project3.model.Message;

public class ServerCommonData {

	private static ServerCommonData instance = null;
	private static Message message;
	private int interval;

	protected ServerCommonData() {
	}

	public static ServerCommonData getInstance() {
		if (instance == null) {
			instance = new ServerCommonData();
			message = new Message();
		}
		return instance;
	}

	public static Message getMessage() {
		return message;
	}

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}
}
