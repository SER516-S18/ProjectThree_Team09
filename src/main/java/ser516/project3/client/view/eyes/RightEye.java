package ser516.project3.client.view.eyes;

import ser516.project3.interfaces.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

/**
 * This class contains the properties of right eye returns it's instance. Eye in
 * this use case can be either a chord or an open arc
 * 
 * @author Vishakha Singal
 *
 */
@SuppressWarnings("serial")
public class RightEye extends Arc2D.Double implements FaceElementsInterface {

	private final double xPosition = 340;
	private final double yPosition = 172;
	private final double width = 30;
	private final double height = 40;

	private MessageModel.ConcreteExpression eyeExpression;

	/**
	 * Initializes right eye to default position
	 */
	public RightEye() {
		super();
		setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
	}

	/**
	 * Resets the position of Right eye to default.
	 */
	@Override
	public void resetPositionToDefault() {
		setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
	}

	/**
	 * Moves the left eye to a position based on eye expression flag.
	 */
	@Override
	public void moveToDifferentPosition() {
		switch (eyeExpression) {
		case blink:
		case rightWink:
			setArc(xPosition, 180, 30, 30, 180, 180, OPEN);
			break;
		case leftWink:
		case lookingLeft:
		case lookingRight:
			this.resetPositionToDefault();
			break;
		}
	}

	/**
	 * Moves the left eye based on the boolean eye attributes set on the server.
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
