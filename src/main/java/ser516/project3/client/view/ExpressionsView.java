package ser516.project3.client.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ExpressionsView extends JPanel{
    private static final Color LIGHTGREY = new Color(245, 245, 245);
    private static final Font FONT = new Font("Courier New", Font.BOLD, 16);

    public ExpressionsView(){
        setLayout(new GridLayout(1, 2, 8, 8 ));
        setBackground(LIGHTGREY);

        add(new JPanel(), BorderLayout.LINE_START ); // Need to replace with a panel for displaying the face.

        GraphView graphView = new GraphView();
        graphView.setLayout(new GridLayout(1, 1, 8, 8));
        graphView.setOpaque(false);
        graphView.setBorder(new TitledBorder(null, "Graph",
            TitledBorder.LEADING, TitledBorder.TOP, FONT, null));
        add(graphView, BorderLayout.LINE_END );
        setVisible(true);
    }
}
