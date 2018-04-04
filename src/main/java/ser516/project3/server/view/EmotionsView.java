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

public class EmotionsView {
	JPanel emotionsPanel;
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	
	EmotionsView(){
		emotionsPanel = new JPanel();;
		
		emotionsPanel.setBorder(new TitledBorder(null, "Emotions", TitledBorder.LEADING, TitledBorder.TOP, SUBFONT, null));
		Dimension spinnerDimension = new Dimension(65, 30);
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
		Interest(1, 1, 3, 1), Engagement(1, 2, 3, 2), Excitement(1, 3, 3, 3), Stress(2, 2, 3, 4), Relaxation(1, 5, 3, 5), Focus(1, 6, 3, 6);
		int gbc_x, gbc_y, spinner_x, spinner_y;
		private EmotionPanel(int gbc_x, int gbc_y, int spinner_x, int spinner_y){
			this.gbc_x = gbc_x;
			this.gbc_y = gbc_y;
			this.spinner_x = spinner_x;
			this.spinner_y = spinner_y;
		}
	}
	
	public JPanel getEmotionsPanel() {
        return emotionsPanel;
    }
}
