package ser516.project3.model;

/**
 * Message is a data model class that encapsulates the data messages sent
 * between the client and the server. The {@link ser516.project3.model.MessageEncoder}
 * and {@link ser516.project3.model.MessageDecoder} marshal and unmarshal instances
 * of this class, respectively.
 */
public class Message {

    // Expressive Attributes.
    private boolean lookingRight;
    private boolean lookingLeft;
    private boolean lookingDown;
    private boolean lookingUp;
    private boolean eyebrowRaise;
    private boolean rightWink;
    private boolean leftWink;
    private boolean blink;
    private boolean eyesOpen;
    private boolean smile;
    private boolean clench;

    // Affective Attributes.
    private double meditation;
    private double frustration;
    private double engagementBoredom;
    private double excitementShortTerm;
    private double excitementLongTerm;

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

    public void setLookingDown(boolean attribute) {
        this.lookingDown = attribute;
    }

    public boolean getLookingDown() {
        return this.lookingDown;
    }

    public void setLookingUp(boolean attribute) {
        this.lookingUp = attribute;
    }

    public boolean getLookingUp() {
        return this.lookingUp;
    }

    public void setEyebrowRaise(boolean attribute) {
        this.eyebrowRaise = attribute;
    }

    public boolean getEyebrowRaise() {
        return this.eyebrowRaise;
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

    public void setBlink(boolean attribute) {
        this.blink = attribute;
    }

    public boolean getBlink() {
        return this.blink;
    }

    public void setEyesOpen(boolean attribute) {
        this.eyesOpen = attribute;
    }

    public boolean getEyesOpen() {
        return this.eyesOpen;
    }

    public void setSmile(boolean attribute) {
        this.smile = attribute;
    }

    public boolean getSmile() {
        return this.smile;
    }

    public void setClench(boolean attribute) {
        this.clench = attribute;
    }

    public boolean getClench() {
        return this.clench;
    }

    public void setMeditation(double attribute) {
        this.meditation = attribute;
    }

    public double getMeditation() {
        return this.meditation;
    }

    public void setFrustration(double attribute) {
        this.frustration = attribute;
    }

    public double getFrustration() {
        return this.frustration;
    }

    public void setEngagementBoredom(double attribute) {
        this.engagementBoredom = attribute;
    }

    public double getEngagementBoredom() {
        return this.engagementBoredom;
    }

    public void setExcitementShortTerm(double attribute) {
        this.excitementShortTerm = attribute;
    }

    public double getExcitementShortTerm() {
        return this.excitementShortTerm;
    }

    public void setExcitementLongTerm(double attribute) {
        this.excitementLongTerm = attribute;
    }

    public double getExcitementLongTerm() {
        return this.excitementLongTerm;
    }

}