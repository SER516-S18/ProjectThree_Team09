package ser516.project3.model;

/**
 * Message is a data model class that encapsulates the data messages sent
 * between the client and the server. The
 * {@link ser516.project3.model.MessageEncoder} and
 * {@link ser516.project3.model.MessageDecoder} marshal and unmarshal instances
 * of this class, respectively.
 */
public class Message {

	private double interval;
	private double timeStamp;
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
	
	// Expression Attributes
	private String upperFace;
	private String eye;
	private Double lowerFaceVal;
	private Double upperFaceVal;
	private Boolean eyeAct;
	private Boolean eyeAutoReset;
	private String lowerFace;
	
	/**
	 * @return the lowerFace Parameter
	 */
	public String getLowerFace() {
		return lowerFace;
	}

	/**
	 * @param lowerFace
	 *            - sets the lowerFace attribute
	 */
	public void setLowerFace(String lowerFace) {
		this.lowerFace = lowerFace;
	}

	/**
	 * @return the upperFace
	 */
	public String getUpperFace() {
		return upperFace;
	}

	/**
	 * @param upperFace
	 *            - sets the upperFace attribute
	 */
	public void setUpperFace(String upperFace) {
		this.upperFace = upperFace;
	}

	/**
	 * @return the eye attribute
	 */
	public String getEye() {
		return eye;
	}

	/**
	 * @param eye
	 *            - sets the eye attribute
	 */
	public void setEye(String eye) {
		this.eye = eye;
	}

	/**
	 * @return the Lower Face Activated Button value
	 */
	public Double getLowerFaceVal() {
		return lowerFaceVal;
	}

	/**
	 * @param lowerFaceVal the lowerFaceVal to set
	 */
	public void setLowerFaceVal(Double lowerFaceVal) {
		this.lowerFaceVal = lowerFaceVal;
	}

	/**
	 * @return the upperFaceVal
	 */
	public Double getUpperFaceVal() {
		return upperFaceVal;
	}

	/**
	 * @param upperFaceVal the upperFaceVal to set
	 */
	public void setUpperFaceVal(Double upperFaceVal) {
		this.upperFaceVal = upperFaceVal;
	}

	/**
	 * @return the eyeAct
	 */
	public Boolean getEyeAct() {
		return eyeAct;
	}

	/**
	 * @param eyeAct the eyeAct to set
	 */
	public void setEyeAct(Boolean eyeAct) {
		System.out.println(eyeAct);
		this.eyeAct = eyeAct;
	}


	/**
	 * @return the eye Auto Reset Value
	 */
	public Boolean getEyeAutoReset() {
		return eyeAutoReset;
	}

	/**
	 * @param eyeAutoReset
	 *            - sets the eye Auto Reset attribute
	 */
	public void setEyeAutoReset(Boolean eyeAutoReset) {
		this.eyeAutoReset = eyeAutoReset;
	}


	
	

	public double getInterval() {
		return interval;
	}

	public void setInterval(double interval) {
		this.interval = interval;
	}

	public double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [timeStamp=");
		builder.append(timeStamp);
		builder.append(", interval=");
		builder.append(interval);
		builder.append(", blink=");
		builder.append(blink);
		builder.append(", rightWink=");
		builder.append(rightWink);
		builder.append(", leftWink=");
		builder.append(leftWink);
		builder.append(", lookingRight=");
		builder.append(lookingRight);
		builder.append(", lookingLeft=");
		builder.append(lookingLeft);
		builder.append(", furrowBrow=");
		builder.append(furrowBrow);
		builder.append(", raiseBrow=");
		builder.append(raiseBrow);
		builder.append(", smile=");
		builder.append(smile);
		builder.append(", clench=");
		builder.append(clench);
		builder.append(", leftSmirk=");
		builder.append(leftSmirk);
		builder.append(", rightSmirk=");
		builder.append(rightSmirk);
		builder.append(", laugh=");
		builder.append(laugh);
		builder.append(", interest=");
		builder.append(interest);
		builder.append(", engagement=");
		builder.append(engagement);
		builder.append(", stress=");
		builder.append(stress);
		builder.append(", relaxation=");
		builder.append(relaxation);
		builder.append(", excitement=");
		builder.append(excitement);
		builder.append(", focus=");
		builder.append(focus);
		builder.append("]");
		return builder.toString();
	}

}