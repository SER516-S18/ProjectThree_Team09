package ser516.project3.utilities;

import ser516.project3.model.Message;

public class ServerCommonData {

	private static ServerCommonData instance = null;
	private static Message message;
	private int interval;
	private boolean autoRepeat;
	private boolean serverStarted = false;
	private String lowerFace;
	private String upperFace;
	private String eye;
	private Boolean lowerFaceAct;
	private Boolean upperFaceAct;
	private Boolean eyeAct;
	private Boolean eyeAutoReset;

	protected ServerCommonData() {
		lowerFace = "Smile";
		upperFace = "Raise Brow";
		eye = "Blink";
		lowerFaceAct = false;
		upperFaceAct = false;
		eyeAct = false;
		eyeAutoReset = false;
	}

	public static ServerCommonData getInstance() {
		if (instance == null) {
			instance = new ServerCommonData();
			message = new Message();
		}
		return instance;
	}

	public static Message getMessage() {
		return message;
	}

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

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
	 * @return the upperFace Parameter
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
	 * @return the eye Parameter
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

	/**
	 * @return the Lower Face Activated Button Status
	 */

	public Boolean getLowerFaceAct() {
		return lowerFaceAct;
	}

	/**
	 * @param lowerFaceAct
	 *            - sets the Lower Face Activated Button Status attribute
	 */

	public void setLowerFaceAct(Boolean lowerFaceAct) {
		this.lowerFaceAct = lowerFaceAct;

	}

	/**
	 * @return the Upper Face Activated Button Status
	 */

	public Boolean getUpperFaceAct() {
		return upperFaceAct;
	}

	/**
	 * @param upperFaceAct
	 *            - sets the Upper Face Activated Button Status attribute
	 */

	public void setUpperFaceAct(Boolean upperFaceAct) {
		this.upperFaceAct = upperFaceAct;

	}

	/**
	 * @return the Eye Activated Button Status
	 */

	public Boolean getEyeAct() {
		return eyeAct;
	}

	/**
	 * @param eyeAct
	 *            - sets the Eye Activated Button Status attribute
	 */

	public void setEyeAct(Boolean eyeAct) {
		this.eyeAct = eyeAct;

	}

	/**
	 * @return the autoRepeat
	 */
	public boolean isAutoRepeat() {
		return autoRepeat;
	}

	/**
	 * @param autoRepeat
	 *            the autoRepeat to set
	 */
	public void setAutoRepeat(boolean autoRepeat) {
		this.autoRepeat = autoRepeat;
	}

	/**
	 * @return the serverStarted
	 */
	public boolean isServerStarted() {
		return serverStarted;
	}

	/**
	 * @param serverStarted the serverStarted to set
	 */
	public void setServerStarted(boolean serverStarted) {
		this.serverStarted = serverStarted;
	}

}
