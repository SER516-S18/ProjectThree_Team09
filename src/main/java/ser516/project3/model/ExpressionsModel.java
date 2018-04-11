package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Class to store the data for the expressions tab
 *
 * @author Adhiraj Tikku
 */
public class ExpressionsModel implements ModelInterface {
    private String lowerFaceItem;
    private String upperFaceItem;
    private String eyeItem;
    private double upperFaceValue;
    private double lowerFaceValue;
    private boolean eyeValue;
    private boolean eyeCheckBoxChecked;
    private boolean isTabSelected;

    /**
     * Constructor to initialize the values to initial values
     */
    public ExpressionsModel() {
        lowerFaceItem = "Smile";
        upperFaceItem = "Raise Brow";
        eyeItem = "Blink";
        upperFaceValue = 0;
        lowerFaceValue = 0;
        eyeValue = false;
        eyeCheckBoxChecked = false;
    }

	/**
	 * @return the lowerFaceItem
	 */
	public String getLowerFaceItem() {
		return lowerFaceItem;
	}

	/**
	 * @param lowerFaceItem the lowerFaceItem to set
	 */
	public void setLowerFaceItem(String lowerFaceItem) {
		this.lowerFaceItem = lowerFaceItem;
	}

	/**
	 * @return the upperFaceItem
	 */
	public String getUpperFaceItem() {
		return upperFaceItem;
	}

	/**
	 * @param upperFaceItem the upperFaceItem to set
	 */
	public void setUpperFaceItem(String upperFaceItem) {
		this.upperFaceItem = upperFaceItem;
	}

	/**
	 * @return the eyeItem
	 */
	public String getEyeItem() {
		return eyeItem;
	}

	/**
	 * @param eyeItem the eyeItem to set
	 */
	public void setEyeItem(String eyeItem) {
		this.eyeItem = eyeItem;
	}

	/**
	 * @return the upperFaceValue
	 */
	public double getUpperFaceValue() {
		return upperFaceValue;
	}

	/**
	 * @param upperFaceValue the upperFaceValue to set
	 */
	public void setUpperFaceValue(double upperFaceValue) {
		this.upperFaceValue = upperFaceValue;
	}

	/**
	 * @return the lowerFaceValue
	 */
	public double getLowerFaceValue() {
		return lowerFaceValue;
	}

	/**
	 * @param lowerFaceValue the lowerFaceValue to set
	 */
	public void setLowerFaceValue(double lowerFaceValue) {
		this.lowerFaceValue = lowerFaceValue;
	}

	/**
	 * @return the eyeValue
	 */
	public boolean isEyeValue() {
		return eyeValue;
	}

	/**
	 * @param eyeValue the eyeValue to set
	 */
	public void setEyeValue(boolean eyeValue) {
		this.eyeValue = eyeValue;
	}

	/**
	 * @return the eyeCheckBoxChecked
	 */
	public boolean isEyeCheckBoxChecked() {
		return eyeCheckBoxChecked;
	}

	/**
	 * @param eyeCheckBoxChecked the eyeCheckBoxChecked to set
	 */
	public void setEyeCheckBoxChecked(boolean eyeCheckBoxChecked) {
		this.eyeCheckBoxChecked = eyeCheckBoxChecked;
	}

	/**
	 * @return the isTabSelected
	 */
	public boolean isTabSelected() {
		return isTabSelected;
	}

	/**
	 * @param isTabSelected the isTabSelected to set
	 */
	public void setTabSelected(boolean isTabSelected) {
		this.isTabSelected = isTabSelected;
	}

    
}
