package ser516.project3.client.controller;

import ser516.project3.client.view.ConnectionPopUpView;
import ser516.project3.constants.ClientConstants;
import ser516.project3.model.ConnectionPopUpModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * It controls the flow of Connection Details pop up to
 * enter the ip address and port number to connect to the
 * server.
 *
 * @author vishakhasingal, Adhiraj Tikku
 */

public class ConnectionPopUpController {
  private ConnectionPopUpView connectionPopUpView;
  private ConnectionPopUpModel connectionPopUpModel;

  public ConnectionPopUpController(ConnectionPopUpModel connectionPopUpModel) {
    this.connectionPopUpModel = connectionPopUpModel;
    connectionPopUpView = new ConnectionPopUpView(connectionPopUpModel);

    connectionPopUpView.addConnectButtonListener(new ConnectListener());
    connectionPopUpView.addIPDocumentListener(new IPDocumentListener());
    connectionPopUpView.addPortDocumentListener(new PortDocumentListener());
  }

  /**
   * Inner class to control click on ok button in Pop up
   *
   * @author Adhiraj Tikku
   */
  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (connectionPopUpModel.getIpAddress().length() == 0) {
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, ClientConstants.NO_IP_ADDRESS_MESSAGE);
      } else if (connectionPopUpModel.getPortNumber() <= 0) {
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, ClientConstants.NO_PORT_NO_MESSAGE);
      } else {
        ClientController.getInstance().toggleConnectionToServer(connectionPopUpModel.getIpAddress(), connectionPopUpModel.getPortNumber());
        connectionPopUpView.dispose();
      }
    }
  }

  /**
   * Inner class to control the updations in the ip address
   * text field and update the model accordingly.
   *
   * @author Adhiraj Tikku
   */
  class IPDocumentListener implements DocumentListener {
    @Override
    public void removeUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setIpAddress(e.getDocument().getText(0, e.getDocument().getLength()));
      }catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setIpAddress(e.getDocument().getText(0, e.getDocument().getLength()));
      }catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
  }

  /**
   * Inner class to control the updations in the port number
   * text field and update the model accordingly.
   *
   * @author Adhiraj Tikku
   */
  class PortDocumentListener implements DocumentListener {
    @Override
    public void removeUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setPortNumber(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
      } catch (NumberFormatException ex) {
        connectionPopUpModel.setPortNumber(0);
      } catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setPortNumber(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
      } catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
  }
}
