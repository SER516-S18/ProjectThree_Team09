package ser516.project3.client.view;

import ser516.project3.model.ExpressionsModel;

import javax.swing.*;
import java.awt.*;

public class ExpressionsView extends JPanel{
    private ExpressionsModel expressionsModel;

    public ExpressionsView(ExpressionsModel expressionsModel){
        this.expressionsModel = expressionsModel;
        setLayout(new GridLayout(1, 2, 8, 8 ));
        setBackground(Color.decode("#AFAFAF"));
    }

    public void initializeExpressionsUI(GraphView graphView) {
        add(new JPanel(), BorderLayout.LINE_START ); // Need to replace with a panel for displaying the face.
        add(graphView, BorderLayout.LINE_END );
        setVisible(true);
    }
}
