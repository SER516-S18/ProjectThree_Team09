package ser516.project3.server.view;

import ser516.project3.model.ConsoleModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
/**
 * Class to create console and print the status to console
 * with timestamp.
 * @author Vishakha, Zain, Pratik
 *
 */

public class ConsoleView implements Observer {

    private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
    private static final Color LIGHTGREY = new Color(245, 245, 245);

    private JTextArea consoleOutput;
    private JPanel consolePanel;
    private JButton clearConsole;

    // Constructor to initialize console.
    public ConsoleView() {
        consolePanel = new JPanel();
        consolePanel.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING,
                TitledBorder.TOP, SUBFONT, null));
        consolePanel.setLayout(new FlowLayout());

        consoleOutput = new JTextArea();
        consoleOutput.setPreferredSize(new Dimension(400,100));
        consoleOutput.setEditable(false);
        consoleOutput.setBackground(LIGHTGREY);
        consoleOutput.setFont(new Font("Courier New", Font.PLAIN, 15));

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        consoleOutput.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        clearConsole = new JButton();
        clearConsole.setText("Clear");
        consolePanel.add(consoleOutput);
        consolePanel.add(clearConsole);
        clearConsole.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                consoleOutput.setText(null);
            }
        });

    }

    public JPanel getConsolePanel() {
        return consolePanel;
    }

    @Override
    public void update(Observable messageArrayObject, Object observerObj) {
        //messageArrayObject is ConsoleModel object
        ConsoleModel model = (ConsoleModel) messageArrayObject;
        String message = model.getLogArray().get(model.getLogArray().size() - 1);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();

        consoleOutput.append("[" + df.format(dateObj) + "] : " + message);
        consoleOutput.append("\n");
    }

    public void clear(){
        consoleOutput.setText("");
    }
}
