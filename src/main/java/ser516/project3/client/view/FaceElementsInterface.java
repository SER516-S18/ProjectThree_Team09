package ser516.project3.client.view;

import java.awt.Shape;

public interface FaceElementsInterface extends Shape {
	void resetPositionToDefault();
	void moveToDifferentPosition();
	void moveElement(String instruction,double value);
}
