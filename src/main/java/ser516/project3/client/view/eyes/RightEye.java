package ser516.project3.client.view.eyes;

import ser516.project3.client.view.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

public class RightEye extends Arc2D.Double implements FaceElementsInterface {

    private final double xPosition = 340;
    private final double yPosition = 172;
    private final double width = 30;
    private final double height = 40;

    private MessageModel.ConcreteExpression eyeExpression;

    public RightEye() {
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
                setArc(xPosition, 180, 30, 30, 180, 180, OPEN);
                break;
            case leftWink:
            case lookingLeft:
            case lookingRight:
                this.resetPositionToDefault();
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
