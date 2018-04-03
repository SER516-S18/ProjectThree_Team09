package ser516.project3.utilities;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class NumberTextField extends JTextField {
  private static final long serialVersionUID = 1L;

  public NumberTextField(String input) {
    setText(input);
  }

  @Override
  public void processKeyEvent(KeyEvent keyEvent) {
    if ((keyEvent.getKeyChar() == VK_BACK_SPACE ||
        keyEvent.getKeyChar() == VK_DELETE ||
        keyEvent.getKeyChar() == VK_ENTER ||
        keyEvent.getKeyChar() == VK_LEFT ||
        keyEvent.getKeyChar() == VK_RIGHT) ||
        (getText().length() < 5 && (Character.isDigit(keyEvent.getKeyChar())))) {
      super.processKeyEvent(keyEvent);
    }
    keyEvent.consume();
  }

  public Long getNumber() {
    Long result = null;
    String text = getText();
    if (text != null && !(text.equals(""))) {
      result = Long.valueOf(text);
    }
    return result;
  }
}
