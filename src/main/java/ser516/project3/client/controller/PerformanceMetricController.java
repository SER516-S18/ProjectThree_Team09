package ser516.project3.client.controller;

import ser516.project3.interfaces.ViewInterface;
import ser516.project3.client.view.PerformanceMetricView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.PerformanceMetricModel;
import ser516.project3.constants.ClientConstants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;

/**
 * The PerformanceMetricController class is used to initialize the performance
 * view on ClientUI and update the performance data received from the server
 * 
 * @author vsriva12
 *
 */
public class PerformanceMetricController implements ControllerInterface {
	private PerformanceMetricModel performanceMetricModel;
	private PerformanceMetricView performanceMetricView;

	private GraphController graphController;

	public PerformanceMetricController(PerformanceMetricModel performanceMetricModel,
			PerformanceMetricView performanceMetricView, GraphController graphController) {
		this.performanceMetricModel = performanceMetricModel;
		this.performanceMetricView = performanceMetricView;
		this.graphController = graphController;
	}

	@Override
	public void initializeView() {
		graphController.setNoOfChannels(6);
		graphController.setXLength(performanceMetricModel.getDisplayLength());
		Color channelColors[] = { performanceMetricModel.getInterestColor(),
				performanceMetricModel.getEngagementColor(), performanceMetricModel.getStressColor(),
				performanceMetricModel.getRelaxationColor(), performanceMetricModel.getExcitementColor(),
				performanceMetricModel.getFocusColor() };
		graphController.setChannelColors(channelColors);
		graphController.updateGraphView();
		ViewInterface clientViewInterface[] = { graphController.getGraphView() };
		performanceMetricView.initializeView(clientViewInterface);
		performanceMetricView.addEmotionButtonsListener(new EmotionButtonsListener());
		performanceMetricView.addDisplayLengthListener(new DisplayLengthKeyListener(),
				new DisplayLengthDocumentListener());
	}

	public PerformanceMetricView getPerformanceMetricView() {
		return performanceMetricView;
	}

	public GraphController getGraphController() {
		return graphController;
	}

	public class EmotionButtonsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Color initialBackground;
			Color newBackground;
			switch (e.getActionCommand()) {
			case ClientConstants.INTEREST:
				initialBackground = performanceMetricModel.getInterestColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.INTEREST + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setInterestColor(newBackground);
				}
				break;
			case ClientConstants.ENGAGEMENT:
				initialBackground = performanceMetricModel.getEngagementColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.ENGAGEMENT + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setEngagementColor(newBackground);
				}
				break;
			case ClientConstants.STRESS:
				initialBackground = performanceMetricModel.getStressColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.STRESS + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setStressColor(newBackground);
				}
				break;
			case ClientConstants.RELAXATION:
				initialBackground = performanceMetricModel.getRelaxationColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.RELAXATION + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setRelaxationColor(newBackground);
				}
				break;
			case ClientConstants.EXCITEMENT:
				initialBackground = performanceMetricModel.getExcitementColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.EXCITEMENT + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setExcitementColor(newBackground);
				}
				break;
			case ClientConstants.FOCUS:
				initialBackground = performanceMetricModel.getFocusColor();
				newBackground = JColorChooser.showDialog(null, "Change " + ClientConstants.FOCUS + " Color",
						initialBackground);
				if (newBackground != null) {
					performanceMetricModel.setFocusColor(newBackground);
				}
				break;
			}

			Color channelColors[] = { performanceMetricModel.getInterestColor(),
					performanceMetricModel.getEngagementColor(), performanceMetricModel.getStressColor(),
					performanceMetricModel.getRelaxationColor(), performanceMetricModel.getExcitementColor(),
					performanceMetricModel.getFocusColor() };
			graphController.setChannelColors(channelColors);
			graphController.updateGraphView();

			performanceMetricView.updatePerformanceMetricView(performanceMetricModel);
		}
	}

	public class DisplayLengthKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				graphController.updateGraphView();
				performanceMetricView.updatePerformanceMetricView(performanceMetricModel);
			}
		}
	}

	class DisplayLengthDocumentListener implements DocumentListener {
		@Override
		public void removeUpdate(DocumentEvent e) {
			try {
				if (e.getDocument().getLength() == 0) {
					performanceMetricModel.setDisplayLength(1);
					graphController.setXLength(1);
				} else {
					performanceMetricModel.setDisplayLength(
							Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
					graphController.setXLength(performanceMetricModel.getDisplayLength());
				}
			} catch (BadLocationException ex) {
				System.out.println(ex);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			try {
				if (Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())) == 0) {
					performanceMetricModel.setDisplayLength(1);
					graphController.setXLength(1);
				} else {
					performanceMetricModel.setDisplayLength(
							Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
					graphController.setXLength(performanceMetricModel.getDisplayLength());
				}
			} catch (BadLocationException ex) {
				System.out.println(ex);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	}
}
