package ser516.project3.client.view.upperface;

import java.awt.geom.Arc2D;

import ser516.project3.client.view.FaceElementsInterface;

public class LeftEyeBrow extends Arc2D.Double implements FaceElementsInterface {
	// initial positions
	private static int xPosition = 150;
	private static int yPosition = 163;
	private static int width = 50;
	private static int height = 60;
	private static int startAngle = 120;
	private static int extentAngle = -60;

	private static LeftEyeBrow instance;

	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the LeftEyeBrow
	 */
	public static LeftEyeBrow getInstance() {

		try {
			if (instance == null) {
				instance = new LeftEyeBrow(xPosition, yPosition, width, height, startAngle, extentAngle);
			}
		} catch (Exception e) {
		}
		return instance;

	}

	public LeftEyeBrow(int xPosition, int yPosition, int width, int height, int startAngle, int extentAngle) {
		super(xPosition, yPosition, width, height, startAngle, extentAngle, OPEN);

	}

	@Override
	public void resetPositionToDefault() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveToDifferentPosition() {
		// Intentionally blank, not used for Brows scenario

	}

	@Override
	public void moveElement(String instruction, double changeValue) {
		if (instruction.equals("raiseBrow")) {
			double newYPosition = yPosition - (changeValue * 10);
			setArc(getX(), newYPosition, width, height, startAngle, extentAngle, OPEN);
		}
		if (instruction.equals("furrowBrow")) {
			double newStartAngle = startAngle - (changeValue * 15);
			double newExtentAngle = extentAngle - (changeValue * 6.5);
			setArc(getX(), getY(), getWidth(), getHeight(), newStartAngle, newExtentAngle, OPEN);
		}

	}

	public static int getxPosition() {
		return xPosition;
	}

	public static void setxPosition(int xPosition) {
		LeftEyeBrow.xPosition = xPosition;
	}

	public static int getyPosition() {
		return yPosition;
	}

	public static void setyPosition(int yPosition) {
		LeftEyeBrow.yPosition = yPosition;
	}

	public double getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		LeftEyeBrow.width = width;
	}

	public double getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		LeftEyeBrow.height = height;
	}

	public static int getStartAngle() {
		return startAngle;
	}

	public static void setStartAngle(int startAngle) {
		LeftEyeBrow.startAngle = startAngle;
	}

	public static int getExtentAngle() {
		return extentAngle;
	}

	public static void setExtentAngle(int extentAngle) {
		LeftEyeBrow.extentAngle = extentAngle;
	}

}
