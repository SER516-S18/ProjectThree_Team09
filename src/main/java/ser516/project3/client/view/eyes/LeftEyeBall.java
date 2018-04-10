package ser516.project3.client.view.eyes;

import ser516.project3.client.view.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

public class LeftEyeBall extends Arc2D.Double implements FaceElementsInterface {

    private final double xPosition = 282;
    private final double yPosition = 182;
    private final double width = 15;
    private final double height = 20;

    private MessageModel.ConcreteExpression eyeExpression;

    public LeftEyeBall() {
        super();
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    @Override
    public void resetPositionToDefault() {
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    @Override
    public void moveToDifferentPosition() {
        switch (eyeExpression) {
            case blink:
            case leftWink:
                setArc(xPosition, yPosition, 0, 0, 180, 180, OPEN);
                break;
            case rightWink:
                this.resetPositionToDefault();
                break;
            case lookingLeft:
                setArc(275, yPosition, width, height, 0, 360, CHORD);
                break;
            case lookingRight:
                setArc(290, yPosition, width, height, 0, 360, CHORD);
                break;
        }
    }

    @Override
    public void moveElement(String instruction, boolean changeValue) {
        if (changeValue) {
            eyeExpression = MessageModel.ConcreteExpression.valueOf(instruction);
            moveToDifferentPosition();
        } else {
            this.resetPositionToDefault();
        }
    }

    @Override
    public void moveElement(String instruction, double changeValue) {

    }
}
