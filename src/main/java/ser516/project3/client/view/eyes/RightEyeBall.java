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
        switch (eyeExpression) {
            case blink:
            case rightWink:
                setArc(xPosition, yPosition, 0, 0, 180, 180, OPEN);
                break;
            case leftWink:
                this.resetPositionToDefault();
                break;
            case lookingLeft:
                setArc(225, yPosition, width, height, 0, 360, CHORD);
                break;
            case lookingRight:
                setArc(240, yPosition, width, height, 0, 360, CHORD);
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
