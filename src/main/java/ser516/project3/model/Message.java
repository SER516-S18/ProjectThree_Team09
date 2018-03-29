package ser516.project3.model;

/**
 * Message is a data model class that encapsulates the data messages sent
 * between the client and the server. The {@link ser516.project3.model.MessageEncoder}
 * and {@link ser516.project3.model.MessageDecoder} marshal and unmarshal instances
 * of this class, respectively.
 */
public class Message {

    // Expression Attributes.
    private boolean blink;
    private boolean rightWink;
    private boolean leftWink;
    private boolean lookingRight;
    private boolean lookingLeft;

    private double furrowBrow;
    private double raiseBrow;
    private double smile;
    private double clench;
    private double leftSmirk;
    private double rightSmirk;
    private double laugh;

    // Emotion Attributes.
    private double interest;
    private double engagement;
    private double stress;
    private double relaxation;
    private double excitement;
    private double focus;

    public void setBlink(boolean attribute) {
        this.blink = attribute;
    }

    public boolean getBlink() {
        return this.blink;
    }

    public void setRightWink(boolean attribute) {
        this.rightWink = attribute;
    }

    public boolean getRightWink() {
        return this.rightWink;
    }

    public void setLeftWink(boolean attribute) {
        this.leftWink = attribute;
    }

    public boolean getLeftWink() {
        return this.leftWink;
    }

    public void setLookingRight(boolean attribute) {
        this.lookingRight = attribute;
    }

    public boolean getLookingRight() {
        return this.lookingRight;
    }

    public void setLookingLeft(boolean attribute) {
        this.lookingLeft = attribute;
    }

    public boolean getLookingLeft() {
        return this.lookingLeft;
    }

    public void setFurrowBrow(double attribute) {
        this.furrowBrow = attribute;
    }

    public double getFurrowBrow() {
        return this.furrowBrow;
    }

    public void setRaiseBrow(double attribute) {
        this.raiseBrow = attribute;
    }

    public double getRaiseBrow() {
        return this.raiseBrow;
    }

    public void setSmile(double attribute) {
        this.smile = attribute;
    }

    public double getSmile() {
        return this.smile;
    }

    public void setClench(double attribute) {
        this.clench = attribute;
    }

    public double getClench() {
        return this.clench;
    }

    public void setLeftSmirk(double attribute) {
        this.leftSmirk = attribute;
    }

    public double getLeftSmirk() {
        return this.leftSmirk;
    }

    public void setRightSmirk(double attribute) {
        this.rightSmirk = attribute;
    }

    public double getRightSmirk() {
        return this.rightSmirk;
    }

    public void setLaugh(double attribute) {
        this.laugh = attribute;
    }

    public double getLaugh() {
        return this.laugh;
    }

    public void setInterest(double attribute) {
        this.interest = attribute;
    }

    public double getInterest() {
        return this.interest;
    }

    public void setEngagement(double attribute) {
        this.engagement = attribute;
    }

    public double getEngagement() {
        return this.engagement;
    }

    public void setStress(double attribute) {
        this.stress = attribute;
    }

    public double getStress() {
        return this.stress;
    }

    public void setRelaxation(double attribute) {
        this.relaxation = attribute;
    }

    public double getRelaxation() {
        return this.relaxation;
    }

    public void setExcitement(double attribute) {
        this.excitement = attribute;
    }

    public double getExcitement() {
        return this.excitement;
    }

    public void setFocus(double attribute) {
        this.focus = attribute;
    }

    public double getFocus() {
        return this.focus;
    }

}