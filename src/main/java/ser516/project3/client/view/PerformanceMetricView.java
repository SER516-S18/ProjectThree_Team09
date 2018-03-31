package ser516.project3.client.view;

import javax.swing.*;
import java.awt.*;

public class PerformanceMetricView extends JPanel{
	public PerformanceMetricView(){
		setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.black));

		add(new GraphView(), BorderLayout.WEST );
		add(new JPanel(), BorderLayout.EAST ); // Need to replace with a panel for displaying the 6 emotion buttons.
		setVisible(true);
	}
}
