package ser516.project3.client.view;

import ser516.project3.constants.ClientConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.ExpressionsModel;

import javax.swing.*;
import java.awt.*;

/**
 * The ExpressionsView class creates the expressions panel on the client UI.
 * 
 * @author vsriva12
 *
 */
@SuppressWarnings("serial")
public class ExpressionsView extends JPanel implements ViewInterface {
	private ExpressionsModel expressionsModel;

	
	public ExpressionsView(ExpressionsModel expressionsModel) {
		this.expressionsModel = expressionsModel;
	}

	/**
	 * This method initializes the graph and face for the expressions panel.
	 * 
	 * @param subViews
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {
		GraphView graphView = (GraphView) subViews[0];
		FaceView faceView = (FaceView) subViews[1];

		setLayout(new GridLayout(1, 2, 8, 8));
		setBackground(Color.decode(ClientConstants.PANEL_COLOR_HEX));

		add(faceView, BorderLayout.LINE_START);
		add(graphView, BorderLayout.LINE_END);
		setVisible(true);
	}
}
