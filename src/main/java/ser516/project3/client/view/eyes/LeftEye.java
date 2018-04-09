package ser516.project3.client.view.eyes;

import ser516.project3.client.view.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

public class LeftEye extends Arc2D.Double implements FaceElementsInterface {

    private final double xPosition = 160;
    private final double yPosition = 172;
    private final double width = 30;
    private final double height = 40;

    private MessageModel.ConcreteExpression eyeExpression;

    public LeftEye() {
        super();
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    @Override
    public void resetPositionToDefault() {
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    @Override
    public void moveToDifferentPosition() {

    }


    @Override
    public void moveElement(String instruction, double changeValue) {

    }
}
