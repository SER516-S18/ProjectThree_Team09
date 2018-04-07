package ser516.project3.server.view;

import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.TopModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopView extends JPanel implements ViewInterface{

  private JLabel intervalLabel;
  private JTextField intervalInputTextField;
  private JCheckBox autoRepeatCheckBox;
  private JButton serverStartStopButton;
  private JButton sendButton;
  private TopModel topModel;

  private static StatusIndicator statusIndicator = new StatusIndicator();

  private static final String INTERVAL_LABEL_NAME = "Interval (seconds):  ";
  private static final String AUTO_REPEAT_CHECKBOX_NAME = "Auto Repeat";
  private static final Font FONT = new Font("Courier New", Font.BOLD, 17);

  public TopView(TopModel topModel) {
    this.topModel = topModel;
  }

  @Override
  public void initializeView(ViewInterface[] subViews) {
    setLayout(new GridBagLayout());
    setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    setOpaque(false);

    Border titledBorder = new TitledBorder(null, "Server Settings", TitledBorder.LEADING, TitledBorder.TOP, FONT, null);
    Border marginBorder = BorderFactory.createEmptyBorder(30, 10, 10, 10);

    Border compoundBorder = BorderFactory.createCompoundBorder(marginBorder, titledBorder);
    setBorder(compoundBorder);

    createIntervalLabel(gridBagConstraints);
    createIntervalInputTextField(gridBagConstraints);
    createAutoRepeatCheckBox(gridBagConstraints);
    createServerStartStopButton(gridBagConstraints);
    createSendButton(gridBagConstraints);
    createStatusIndicator(gridBagConstraints);
  }

  private void createIntervalLabel(GridBagConstraints gridBagConstraint) {
    intervalLabel = new JLabel(INTERVAL_LABEL_NAME);
    intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
    intervalLabel.setOpaque(true);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.gridx = 0;
    gridBagConstraint.gridy = 0;
    gridBagConstraint.ipady = 40;
    gridBagConstraint.insets = new Insets(0, 20, 0, 0);
    add(intervalLabel, gridBagConstraint);
  }

  private void createIntervalInputTextField(GridBagConstraints gridBagConstraint) {
    intervalInputTextField = new JTextField("" + topModel.getInterval());
    intervalInputTextField.setBorder(BorderFactory.createLineBorder(Color.black));
    intervalInputTextField.setColumns(3);
    intervalInputTextField.setHorizontalAlignment(SwingConstants.CENTER);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.weightx = 0.5;
    gridBagConstraint.gridx = 1;
    gridBagConstraint.gridy = 0;
    gridBagConstraint.ipady = 20;
    gridBagConstraint.insets = new Insets(0, 20, 0, 20);
    add(intervalInputTextField, gridBagConstraint);
  }

  private void createAutoRepeatCheckBox(GridBagConstraints gridBagConstraint) {
    autoRepeatCheckBox = new JCheckBox(AUTO_REPEAT_CHECKBOX_NAME, topModel.isAutoRepeatCheckBoxChecked());
    autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.gridx = 2;
    gridBagConstraint.gridy = 0;
    gridBagConstraint.ipady = 40;
    add(autoRepeatCheckBox, gridBagConstraint);
  }

  private void createServerStartStopButton(GridBagConstraints gridBagConstraint) {
    serverStartStopButton = new JButton(topModel.getServerStartStopButtonText());
    serverStartStopButton.setHorizontalAlignment(SwingConstants.CENTER);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.weighty = 2.0;
    gridBagConstraint.gridx = 0;
    gridBagConstraint.gridy = 1;
    gridBagConstraint.ipady = 20;
    gridBagConstraint.insets = new Insets(0, 30, 0, 30);
    add(serverStartStopButton, gridBagConstraint);
  }

  private void createSendButton(GridBagConstraints gridBagConstraint) {
    sendButton = new JButton(topModel.getSendButtonText());
    sendButton.setHorizontalAlignment(SwingConstants.CENTER);
    sendButton.setEnabled(false);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.weighty = 2.0;
    gridBagConstraint.gridx = 1;
    gridBagConstraint.gridy = 1;
    gridBagConstraint.ipady = 20;
    gridBagConstraint.insets = new Insets(0, 30, 0, 30);
    add(sendButton, gridBagConstraint);
  }

  private void createStatusIndicator(GridBagConstraints gridBagConstraint) {
    statusIndicator.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
    statusIndicator.setBounds(100, 200, 50, 80);
    gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
    gridBagConstraint.weightx = 1;
    gridBagConstraint.gridx = 2;
    gridBagConstraint.gridy = 1;
    gridBagConstraint.ipady = 10;
    gridBagConstraint.insets = new Insets(0, 0, 0, 0);

    add(statusIndicator,gridBagConstraint);
  }
  public void addIntervalInputTextFieldListener(DocumentListener documentListener) {
    intervalInputTextField.getDocument().addDocumentListener(documentListener);
  }

  public void addAutoRepeatCheckBoxListener(ActionListener actionListener) {
    autoRepeatCheckBox.addActionListener(actionListener);
  }

  public void addServerStartStopButtonListener(ActionListener actionListener) {
    serverStartStopButton.addActionListener(actionListener);
  }

  public void addSendButtonListener(ActionListener actionListener) {
    sendButton.addActionListener(actionListener);
  }

  public void enableDisableSendButton() {
    sendButton.setEnabled(topModel.isSendButtonEnabled());
  }

  public void updateSendButtonText() {
    sendButton.setText(topModel.getSendButtonText());
  }

  public void updateServerStartStopButtonText() {
    serverStartStopButton.setText(topModel.getServerStartStopButtonText());
  }

  public void enableDisableAutoRepeatCheckBox() {
    autoRepeatCheckBox.setEnabled(topModel.isAutoRepeatEnabled());
  }

  public void enableDisableEditableIntervalInputTextField() {
    intervalInputTextField.setEditable(topModel.isIntervalEditable());
  }

  public void setBlinking(boolean status) {
    statusIndicator.setBlinking(status);
  }
}
