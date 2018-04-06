package ser516.project3.server.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import ser516.project3.utilities.InputVerifierNumericals;

/**
 * Class to create timer Panel on server
 * to set time elapsed.
 * @author ravi teja
 *
 */
public class TimerView {
		static JPanel timerPanel;
		private static final String TIME_ELAPSED = "Time Elapsed(ms):  ";
		
		public TimerView() {
			timerPanel = new JPanel();
			timerPanel.setPreferredSize(new Dimension(100,100));
			JLabel timeElapsedLabel = new JLabel(TIME_ELAPSED);
			GridBagConstraints gridBagConstraint = new GridBagConstraints();
			timeElapsedLabel.setOpaque(true);
			
			JTextField timeElapsedInputTextField = new JTextField("1");
			timeElapsedInputTextField.setInputVerifier(new InputVerifierNumericals());
			timeElapsedInputTextField.setBorder(BorderFactory.createLineBorder(Color.black));
			timeElapsedInputTextField.setColumns(10);
			timeElapsedInputTextField.setHorizontalAlignment(SwingConstants.CENTER);

			gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraint.gridx = 0;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.ipady = 10;
			timerPanel.add(timeElapsedLabel, gridBagConstraint);

			gridBagConstraint.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraint.weightx = 1;
			gridBagConstraint.gridx = 1;
			gridBagConstraint.gridy = 0;
			gridBagConstraint.ipady = 10;
			timerPanel.add(timeElapsedInputTextField, gridBagConstraint);
				
		}
		public static JPanel getTimerPanel() {
	        return timerPanel;
	    }
}
