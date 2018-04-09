package ser516.project3.client.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ser516.project3.client.view.eyes.LeftEye;
import ser516.project3.client.view.eyes.LeftEyeBall;
import ser516.project3.client.view.eyes.RightEye;
import ser516.project3.client.view.eyes.RightEyeBall;
import ser516.project3.client.view.lowerface.Mouth;
import ser516.project3.client.view.upperface.LeftEyeBrow;
import ser516.project3.client.view.upperface.RightEyeBrow;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.MessageModel;

/**
 * The FaceView class creates the face panel on the client UI
 * 
 * @author vsriva12
 *
 */
@SuppressWarnings("serial")
public class FaceView extends JPanel implements ViewInterface {
	private static Color faceColor = new Color(255, 223, 135);
	private static int width = 300;
	private static int height = 300;

	public FaceView(int width, int height, Color faceColor) {
		this.width = width;
		this.height = height;
		this.faceColor = faceColor;
		setPreferredSize(new Dimension(width, height));
		this.mouthView = new Mouth();
		this.leftEye = new LeftEye();
		this.rightEye = new RightEye();
		this.leftEyeBall = new LeftEyeBall();
		this.rightEyeBall = new RightEyeBall();
	}

	private static FaceView instance;
	private Mouth mouthView;
	private LeftEye leftEye;
	private RightEye rightEye;
	private RightEyeBall rightEyeBall;
	private LeftEyeBall leftEyeBall;

	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the LeftEyeBrow
	 */
	public static FaceView getInstance() {

		try {
			if (instance == null) {
				instance = new FaceView(width, height, faceColor);
			}
		} catch (Exception e) {
		}
		return instance;

	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(new Color(96, 85, 46));
		graphics.drawOval(110, 110, width - 100, height - 80);
		graphics.drawPolygon(new int[] { 207, 197, 217 }, new int[] { 205, 245, 245 }, 3);

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(4));

		graphics2D.draw(LeftEyeBrow.getInstance());
		graphics2D.draw(RightEyeBrow.getInstance());
		graphics2D.setStroke(new BasicStroke(3));

		graphics2D.draw(leftEye);
		graphics2D.draw(rightEye);
		graphics2D.fill(leftEyeBall);
		graphics2D.fill(rightEyeBall);

		graphics2D.setColor(Color.red);
		graphics2D.draw(mouthView);

	}

	public void updateFaceElements(MessageModel messageBean) {
		LeftEyeBrow.getInstance().moveElement("raiseBrow", messageBean.getAbstractExpression("raiseBrow"));
		RightEyeBrow.getInstance().moveElement("raiseBrow", messageBean.getAbstractExpression("raiseBrow"));
		LeftEyeBrow.getInstance().moveElement("furrowBrow", messageBean.getAbstractExpression("furrowBrow"));
		RightEyeBrow.getInstance().moveElement("furrowBrow", messageBean.getAbstractExpression("furrowBrow"));
		String lowerFaceExpression = messageBean.getSelectionFlag("lowerFace");
		mouthView.moveElement(lowerFaceExpression, messageBean.getAbstractExpression(lowerFaceExpression));

		String eyeExpression = messageBean.getSelectionFlag("eye");
		leftEye.moveElement(eyeExpression, messageBean.getConcreteExpression(eyeExpression));
		rightEye.moveElement(eyeExpression, messageBean.getConcreteExpression(eyeExpression));
		leftEyeBall.moveElement(eyeExpression, messageBean.getConcreteExpression(eyeExpression));
		rightEyeBall.moveElement(eyeExpression, messageBean.getConcreteExpression(eyeExpression));

		Graphics2D graphics2d = (Graphics2D) getGraphics();
		paintComponent(graphics2d);
	}

	public void setColor(Color newColor) {

		faceColor = newColor;
	}

	@Override
	public void initializeView(ViewInterface[] subViews) {

	}

}