package ser516.project3.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FaceView extends JPanel {

	private Color faceColor;
	private int width;
	private int height;

	FaceView(int width, int height, Color faceColor) {
		this.width = width;
		this.height = height;
		this.faceColor = faceColor;
		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics graphics) {

		super.paintComponent(graphics);

		graphics.setColor(faceColor);
		graphics.fillOval(100, 100, width - 100, height - 80);

		graphics.setColor(new Color(96, 85, 46));
		graphics.drawOval(100, 100, width - 100, height - 80);

		graphics.setColor(Color.BLACK);
		graphics.fillOval(150,150,30,50);
		graphics.drawArc(150, 130, 30, 30, 0, 180);

		graphics.setColor(Color.BLACK);
		graphics.fillOval(210, 150, 30, 50);
		graphics.drawArc(210, 130, 30, 30, 0, 180);

		graphics.setColor(new Color(249, 47, 84));
//		graphics.fillArc(150, 200, 100, 70, 0, 180);
		graphics.drawArc(150, 200, 100, 70, 180, 180);

	}

	public void setColor(Color newColor) {

		faceColor = newColor;
	}

}