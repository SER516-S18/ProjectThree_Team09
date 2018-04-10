package ser516.project3.client.view;

import java.awt.Shape;

/**
 * 
 * Contract definition for all face elements
 * 
 * @author Manish Tandon
 *
 */
public interface FaceElementsInterface extends Shape {
	/**
	 * Resets to default position of the face element
	 */
	void resetPositionToDefault();

	/**
	 * Move to a different position as provided by the base class that is implementing this interface
	 */
	void moveToDifferentPosition();

	/**
	 * Moves Face element based on a instruction(can be smile, laugh etc.) and based
	 * on change value (double) provided by server
	 * 
	 * @param instruction
	 * @param changeValue
	 */
	void moveElement(String instruction, double changeValue);

	/**
	 * Moves Face element based on a instruction(can be smile, laugh etc.) and based
	 * on change value (boolean) provided by server
	 * 
	 * @param instruction
	 * @param changeValue
	 */
	void moveElement(String instruction, boolean changeValue);
}
