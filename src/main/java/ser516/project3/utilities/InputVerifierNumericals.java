package ser516.project3.utilities;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 * Added an custom input verifier class to validate the numerical fields
 * @author vsriva12
 *
 */
public class InputVerifierNumericals extends InputVerifier {

	@Override
	public boolean verify(JComponent input) {
		String text = (String)((JTextComponent) input).getText();
		try {
			Integer.parseInt(text);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must input a number for this field!");
			return false;
		}
		
		if(text.length()>5) {
			JOptionPane.showMessageDialog(null, "Interval time should not be more than 5 digits");
			return false;
		}
		
		return true;

	}

}
