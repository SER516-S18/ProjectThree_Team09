package ser516.project3.client.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ser516.project3.client.view.eyes.LeftEye;
import ser516.project3.client.view.eyes.LeftEyeBall;
import ser516.project3.client.view.eyes.RightEye;
import ser516.project3.client.view.eyes.RightEyeBall;
import ser516.project3.client.view.lowerface.Mouth;
import ser516.project3.client.view.upperface.LeftEyeBrow;
import ser516.project3.client.view.upperface.RightEyeBrow;
import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.FaceModel;
import ser516.project3.model.MessageModel;

/**
 * The FaceView class creates the face panel on the client UI
 * 
 * @author Varun Srivastava , Manish Tandon , Vishakha Singal, Adhiraj Tikku
 *
 */
@SuppressWarnings("serial")
public class FaceView extends JPanel implements ViewInterface {
	private FaceModel faceModel;

    private BufferedImage faceBufferedImage = null;
    private BufferedImage noseBufferedImage = null;
    private boolean isSelected;
<<<<<<< HEAD

	
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
		File faceFile = new File(faceLayoutPath);
        File noseFile = new File(nosePath);
		try {
			this.faceBufferedImage = ImageIO.read(faceFile);
			this.noseBufferedImage = ImageIO.read(noseFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static FaceView instance;
=======
>>>>>>> b164e15ccc3302646aa0743ff6f366816f875ba1
	private Mouth mouthView;
	private LeftEye leftEye;
	private RightEye rightEye;
	private RightEyeBall rightEyeBall;
	private LeftEyeBall leftEyeBall;

	private static Color faceColor = new Color(255, 223, 135);
	private static int width = 300;
	private static int height = 300;
	private static final String faceLayoutPath = "images/FaceImage.png";
	private static final String nosePath = "images/nose.png";

	public FaceView(FaceModel faceModel) {
		this.faceModel = faceModel;
	}
<<<<<<< HEAD
	
	
=======

	/**
	 * Overridden method , that is used for painting graphic on the Jpanel.
	 */
>>>>>>> b164e15ccc3302646aa0743ff6f366816f875ba1
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(new Color(96, 85, 46));

		Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(this.faceBufferedImage, 160,40,null);
        graphics2D.drawImage(this.noseBufferedImage, 305, 210, null);

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

<<<<<<< HEAD
	
=======
	/**
	 * This method is called by FaceObserver, to update elements as per the current
	 * data packet sent from server.
	 *
	 * @param messageBean
	 */
>>>>>>> b164e15ccc3302646aa0743ff6f366816f875ba1
	public void updateFaceElements(MessageModel messageBean) {
	    if (isSelected) {
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
	}

	public void setColor(Color newColor) {

		faceColor = newColor;
	}

	@Override
	public void initializeView(ViewInterface[] subViews) {
		setPreferredSize(new Dimension(width, height));
		mouthView = new Mouth();
		leftEye = new LeftEye();
		rightEye = new RightEye();
		leftEyeBall = new LeftEyeBall();
		rightEyeBall = new RightEyeBall();
		File faceFile = new File(faceLayoutPath);
		File noseFile = new File(nosePath);
		try {
			faceBufferedImage = ImageIO.read(faceFile);
			noseBufferedImage = ImageIO.read(noseFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}