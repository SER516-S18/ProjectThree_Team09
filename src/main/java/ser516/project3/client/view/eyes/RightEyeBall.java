package ser516.project3.client.view.eyes;

import ser516.project3.client.view.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

public class RightEyeBall extends Arc2D.Double implements FaceElementsInterface {

    private final double xPosition = 232;
    private final double yPosition = 182;
    private final double width = 15;
    private final double height = 20;

    private MessageModel.ConcreteExpression eyeExpression;

    public RightEyeBall() {
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
