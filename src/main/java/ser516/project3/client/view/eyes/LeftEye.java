package ser516.project3.client.view.eyes;

import ser516.project3.interfaces.FaceElementsInterface;
import ser516.project3.model.MessageModel;

import java.awt.geom.Arc2D;

/**
 * This class contains the properties of left eye returns it's instance. Eye in
 * this use case can be either a chord or an open arc
 *
 * @author Vishakha Singal
 */
@SuppressWarnings("serial")
public class LeftEye extends Arc2D.Double implements FaceElementsInterface {

    private final double X_POSTION = 275;
    private final double Y_POSTION = 172;
    private final double WIDTH = 30;
    private final double HEIGHT = 40;

    private MessageModel.ConcreteExpression eyeExpression;

    /**
     * Initializes left eye to default position
     */
    public LeftEye() {
        super();
        setArc(X_POSTION, Y_POSTION, WIDTH, HEIGHT, 0, 360, CHORD);
    }

    /**
     * Resets the position of Left eye to default.
     */
    @Override
    public void resetPositionToDefault() {
        setArc(X_POSTION, Y_POSTION, WIDTH, HEIGHT, 0, 360, CHORD);
    }

    /**
     * Moves the left eye to a position based on eye expression flag.
     */
    @Override
    public void moveToDifferentPosition() {
        switch (eyeExpression) {
            case blink:
            case leftWink:
                setArc(X_POSTION, 180, 30, 30, 180, 180, OPEN);
                break;
            case rightWink:
            case lookingLeft:
            case lookingRight:
                this.resetPositionToDefault();
                break;
        }
    }

    /**
     * Moves the left eye based on the boolean eye attributes  set on the server.
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
     * Moves the left eye based on the double value set on the server.
     */
    @Override
    public void moveElement(String instruction, double changeValue) {
        // intentionally blank, no use currently for this, since eye has boolean
        // attributes on server.
    }
}
