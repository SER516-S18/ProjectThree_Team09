package ser516.project3.utilities;

import ser516.project3.model.MessageModel;

public class ServerCommonData {

	private static ServerCommonData instance = null;
	private static MessageModel messageModel;

	private int interval;

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
}
