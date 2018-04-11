package ser516.project3.client.view.eyes;

import ser516.project3.interfaces.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

/**
 * This class contains the properties of right eye ball returns it's instance.
 * Eye in this use case can be either a chord or an open arc
 *
 * @author Vishakha Singal
 */
@SuppressWarnings("serial")
public class RightEyeBall extends Arc2D.Double implements FaceElementsInterface {

    private final double xPosition = 347;
    private final double yPosition = 182;
    private final double width = 15;
    private final double height = 20;

    private MessageModel.ConcreteExpression eyeExpression;

    /**
     * Initializes right eye ball.
     */
    public RightEyeBall() {
        super();
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    /**
     * Resets the position of Right eye ball to default.
     */
    @Override
    public void resetPositionToDefault() {
        setArc(xPosition, yPosition, width, height, 0, 360, CHORD);
    }

    /**
     * Moves the eye ball to different positions based on the eye expression flag
     */
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
                setArc(340, yPosition, width, height, 0, 360, CHORD);
                break;
            case lookingRight:
                setArc(355, yPosition, width, height, 0, 360, CHORD);
                break;
        }
    }

    /**
     * Moves the right eye ball based on the boolean eye attributes set on the
     * server.Sets the eye expression flag
     */
    @Override
    public void moveElement(String instruction, boolean changeValue) {
        if (changeValue) {
            eyeExpression = MessageModel.ConcreteExpression.valueOf(instruction);
            moveToDifferentPosition();
        } else {
            this.resetPositionToDefault();
        }
    }

    /**
     * Moves the right eye based on the double value set on the server.
     */
    @Override
    public void moveElement(String instruction, double changeValue) {
        // intentionally blank, no use currently for this, since eye has boolean
        // attributes on server.
    }
}
