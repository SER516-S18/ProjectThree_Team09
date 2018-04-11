package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.ConsoleModel;
import ser516.project3.server.view.ConsoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that controls the console on the server which 
 * shows server status and any error messages
 * 
 * @author Adhiraj Tikku
 */
public class ConsoleController implements ControllerInterface {
  private ConsoleModel consoleModel;
  private ConsoleView consoleView;

  /**
   * Constructor to set the console view and model and to add observer 
   * to the components in console 
   */
  public ConsoleController(ConsoleModel consoleModel, ConsoleView consoleView) {
    this.consoleModel = consoleModel;
    this.consoleView = consoleView;
    consoleModel.addObserver(consoleView);
  }
  
  /**
   * Method to initialize the console view and to add listeners 
   * to the component  
   */
  @Override
  public void initializeView() {
    consoleView.initializeView(null);
    consoleView.addClearConsoleListener(new ClearConsoleListener());
  }

  /**
   * Method to get console view object
   * @return ConsoleView object
   */
  @Override
  public ConsoleView getView() {
    return consoleView;
  }

  /**
   * Returns the set of sub controllers in case any
   *
   * @return array containing sub controllers
   */
  @Override
  public ControllerInterface[] getSubControllers() {
    return null;
  }

  /**
   * Inner class to add action listener to console 
   */
  class ClearConsoleListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      consoleView.clearConsole();
    }
  }
  
  /**
   * Method to get console model object
   * @return ConsoleModel object 
   */ 
  public ConsoleModel getConsoleModel() {
    return consoleModel;
  }
}
