package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

public class TopModel implements ModelInterface {
  private double interval;
  private boolean autoRepeatCheckBoxChecked;
  private boolean serverStarted;
  private boolean shouldSendData;
  private boolean intervalError;
  private boolean intervalEditable;
  private boolean autoRepeatEnabled;
  private boolean sendButtonEnabled;
  private String serverStartStopButtonText;
  private String sendButtonText;

  public TopModel() {
    interval = 1;
    autoRepeatCheckBoxChecked = false;
    serverStarted = false;
    shouldSendData = false;
    intervalEditable = true;
    autoRepeatEnabled = true;
    sendButtonEnabled = false;
    serverStartStopButtonText = "Start Server";
    sendButtonText = "Send";
  }

/**
 * @return the interval
 */
public double getInterval() {
	return interval;
}

/**
 * @param interval the interval to set
 */
public void setInterval(double interval) {
	this.interval = interval;
}

/**
 * @return the autoRepeatCheckBoxChecked
 */
public boolean isAutoRepeatCheckBoxChecked() {
	return autoRepeatCheckBoxChecked;
}

/**
 * @param autoRepeatCheckBoxChecked the autoRepeatCheckBoxChecked to set
 */
public void setAutoRepeatCheckBoxChecked(boolean autoRepeatCheckBoxChecked) {
	this.autoRepeatCheckBoxChecked = autoRepeatCheckBoxChecked;
}

/**
 * @return the serverStarted
 */
public boolean isServerStarted() {
	return serverStarted;
}

/**
 * @param serverStarted the serverStarted to set
 */
public void setServerStarted(boolean serverStarted) {
	this.serverStarted = serverStarted;
}

/**
 * @return the shouldSendData
 */
public boolean isShouldSendData() {
	return shouldSendData;
}

/**
 * @param shouldSendData the shouldSendData to set
 */
public void setShouldSendData(boolean shouldSendData) {
	this.shouldSendData = shouldSendData;
}

/**
 * @return the intervalError
 */
public boolean isIntervalError() {
	return intervalError;
}

/**
 * @param intervalError the intervalError to set
 */
public void setIntervalError(boolean intervalError) {
	this.intervalError = intervalError;
}

/**
 * @return the intervalEditable
 */
public boolean isIntervalEditable() {
	return intervalEditable;
}

/**
 * @param intervalEditable the intervalEditable to set
 */
public void setIntervalEditable(boolean intervalEditable) {
	this.intervalEditable = intervalEditable;
}

/**
 * @return the autoRepeatEnabled
 */
public boolean isAutoRepeatEnabled() {
	return autoRepeatEnabled;
}

/**
 * @param autoRepeatEnabled the autoRepeatEnabled to set
 */
public void setAutoRepeatEnabled(boolean autoRepeatEnabled) {
	this.autoRepeatEnabled = autoRepeatEnabled;
}

/**
 * @return the sendButtonEnabled
 */
public boolean isSendButtonEnabled() {
	return sendButtonEnabled;
}

/**
 * @param sendButtonEnabled the sendButtonEnabled to set
 */
public void setSendButtonEnabled(boolean sendButtonEnabled) {
	this.sendButtonEnabled = sendButtonEnabled;
}

/**
 * @return the serverStartStopButtonText
 */
public String getServerStartStopButtonText() {
	return serverStartStopButtonText;
}

/**
 * @param serverStartStopButtonText the serverStartStopButtonText to set
 */
public void setServerStartStopButtonText(String serverStartStopButtonText) {
	this.serverStartStopButtonText = serverStartStopButtonText;
}

/**
 * @return the sendButtonText
 */
public String getSendButtonText() {
	return sendButtonText;
}

/**
 * @param sendButtonText the sendButtonText to set
 */
public void setSendButtonText(String sendButtonText) {
	this.sendButtonText = sendButtonText;
}

  
}
