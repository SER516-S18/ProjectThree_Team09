package ser516.project3.server.view;

import ser516.project3.interfaces.ViewInterface;
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

public class ConsoleView extends JPanel implements Observer, ViewInterface {
    private JTextArea consoleOutput;
    private JButton clearConsole;
    private JScrollPane consoleScroll;
    private ConsoleModel consoleModel;

    private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
    private static final Color LIGHTGREY = new Color(245, 245, 245);

    public ConsoleView(ConsoleModel consoleModel) {
        this.consoleModel = consoleModel;
    }

    @Override
    public void initializeView(ViewInterface[] subViews) {
        setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING,
            TitledBorder.TOP, SUBFONT, null));
        setLayout(new FlowLayout());

        consoleOutput = new JTextArea();

        consoleOutput.setEditable(false);
        consoleOutput.setBackground(LIGHTGREY);
        consoleOutput.setFont(new Font("Courier New", Font.PLAIN, 12));

        consoleScroll = new JScrollPane(consoleOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        consoleScroll.setPreferredSize(new Dimension(400,90));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        consoleScroll.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        clearConsole = new JButton();
        clearConsole.setText("Clear");
        add(consoleScroll);
        //add(consoleOutput);
        add(clearConsole);
    }

    @Override
    public void update(Observable messageArrayObject, Object observerObj) {
        ConsoleModel model = (ConsoleModel) messageArrayObject;
        String message = model.getLogArray().get(model.getLogArray().size() - 1);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();

        consoleOutput.append("[" + df.format(dateObj) + "] : " + message);
        consoleOutput.append("\n");
    }

    public void addClearConsoleListener(ActionListener actionListener) {
        clearConsole.addActionListener(actionListener);
    }

    public void clearConsole(){
        consoleOutput.setText(null);
    }
}
