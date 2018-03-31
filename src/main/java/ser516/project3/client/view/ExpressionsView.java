package ser516.project3.client.view;

import javax.swing.*;
import java.awt.*;

public class ExpressionsView extends JPanel{
    private static final Color LIGHTGREY = new Color(245, 245, 245);

    public ExpressionsView(){
        setLayout(new GridLayout(1, 2, 8, 8 ));
        setBackground(LIGHTGREY);

        add(new JPanel(), BorderLayout.LINE_START ); // Need to replace with a panel for displaying the face.
        add(new GraphView(), BorderLayout.LINE_END );
        setVisible(true);
    }
}
