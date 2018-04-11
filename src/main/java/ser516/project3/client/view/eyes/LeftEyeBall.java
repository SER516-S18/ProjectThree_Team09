package ser516.project3.client.view.eyes;

import ser516.project3.interfaces.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

/**
 * This class contains the properties of left eye ball returns it's instance.
 * Eye in this use case can be either a chord or an open arc
 * 
 * @author Vishakha Singal
 *
 */
@SuppressWarnings("serial")
public class LeftEyeBall extends Arc2D.Double implements FaceElementsInterface {

	private final double X_POSITION = 282;
	private final double Y_POSITION = 182;
	private final double WIDTH = 15;
	private final double HEIGHT = 20;

	private MessageModel.ConcreteExpression eyeExpression;

	/**
	 * Initializes left eye ball.
	 */
	public LeftEyeBall() {
		super();
		setArc(X_POSITION, Y_POSITION, WIDTH, HEIGHT, 0, 360, CHORD);
	}

	/**
	 * Resets the position of Left eye ball to default.
	 */
	@Override
	public void resetPositionToDefault() {
		setArc(X_POSITION, Y_POSITION, WIDTH, HEIGHT, 0, 360, CHORD);
	}

	/**
	 * Moves the eye ball to different positions based on the eye expression flag
	 */
	@Override
	public void moveToDifferentPosition() {
		switch (eyeExpression) {
		case blink:
		case leftWink:
			setArc(X_POSITION, Y_POSITION, 0, 0, 180, 180, OPEN);
			break;
		case rightWink:
			this.resetPositionToDefault();
			break;
		case lookingLeft:
			setArc(275, Y_POSITION, WIDTH, HEIGHT, 0, 360, CHORD);
			break;
		case lookingRight:
			setArc(290, Y_POSITION, WIDTH, HEIGHT, 0, 360, CHORD);
			break;
		}
	}

	/**
	 * Moves the left eye ball based on the boolean eye attributes set on the
	 * server.Sets the eye expression flag
	 */
	@Override
	public void moveElement(String instruction, boolean changeValue) {
		if (changeValue) {
			eyeExpression = MessageModel.ConcreteExpression.valueOf(instruction);
			moveToDifferentPosition();
		} else {
			this.resetPositionToDefault();
		}
	}

	/**
	 * Moves the left eye based on the double value set on the server.
	 */

	@Override
	public void moveElement(String instruction, double changeValue) {
		// intentionally blank, no use currently for this, since eye has boolean
		// attributes on server.
	}
}
