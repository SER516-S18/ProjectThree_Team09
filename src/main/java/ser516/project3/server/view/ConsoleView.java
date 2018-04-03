package ser516.project3.server.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {

    private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
    private static final Color LIGHTGREY = new Color(245, 245, 245);

    private JTextArea consoleOutput;
    private JPanel consolePanel;

    public ConsoleView() {
        consolePanel = new JPanel();
        consolePanel.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING,
                TitledBorder.TOP, SUBFONT, null));
        consolePanel.setLayout(new GridBagLayout());

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        //Add Components to Console panel here
        consoleOutput = new JTextArea();
        consoleOutput.setPreferredSize(new Dimension(200,200));
        consoleOutput.setEditable(false);
        consoleOutput.setBackground(LIGHTGREY);
        consoleOutput.setFont(new Font("Courier New", Font.PLAIN, 15));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        consolePanel.add(consoleOutput,bagConstraints);
    }

    public JPanel getConsolePanel() {
        return consolePanel;
    }

    @Override
    public void update(Observable messageArrayObject, Object observerObj) {
        //TODO: update textarea
        System.out.println("Log"+messageArrayObject);
    }
}
