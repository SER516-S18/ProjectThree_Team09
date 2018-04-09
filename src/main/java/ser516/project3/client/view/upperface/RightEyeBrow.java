package ser516.project3.client.view.upperface;

import java.awt.geom.Arc2D;

import ser516.project3.client.view.FaceElementsInterface;

public class RightEyeBrow extends Arc2D.Double implements FaceElementsInterface {

	// initial positions
	private static int xPosition = 215;
	private static int yPosition = 163;
	private static int width = 50;
	private static int height = 60;
	private static int startAngle = 120;
	private static int extentAngle = -60;
	private static RightEyeBrow instance;

	/**
	 * Creates a singleton instance . If exists, returns it, else creates it.
	 * 
	 * @return instance of the RightEyeBrow
	 */
	public static RightEyeBrow getInstance() {

		try {
			if (instance == null) {
				instance = new RightEyeBrow(xPosition, yPosition, width, height, startAngle, extentAngle);
			}
		} catch (Exception e) {

		}
		return instance;

	}

	public RightEyeBrow(int xPosition, int yPosition, int width, int height, int startAngle, int extentAngle) {
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
	public void moveElement(String instruction,double changeValue) {
		if(instruction.equals("raiseBrow")) {
			double newYPosition = yPosition - (changeValue*10 );
			setArc(getX(), newYPosition, getWidth(),getHeight(), getAngleStart(), getAngleExtent(), OPEN);
		}
		if(instruction.equals("furrowBrow")) {
			double newStartAngle =startAngle+(changeValue*15);
			setArc(getX(),getY(),getWidth(),getHeight(),newStartAngle,getAngleExtent(),OPEN);
		}
		

	}

	public static int getxPosition() {
		return xPosition;
	}

	public static void setxPosition(int xPosition) {
		RightEyeBrow.xPosition = xPosition;
	}

	public static int getyPosition() {
		return yPosition;
	}

	public static void setyPosition(int yPosition) {
		RightEyeBrow.yPosition = yPosition;
	}

	public double getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		RightEyeBrow.width = width;
	}

	public double getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		RightEyeBrow.height = height;
	}

	public static int getStartAngle() {
		return startAngle;
	}

	public static void setStartAngle(int startAngle) {
		RightEyeBrow.startAngle = startAngle;
	}

	public static int getExtentAngle() {
		return extentAngle;
	}

	public static void setExtentAngle(int extentAngle) {
		RightEyeBrow.extentAngle = extentAngle;
	}

}
