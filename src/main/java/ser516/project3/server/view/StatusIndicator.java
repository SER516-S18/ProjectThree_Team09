package ser516.project3.server.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Server Status indicator Panel - If the server is running it is indicated 
 * by a green blinking circle. If its stopped it is indicated by a red circle.
 * 
 * @author Nelson Tran, Janani
 */
public class StatusIndicator extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final Color GREEN = new Color(0, 255, 0);
	private final Color RED = new Color(255, 0, 0);
	private final int BLINK_INTERVAL = 500;

	private Timer blinkAnimation;
	private Color circleColor;
	private boolean isVisible;

	/**
	 * Method to toggle the visibility of the circle every 500ms
	 */
	public StatusIndicator() {
		this.blinkAnimation = new Timer(BLINK_INTERVAL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isVisible = !isVisible;
				repaint();	
			}
		 });
		this.setBlinking(false);
	}

	/**
	 * Set the blinking indicator. If `blink` is true, then the server is
	 * running and a green blinking circle. If `blink` is false, then the server
	 * is not running and is indicated by a (non-blinking) red circle.
	 * 
	 * @param blink Server status flag
	 */
	public void setBlinking(boolean blink) {
		if (blink) {
			this.blinkAnimation.start();
			this.circleColor = GREEN;
			this.isVisible = false;
		} else {
			this.blinkAnimation.stop();
			this.circleColor = RED;
			this.isVisible = true;
		}
		this.repaint();
	}

	/**
	 * Paints the status circle with relevant colors
	 * 
	 * @param graphics
	 *            Graphics object to change the color the circle
	 */
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		graphics.setColor(circleColor);
		if (isVisible) {
			graphics.fillOval(10, 20, 15, 15);
		}
	}

}
