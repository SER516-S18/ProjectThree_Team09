package ser516.project3.server.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.TimerModel;

/**
 * Class to create timer Panel on server
 * to set time elapsed.
 * @author ravi teja, Adhiraj Tikku
 *
 */
public class TimerView extends JPanel implements ViewInterface{
	private JTextField timeElapsedInputTextField;
	private TimerModel timerModel;

	private static final String TIME_ELAPSED = "Time Elapsed(ms):  ";

	public TimerView(TimerModel timerModel) {
		this.timerModel = timerModel;
	}

	@Override
	public void initializeView(ViewInterface[] subViews) {
		setPreferredSize(new Dimension(100,100));

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		createTimeElapsedLabel(gridBagConstraints);
		createTimeElapsedInputTextField(gridBagConstraints);
	}

	private void createTimeElapsedLabel(GridBagConstraints gridBagConstraints) {
		JLabel timeElapsedLabel = new JLabel(TIME_ELAPSED);
		timeElapsedLabel.setOpaque(true);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipady = 10;
		add(timeElapsedLabel, gridBagConstraints);
	}

	private void createTimeElapsedInputTextField(GridBagConstraints gridBagConstraints) {
		timeElapsedInputTextField = new JTextField("1");
		timeElapsedInputTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		timeElapsedInputTextField.setColumns(10);
		timeElapsedInputTextField.setHorizontalAlignment(SwingConstants.CENTER);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipady = 10;
		add(timeElapsedInputTextField, gridBagConstraints);
	}

	public void updateTimeStamp() {
		timeElapsedInputTextField.setText("" + timerModel.getTimeElapsed());
	}
}
