package ser516.project3.client.view.lowerface;

import ser516.project3.client.view.FaceElementsInterface;

import java.awt.geom.Arc2D;

public class Mouth extends Arc2D.Double implements FaceElementsInterface {

    public enum MouthExpression{
        smile, clench, smirkLeft, smirkRight, laugh
    }

    private MouthExpression mouthExpression = MouthExpression.smile;
    private final double xPosition = 160;
    private final double yPosition = 225;
    private final double width = 100;
    private final double height = 70;
    private final double angleStart = 180;
    private final double angleExt = 180;

    public Mouth() {
        super();
        setArc(xPosition, yPosition, width, height, angleStart, angleExt, OPEN);
    }

    public MouthExpression getMouthExpression() {
        return mouthExpression;
    }

    public void setMouthExpression(MouthExpression mouthExpression) {
        this.mouthExpression = mouthExpression;
        moveToDifferentPosition();
    }

    @Override
    public void resetPositionToDefault() {
        setArc(xPosition, yPosition, width, height, angleStart, angleExt, OPEN);
    }

    @Override
    public void moveToDifferentPosition() {
        double angleStart = 180;
        double angleEnd = 180;
        switch (mouthExpression) {
            case smile:
                setArc(xPosition, yPosition, width, height, angleStart, angleEnd, OPEN);
                break;
            case laugh:
                setArc(xPosition, yPosition, width, height, angleStart, angleEnd, CHORD);
                break;
            case clench:
                angleStart = 200;
                angleEnd = 150;
                setArc(xPosition, yPosition, width, height, angleStart, angleEnd, CHORD);
                break;
            case smirkLeft:
                angleEnd = 140;
                setArc(xPosition, yPosition, width, height, angleStart, angleEnd, OPEN);
                break;
            case smirkRight:
                angleStart = 230;
                angleEnd = 130;
                setArc(xPosition, yPosition, width, height, angleStart, angleEnd, OPEN);
                break;
        }

    }


    @Override
    public void moveElement(String instruction, double changeValue) {
        long changedValueRoundOff = Math.round(changeValue);

        // If changed value is greater than 0.5 then the task will be performed else not
        if (changedValueRoundOff == 1) {

            if (instruction.equals("leftSmirk")) {
                setMouthExpression(MouthExpression.smirkLeft);
            } else if (instruction.equals("rightSmirk")) {
                setMouthExpression(MouthExpression.smirkRight);
            } else if (instruction.equals("clench")) {
                setMouthExpression(MouthExpression.clench);
            } else if (instruction.equals("laugh")) {
                setMouthExpression(MouthExpression.laugh);
            } else {
                //reset it to smile
                setMouthExpression(MouthExpression.smile);
            }
        }else if(changedValueRoundOff == 0) {
        	resetPositionToDefault();
        }
    }

    @Override
    public void moveElement(String instruction, boolean changeValue) {

    }
}
