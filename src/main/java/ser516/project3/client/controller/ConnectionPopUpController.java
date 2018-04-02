package ser516.project3.client.controller;

import ser516.project3.client.view.ConnectionPopUpView;
import ser516.project3.model.ConnectionPopUpModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionPopUpController {
  private ConnectionPopUpView connectionPopUpView;
  private ConnectionPopUpModel connectionPopUpModel;

  public ConnectionPopUpController() {
    connectionPopUpModel = new ConnectionPopUpModel();
    connectionPopUpView = new ConnectionPopUpView(connectionPopUpModel);

    connectionPopUpView.addConnectButtonListener(new ConnectListener());
    connectionPopUpView.addIPDocumentListener(new IPDocumentListener());
    connectionPopUpView.addPortDocumentListener(new PortDocumentListener());
  }

  class ConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      ClientControllerInterface clientControllerImpl = new ClientControllerImpl();
      clientControllerImpl.toggleConnectionToServer(connectionPopUpModel.getIpAddress(), connectionPopUpModel.getPortNumber());
    }
  }

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

  class PortDocumentListener implements DocumentListener {
    @Override
    public void removeUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setPortNumber(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
      } catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
      try {
        connectionPopUpModel.setPortNumber(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "You must input a valid number for this field!");
      } catch(BadLocationException ex) {
        System.out.println(ex);
      }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
  }
}
