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

  public double getInterval() {
    return interval;
  }

  public void setInterval(double interval) {
    this.interval = interval;
  }

  public boolean isAutoRepeatCheckBoxChecked() {
    return autoRepeatCheckBoxChecked;
  }

  public void setAutoRepeatCheckBoxChecked(boolean autoRepeatCheckBoxChecked) {
    this.autoRepeatCheckBoxChecked = autoRepeatCheckBoxChecked;
  }

  public boolean isServerStarted() {
    return serverStarted;
  }

  public void setServerStarted(boolean serverStarted) {
    this.serverStarted = serverStarted;
  }

  public boolean isShouldSendData() {
    return shouldSendData;
  }

  public void setShouldSendData(boolean shouldSendData) {
    this.shouldSendData = shouldSendData;
  }

  public boolean isSendButtonEnabled() {
    return sendButtonEnabled;
  }

  public void setSendButtonEnabled(boolean sendButtonEnabled) {
    this.sendButtonEnabled = sendButtonEnabled;
  }

  public boolean isAutoRepeatEnabled() {
    return autoRepeatEnabled;
  }

  public void setAutoRepeatEnabled(boolean autoRepeatEnabled) {
    this.autoRepeatEnabled = autoRepeatEnabled;
  }

  public String getServerStartStopButtonText() {
    return serverStartStopButtonText;
  }

  public void setServerStartStopButtonText(String serverStartStopButtonText) {
    this.serverStartStopButtonText = serverStartStopButtonText;
  }

  public String getSendButtonText() {
    return sendButtonText;
  }

  public void setSendButtonText(String sendButtonText) {
    this.sendButtonText = sendButtonText;
  }

  public boolean isIntervalEditable() {
    return intervalEditable;
  }

  public void setIntervalEditable(boolean intervalEditable) {
    this.intervalEditable = intervalEditable;
  }

  public boolean isIntervalError() {
    return intervalError;
  }

  public void setIntervalError(boolean intervalError) {
    this.intervalError = intervalError;
  }
}
