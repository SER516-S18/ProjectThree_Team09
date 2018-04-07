package ser516.project3.server.controller;

import org.apache.log4j.Logger;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.TopModel;
import ser516.project3.server.service.ServerConnectionServiceImpl;
import ser516.project3.server.service.ServerConnectionServiceInterface;
import ser516.project3.server.view.TopView;
import ser516.project3.utilities.ServerCommonData;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopController implements ControllerInterface{
  final static Logger logger = Logger.getLogger(TopController.class);

  private TopModel topModel;
  private TopView topView;
  private ServerConnectionServiceInterface serverConnectionService;

  private static final String START = "Start";
  private static final String STOP = "Stop";
  private static final String SEND = "Send";

  public TopController(TopModel topModel, TopView topView) {
    this.topModel = topModel;
    this.topView = topView;
  }

  @Override
  public void initializeView() {
    topView.initializeView(null);
    topView.addIntervalInputTextFieldListener(new IntervalDocumentListener());
    topView.addAutoRepeatCheckBoxListener(new AutoRepeatCheckBoxListener());
    topView.addServerStartStopButtonListener(new ServerStartStopButtonListener());
    topView.addSendButtonListener(new SendButtonListener());
    ServerCommonData.getInstance().getMessage().setInterval(topModel.getInterval());
  }

  class IntervalDocumentListener implements DocumentListener {
    @Override
    public void removeUpdate(DocumentEvent e) {
      try {
        if(e.getDocument().getLength() == 0) {
          topModel.setInterval(1);
        } else {
          topModel.setInterval(Double.parseDouble(e.getDocument().getText(0, e.getDocument().getLength())));
        }
        ServerCommonData.getInstance().getMessage().setInterval(topModel.getInterval());
        logger.info("Removed value of interval");
      } catch(BadLocationException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
      try {
        topModel.setInterval(Double.parseDouble(e.getDocument().getText(0, e.getDocument().getLength())));
        ServerCommonData.getInstance().getMessage().setInterval(topModel.getInterval());
        logger.info("Inserted value of interval");
      } catch(BadLocationException ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
  }

  class AutoRepeatCheckBoxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      boolean isChecked = !topModel.isAutoRepeatCheckBoxChecked();
      topModel.setAutoRepeatCheckBoxChecked(isChecked);
      if(isChecked) {
        topModel.setSendButtonText(START);
      } else {
        topModel.setSendButtonText(SEND);
      }
      topView.updateSendButtonText();
      logger.info("Value of auto Repeat toggle changed: " + isChecked);
    }
  }

  class ServerStartStopButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      logger.info("Start/Stop button pressed");
      boolean isStarted = topModel.isServerStarted();
      if(isStarted) {
        serverConnectionService.stopServerEndpoint();
        topModel.setServerStarted(false);
        topModel.setSendButtonEnabled(false);
        topModel.setServerStartStopButtonText("Start Server");
        setBlinking(false);
      } else {
        serverConnectionService.initServerEndpoint();
        topModel.setServerStarted(true);
        topModel.setSendButtonEnabled(true);
        topModel.setServerStartStopButtonText("Stop Server");
        setBlinking(true);
      }
      topView.enableDisableSendButton();
      topView.updateServerStartStopButtonText();
    }
  }

  class SendButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      logger.info("Send button pressed");
      if(topModel.isAutoRepeatCheckBoxChecked()) {
        if(topModel.getSendButtonText().equals(START))
          topModel.setSendButtonText(STOP);
        else
          topModel.setSendButtonText(START);
        topModel.setAutoRepeatEnabled(!topModel.isAutoRepeatEnabled());
        topModel.setIntervalEditable(!topModel.isIntervalEditable());
        topView.updateSendButtonText();
        topView.enableDisableAutoRepeatCheckBox();
        topView.enableDisableEditableIntervalInputTextField();
      }
      if (topModel.isShouldSendData()) {
        topModel.setShouldSendData(false);
      } else {
        topModel.setShouldSendData(true);
      }
    }
  }

  public void setServerConnectionService(ServerConnectionServiceInterface serverConnectionService) {
    this.serverConnectionService = serverConnectionService;
  }

  public void setBlinking(boolean status) {
    topView.setBlinking(status);
  }

  public void updateServerStartStopButtonText() {
    topView.updateServerStartStopButtonText();
  }

  public void updateEnableDisableSendButton() {
    topView.enableDisableSendButton();
  }

  public TopModel getTopModel() {
    return topModel;
  }

  public TopView getTopView() {
    return topView;
  }
}
