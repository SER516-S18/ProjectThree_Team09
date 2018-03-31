package ser516.project3.client.view;

import javax.swing.*;
import java.awt.*;

public class PerformanceMetricView extends JPanel{
	private static final Color LIGHTGREY = new Color(245, 245, 245);

	public PerformanceMetricView(){
		setLayout(new GridLayout(1, 2, 8, 8 ));
		setBackground(LIGHTGREY);

		add(new GraphView(), BorderLayout.LINE_START );
		add(new JPanel(), BorderLayout.LINE_END ); // Need to replace with a panel for displaying the 6 emotion buttons.
		setVisible(true);
	}
}
