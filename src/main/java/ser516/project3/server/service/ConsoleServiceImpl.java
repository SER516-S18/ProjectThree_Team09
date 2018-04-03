package ser516.project3.server.service;

import javax.swing.*;

public class ConsoleServiceImpl implements ConsoleService {

    @Override
    public void clearConsole(JTextArea console) {
        console.setText("");
    }
}
