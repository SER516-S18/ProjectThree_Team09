package ser516.project3.client.view.MouthExpressions;

import ser516.project3.client.view.FaceElementsInterface;

import java.awt.geom.Arc2D;

public class Mouth extends Arc2D.Double implements FaceElementsInterface {

    public enum MouthExpression{
        smile, clench, smirk_left, smirk_right, laugh
    }

    private MouthExpression mouthExpression = MouthExpression.smile;


    public MouthExpression getMouthExpression() {
        return mouthExpression;
    }

    public void setMouthExpression(MouthExpression mouthExpression) {
        this.mouthExpression = mouthExpression;
        moveToDifferentPosition();
    }

    public Mouth() {
        super();
        setArc(150, 200, 100, 70, 180, 180, OPEN);
    }

    @Override
    public void resetPositionToDefault() {
        setArc(150, 200, 100, 70, 180, 180, OPEN);
    }

    @Override
    public void moveToDifferentPosition() {
        double angleStart = 180;
        double angleEnd = 180;
        switch (mouthExpression) {
            case smile:
                angleStart = 180;
                angleEnd = 180;
                setArc(150, 200, 100, 70, angleStart, angleEnd, OPEN);
                break;
            case laugh:
                angleStart = 180;
                angleEnd = 180;
                setArc(150, 200, 100, 70, angleStart, angleEnd, CHORD);

                break;
            case clench:
                angleStart = 100;
                angleEnd = 100;
                setArc(150, 200, 100, 70, angleStart, angleEnd, OPEN);
                break;
            case smirk_left:
                angleStart = 180;
                angleEnd = 140;
                setArc(150, 200, 100, 70, angleStart, angleEnd, OPEN);
                break;
            case smirk_right:
                angleStart = 230;
                angleEnd = 130;
                setArc(150, 200, 100, 70, angleStart, angleEnd, OPEN);
                break;
        }

    }
}
