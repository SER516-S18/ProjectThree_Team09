package ser516.project3.server.view;

import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.EmotionsModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import java.awt.*;

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
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	
    // Constructor to initialize emotions panel.
	public EmotionsView(EmotionsModel emotionsModel){
		this.emotionsModel = emotionsModel;
	}

	@Override
	public void initializeView(ViewInterface[] subViews) {
		setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING,
				TitledBorder.TOP, SUBFONT, null));
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

	public enum EmotionPanel{
		Interest(0, 1, 0, 2, 0, "Interest"), Engagement(1, 3, 0, 4, 0, "Engagement"), Stress(2, 1, 1, 2, 1, "Stress"), Relaxation(3, 3, 1, 4, 1, "Relaxation"),
														Excitement(4, 1, 2, 2, 2, "Excitement"), Focus(5, 3, 2, 4, 2, "Focus");
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

	public void addSpinnerListener(ChangeListener changeListener) {
		for(EmotionPanel em : EmotionPanel.values()) {
			jspinner[em.id].addChangeListener(changeListener);
		}
	}
}
