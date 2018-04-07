package ser516.project3.server.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ser516.project3.utilities.ServerCommonData;

/**
 * Class to create components in emotions panel 
 * and listeners for each component
 * 
 * @author Maitreyi, Janani, Ganesh
 *
 */
public class EmotionsView {
	JPanel emotionsPanel;
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	
    // Constructor to initialize emotions panel.
	public EmotionsView(){
		emotionsPanel = new JPanel();;
		
		GridBagLayout gbl_emotionPanel = new GridBagLayout();
		emotionsPanel.setLayout(gbl_emotionPanel);
		emotionsPanel.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, 
				TitledBorder.TOP, SUBFONT, null));
		Dimension spinnerDimension = new Dimension(80, 30);
		Double current = new Double(0.00);
		Double min = new Double(0.00);
		Double max = new Double(1.00);
		Double step = new Double(0.10);

		for(EmotionPanel em : EmotionPanel.values()) {
			JLabel interest_label = new JLabel(em.name());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = em.gbc_x;
			gbc.gridy = em.gbc_y;
			emotionsPanel.add(interest_label, gbc);
			SpinnerModel spinner = new SpinnerNumberModel(current, min, max, step);
			JSpinner jspinner = new JSpinner(spinner);
			jspinner.setPreferredSize(spinnerDimension);
			GridBagConstraints spinnerGbc = new GridBagConstraints();
			spinnerGbc.gridx = em.spinner_x;
			spinnerGbc.gridy = em.spinner_y;
			emotionsPanel.add(jspinner, spinnerGbc);
			jspinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					ServerCommonData.getInstance().getMessage().setEmotion(em.name(), (Double) jspinner.getValue());
				}
			});
		}
	}
	
	public enum EmotionPanel{
		Interest(1,0,2,0), Engagement(3,0,4,0),
		Excitement(1,1,2,1), Stress(3, 1,4,1), 
		Relaxation(1,2,2,2), Focus(3,2,4,2);
		int gbc_x, gbc_y, spinner_x, spinner_y;
		private EmotionPanel(int gbc_x, int gbc_y, int spinner_x, int spinner_y){
			this.gbc_x = gbc_x;
			this.gbc_y = gbc_y;
			this.spinner_x = spinner_x;
			this.spinner_y = spinner_y;
		}
	}
	
	// Method that returns the panel created
	public JPanel getEmotionsPanel() {
        return emotionsPanel;
    }
}
