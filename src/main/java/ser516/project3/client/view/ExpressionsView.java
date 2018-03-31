package ser516.project3.client.view;

import javax.swing.*;
import java.awt.*;

public class ExpressionsView extends JPanel{
    public ExpressionsView(){
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.black));

        add(new JPanel(), BorderLayout.WEST ); // Need to replace with a panel for displaying the face.
        add(new GraphView(), BorderLayout.EAST );
        setVisible(true);
    }
}
