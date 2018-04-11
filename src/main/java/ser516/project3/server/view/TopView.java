package ser516.project3.server.view;

import com.alee.laf.button.WebButton;
import ser516.project3.constants.ClientConstants;
import ser516.project3.constants.ServerConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.TopModel;
import ser516.project3.utilities.NumberTextField;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class to create components in server settings panel in the server
 * window and to add listeners for each component
 *
 * @author User
 */
public class TopView extends JPanel implements ViewInterface {

    private JLabel intervalLabel;
    private JTextField intervalInputTextField;
    private JCheckBox autoRepeatCheckBox;
    private WebButton serverStartStopButton;
    private WebButton sendButton;
    private TopModel topModel;

    private static StatusIndicator statusIndicator = new StatusIndicator();

    private static final String INTERVAL_LABEL_NAME = "Interval (seconds):  ";
    private static final String AUTO_REPEAT_CHECKBOX_NAME = "Auto Repeat";
    private static final Font FONT = new Font("Courier New", Font.BOLD, 17);
    private static final int FONT_SIZE = 15;

    /**
     * Method to set top model
     *
     * @param topModel model object containing required data for the
     *                 server settings panel
     */
    public TopView(TopModel topModel) {
        this.topModel = topModel;
    }

    /**
     * Method to initialize the server settings panel
     *
     * @param subViews object of type ViewInterface
     */
    @Override
    public void initializeView(ViewInterface[] subViews) {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#747b83"));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Border titledBorder = new TitledBorder(null, "Server Settings", TitledBorder.LEADING,
                TitledBorder.TOP, FONT, null);

        createIntervalLabel(gridBagConstraints);
        createIntervalInputTextField(gridBagConstraints);
        createAutoRepeatCheckBox(gridBagConstraints);
        createServerStartStopButton(gridBagConstraints);
        createSendButton(gridBagConstraints);
        createStatusIndicator(gridBagConstraints);
    }

    /**
     * Method to create labels in server settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for each label
     */
    private void createIntervalLabel(GridBagConstraints gridBagConstraint) {
        intervalLabel = new JLabel(INTERVAL_LABEL_NAME);
        intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        intervalLabel.setBackground(Color.decode("#747b83"));
        gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraint.gridx = 0;
        gridBagConstraint.gridy = 0;
        gridBagConstraint.ipady = 40;
        gridBagConstraint.insets = new Insets(0, 20, 0, 0);
        add(intervalLabel, gridBagConstraint);
    }

    /**
     * Method to create text fields in server settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for each text field
     */
    private void createIntervalInputTextField(GridBagConstraints gridBagConstraint) {
        intervalInputTextField = new NumberTextField("" + topModel.getInterval(), true);
        intervalInputTextField.setBackground(Color.decode("#616266"));
        intervalInputTextField.setBorder(null);
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

    /**
     * Method to create CheckBox in server settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for Auto-Repeat checkBox
     */
    private void createAutoRepeatCheckBox(GridBagConstraints gridBagConstraint) {
        autoRepeatCheckBox = new JCheckBox(AUTO_REPEAT_CHECKBOX_NAME,
                topModel.isAutoRepeatCheckBoxChecked());
        autoRepeatCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraint.gridx = 2;
        gridBagConstraint.gridy = 0;
        gridBagConstraint.ipady = 40;
        add(autoRepeatCheckBox, gridBagConstraint);
    }

    /**
     * Method to create a start/stop button in settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for toggleButton
     */
    private void createServerStartStopButton(GridBagConstraints gridBagConstraint) {
        serverStartStopButton = new WebButton(topModel.getServerStartStopButtonText());
        serverStartStopButton.setPreferredSize(new Dimension(120, 35));
        serverStartStopButton.setBottomBgColor(Color.BLACK);
        serverStartStopButton.setTopBgColor(Color.BLACK);
        serverStartStopButton.setBottomSelectedBgColor(Color.WHITE);
        serverStartStopButton.setTopSelectedBgColor(Color.WHITE);
        serverStartStopButton.setForeground(Color.WHITE);
        serverStartStopButton.setDrawShade(false);
        serverStartStopButton.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
        serverStartStopButton.setHorizontalAlignment(SwingConstants.CENTER);
        gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraint.weighty = 2.0;
        gridBagConstraint.gridx = 0;
        gridBagConstraint.gridy = 1;
        gridBagConstraint.ipady = 10;
        gridBagConstraint.insets = new Insets(0, 30, 0, 30);
        add(serverStartStopButton, gridBagConstraint);
    }

    /**
     * Method to create a send button in settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for toggleButton
     */
    private void createSendButton(GridBagConstraints gridBagConstraint) {
        sendButton = new WebButton(topModel.getSendButtonText());
        sendButton.setPreferredSize(new Dimension(120, 35));
        sendButton.setBottomBgColor(Color.BLACK);
        sendButton.setTopBgColor(Color.BLACK);
        sendButton.setBottomSelectedBgColor(Color.WHITE);
        sendButton.setTopSelectedBgColor(Color.WHITE);
        sendButton.setForeground(Color.WHITE);
        sendButton.setDrawShade(false);
        sendButton.setFont(new Font(ClientConstants.FONT_NAME, Font.BOLD, FONT_SIZE));
        sendButton.setHorizontalAlignment(SwingConstants.CENTER);
        sendButton.setEnabled(false);
        gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraint.weighty = 2.0;
        gridBagConstraint.gridx = 2;
        gridBagConstraint.gridy = 1;
        gridBagConstraint.ipady = 0;
        gridBagConstraint.insets = new Insets(0, 10, 0, 0);
        add(sendButton, gridBagConstraint);
    }

    /**
     * Method to create a status indicator in settings panel
     *
     * @param gridBagConstraint GridBagConstraints object to set the position
     *                          for toggleButton
     */
    private void createStatusIndicator(GridBagConstraints gridBagConstraint) {
        statusIndicator.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        statusIndicator.setBounds(100, 200, 50, 80);
        statusIndicator.setBackground(Color.decode(ServerConstants.COLOR_CODE));
        gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraint.weightx = 1;
        gridBagConstraint.gridx = 1;
        gridBagConstraint.gridy = 1;
        gridBagConstraint.ipady = 0;
        gridBagConstraint.insets = new Insets(0, 0, 0, 0);
        add(statusIndicator, gridBagConstraint);
    }

    /**
     * Method to add DocumentListener to time interval text field
     */
    public void addIntervalInputTextFieldListener(DocumentListener documentListener) {
        intervalInputTextField.getDocument().addDocumentListener(documentListener);
    }

    /**
     * Method to add ActionListener to Auto-Repeat CheckBox
     */
    public void addAutoRepeatCheckBoxListener(ActionListener actionListener) {
        autoRepeatCheckBox.addActionListener(actionListener);
    }

    /**
     * Method to add ActionListener to Server start-stop button
     */
    public void addServerStartStopButtonListener(ActionListener actionListener) {
        serverStartStopButton.addActionListener(actionListener);
    }

    /**
     * Method to add ActionListener to send button
     */
    public void addSendButtonListener(ActionListener actionListener) {
        sendButton.addActionListener(actionListener);
    }

    /**
     * Method to add enable or disable the send button
     */
    public void enableDisableSendButton() {
        sendButton.setEnabled(topModel.isSendButtonEnabled());
    }

    /**
     * Method to update the text of send button
     */
    public void updateSendButtonText() {
        sendButton.setText(topModel.getSendButtonText());
    }

    /**
     * Method to update start stop button text
     */
    public void updateServerStartStopButtonText() {
        serverStartStopButton.setText(topModel.getServerStartStopButtonText());
    }

    /**
     * Method to add enable or disable the auto-repeat Check box
     */
    public void enableDisableAutoRepeatCheckBox() {
        autoRepeatCheckBox.setEnabled(topModel.isAutoRepeatEnabled());
    }

    /**
     * Method to make the time interval text field editable
     */
    public void enableDisableEditableIntervalInputTextField() {
        intervalInputTextField.setEditable(topModel.isIntervalEditable());
    }

    /**
     * Method to set the state status indicator
     *
     * @param status status of the server
     */
    public void setBlinking(boolean status) {
        statusIndicator.setBlinking(status);
    }
}