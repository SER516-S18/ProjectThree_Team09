package ser516.project3.client.view.upperface;

import java.awt.geom.Arc2D;

import ser516.project3.interfaces.FaceElementsInterface;

/**
 * This class contains the properties of left eye brow returns it's instance.
 * Eye brow will be an open arc in all cases.
 * 
 * @author Manish Tandon
 *
 */
@SuppressWarnings("serial")
public class LeftEyeBrow extends Arc2D.Double implements FaceElementsInterface {
	// initial positions
	private static final int X_POSITION = 265;
	private static final int Y_POSITION = 163;
	private static final int WIDTH = 50;
	private static final int HEIGHT = 60;
	private static final int START_ANGLE = 120;
	private static final int EXTENT_ANGLE = -60;
	private static final String RAISE_BROW="raiseBrow";
	private static final String FURROW_BROW="furrowBrow";

	private static LeftEyeBrow instance;

	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the LeftEyeBrow
	 */
	public static LeftEyeBrow getInstance() {

		try {
			if (instance == null) {
				instance = new LeftEyeBrow(X_POSITION, Y_POSITION, WIDTH, HEIGHT, START_ANGLE, EXTENT_ANGLE);
			}
		} catch (Exception e) {
		}
		return instance;

	}

	/**
	 * Initializes left eye brow.
	 */
	public LeftEyeBrow(int xPosition, int yPosition, int width, int height, int startAngle, int extentAngle) {
		super(xPosition, yPosition, width, height, startAngle, extentAngle, OPEN);

	}

	/**
	 * Resets the position of left eye brow to default.
	 */
	@Override
	public void resetPositionToDefault() {
		// Intentionally blank, not used for Brows scenario

	}

	/**
	 * Move the eye brow to a different position.
	 */
	@Override
	public void moveToDifferentPosition() {
		// Intentionally blank, not used for Brows scenario

	}

	/**
	 * Moves the left eye brow based on the double attributes set on the server.Two
	 * scenarios are provided in instruction: raise brow and furrow brow.
	 */
	@Override
	public void moveElement(String instruction, double changeValue) {
		if (instruction.equals(RAISE_BROW)) {
			double newYPosition = Y_POSITION - (changeValue * 10);
			setArc(getX(), newYPosition, WIDTH, HEIGHT, START_ANGLE, EXTENT_ANGLE, OPEN);
		}
		if (instruction.equals(FURROW_BROW)) {
			double newStartAngle = START_ANGLE - (changeValue * 15);
			double newExtentAngle = EXTENT_ANGLE - (changeValue * 6.5);
			setArc(getX(), getY(), getWidth(), getHeight(), newStartAngle, newExtentAngle, OPEN);
		}

	}

	/**
	 * Moves the left eye brow based on the boolean value set on the server.
	 */
	@Override
	public void moveElement(String instruction, boolean changeValue) {
		// intentionally blank, no use currently for this, since eye brow has double
		// attributes on server.
	}

}
