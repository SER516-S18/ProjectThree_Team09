package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

public class ExpressionsModel implements ModelInterface {
  private String lowerFaceItem;
  private String upperFaceItem;
  private String eyeItem;
  private double upperFaceValue;
  private double lowerFaceValue;
  private boolean eyeValue;
  private boolean eyeCheckBoxChecked;

  public ExpressionsModel() {
    lowerFaceItem = "Smile";
    upperFaceItem = "Raise Brow";
    eyeItem = "Blink";
    upperFaceValue = 0;
    lowerFaceValue = 0;
    eyeValue = false;
    eyeCheckBoxChecked = false;
  }

  public String getUpperFaceItem() {
    return upperFaceItem;
  }

  public void setUpperFaceItem(String upperFaceItem) {
    this.upperFaceItem = upperFaceItem;
  }

  public String getLowerFaceItem() {
    return lowerFaceItem;
  }

  public void setLowerFaceItem(String lowerFaceItem) {
    this.lowerFaceItem = lowerFaceItem;
  }

  public String getEyeItem() {
    return eyeItem;
  }

  public void setEyeItem(String eyeItem) {
    this.eyeItem = eyeItem;
  }

  public double getUpperFaceValue() {
    return upperFaceValue;
  }

  public void setUpperFaceValue(double upperFaceValue) {
    this.upperFaceValue = upperFaceValue;
  }

  public double getLowerFaceValue() {
    return lowerFaceValue;
  }

  public void setLowerFaceValue(double lowerFaceValue) {
    this.lowerFaceValue = lowerFaceValue;
  }

  public boolean getEyeValue() {
    return eyeValue;
  }

  public void setEyeValue(boolean eyeValue) {
    this.eyeValue = eyeValue;
  }

  public boolean isEyeCheckBoxChecked() {
    return eyeCheckBoxChecked;
  }

  public void setEyeCheckBoxChecked(boolean eyeCheckBoxChecked) {
    this.eyeCheckBoxChecked = eyeCheckBoxChecked;
  }
}
