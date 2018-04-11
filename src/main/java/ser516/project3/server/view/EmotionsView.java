package ser516.project3.server.view;

import ser516.project3.constants.ServerConstants;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.EmotionsModel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;

/**
 * Class to create components in emotions panel 
 * and listeners for each component
 * 
 * @author Maitreyi, Janani, Ganesh
 *
 */
public class EmotionsView extends JPanel implements ViewInterface {
	private JSpinner jspinner[];
	private EmotionsModel emotionsModel;
	private static final Font SUBFONT = new Font(ServerConstants.FONT_NAME, Font.BOLD, 14);
	
	/** 
     * Method to set emotion model
	 * @param emotionsModel model object containing required emotions data.
	 * 
	 */
	public EmotionsView(EmotionsModel emotionsModel){
		this.emotionsModel = emotionsModel;
	}

	/** 
     * Method to initialize the emotions view panel
	 * @param subViews object of type ViewInterface
	 * 
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {
		setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING,
				TitledBorder.TOP, SUBFONT, null));
		setBackground(Color.decode(ServerConstants.COLOR_CODE));
		Dimension spinnerDimension = new Dimension(65, 30);
		double current = 0.0;
		double min = 0.0;
		double max = 1.0;
		double step = 0.1;
		jspinner = new JSpinner[6];

		for(EmotionPanel em : EmotionPanel.values()) {
			JLabel interest_label = new JLabel(em.name());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = em.gbc_x;
			gbc.gridy = em.gbc_y;
			add(interest_label, gbc);
			SpinnerModel spinner = new SpinnerNumberModel(current, min, max, step);
			jspinner[em.id] = new JSpinner(spinner);
			jspinner[em.id].setPreferredSize(spinnerDimension);
			jspinner[em.id].setName(em.name);
			GridBagConstraints spinnerGbc = new GridBagConstraints();
			spinnerGbc.gridx = em.spinner_x;
			spinnerGbc.gridy = em.spinner_y;
			add(jspinner[em.id], spinnerGbc);
		}
	}
	
	/** 
     * Enumeration for setting constants for all the emotion options
     * 
	 */
	public enum EmotionPanel{
		Interest(0, 1, 0, 2, 0, ServerConstants.INTEREST), Engagement(1, 3, 0, 4, 0, ServerConstants.ENGAGEMENT),
		Stress(2, 1, 1, 2, 1, ServerConstants.STRESS), Relaxation(3, 3, 1, 4, 1, ServerConstants.RELAXATION),
		Excitement(4, 1, 2, 2, 2, ServerConstants.EXCITEMENT), Focus(5, 3, 2, 4, 2, ServerConstants.FOCUS);
		int id, gbc_x, gbc_y, spinner_x, spinner_y;
		String name;
		EmotionPanel(int id, int gbc_x, int gbc_y, int spinner_x, int spinner_y, String name){
			this.id = id;
			this.gbc_x = gbc_x;
			this.gbc_y = gbc_y;
			this.spinner_x = spinner_x;
			this.spinner_y = spinner_y;
			this.name = name;
		}
	}
	
	/** 
     * Method to listener to every spinner in the emotions panel
     * @param changeListener object of ChangeListener
	 */
	public void addSpinnerListener(ChangeListener changeListener) {
		for(EmotionPanel em : EmotionPanel.values()) {
			jspinner[em.id].addChangeListener(changeListener);
		}
	}
}
