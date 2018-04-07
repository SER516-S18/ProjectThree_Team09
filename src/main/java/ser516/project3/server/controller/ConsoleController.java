package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.ConsoleModel;
import ser516.project3.server.view.ConsoleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleController implements ControllerInterface {
  private ConsoleModel consoleModel;
  private ConsoleView consoleView;

  public ConsoleController(ConsoleModel consoleModel, ConsoleView consoleView) {
    this.consoleModel = consoleModel;
    this.consoleView = consoleView;
    consoleModel.addObserver(consoleView);
  }

  @Override
  public void initializeView() {
    consoleView.initializeView(null);
    consoleView.addClearConsoleListener(new ClearConsoleListener());
  }

  class ClearConsoleListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      consoleView.clearConsole();
    }
  }

  public ConsoleView getConsoleView() {
    return consoleView;
  }

  public ConsoleModel getConsoleModel() {
    return consoleModel;
  }
}
