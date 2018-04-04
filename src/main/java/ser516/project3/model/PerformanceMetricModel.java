package ser516.project3.model;

import java.awt.*;

/**
 * PerformanceMetricModel is a class to represent the data associated with emotions
 * and the display length of the x-axis depicting these emotions.
 *
 * @author Adhiraj Tikku
 * @version 1.0
 * @since 2018-04-01
 *
 */
public class PerformanceMetricModel {
  private Color interestColor;
  private Color engagementColor;
  private Color stressColor;
  private Color relaxationColor;
  private Color excitementColor;
  private Color focusColor;

  private int displayLength;

  public PerformanceMetricModel() {
    interestColor = Color.decode("#F20090");
    engagementColor = Color.decode("#02AC9F");
    stressColor = Color.decode("#90C340");
    relaxationColor = Color.decode("#02ADFF");
    excitementColor = Color.decode("#F86C1C");
    focusColor = Color.decode("#ADAAFF");
    displayLength = 30;
  }

  /**
   * Sets the color for interest emotion.
   *
   * @param interestColor color for interest emotion
   */
  public void setInterestColor(Color interestColor) {
    this.interestColor = interestColor;
  }

  /**
   * Gets the color for interest emotion.
   *
   * @return color for interest emotion
   */
  public Color getInterestColor() {
    return interestColor;
  }

  /**
   * Sets the color for engagement emotion.
   *
   * @param engagementColor color for engagement emotion
   */
  public void setEngagementColor(Color engagementColor) {
    this.engagementColor = engagementColor;
  }

  /**
   * Gets the color for engagement emotion.
   *
   * @return color for engagement emotion
   */
  public Color getEngagementColor() {
    return engagementColor;
  }

  /**
   * Sets the color for stress emotion.
   *
   * @param stressColor color for stress emotion
   */
  public void setStressColor(Color stressColor) {
    this.stressColor = stressColor;
  }

  /**
   * Gets the color for stress emotion.
   *
   * @return color for stress emotion
   */
  public Color getStressColor() {
    return stressColor;
  }

  /**
   * Sets the color for relaxation emotion.
   *
   * @param relaxationColor color for relaxation emotion
   */
  public void setRelaxationColor(Color relaxationColor) {
    this.relaxationColor = relaxationColor;
  }

  /**
   * Gets the color for relaxation emotion.
   *
   * @return color for relaxation emotion
   */
  public Color getRelaxationColor() {
    return relaxationColor;
  }

  /**
   * Sets the color for excitement emotion.
   *
   * @param excitementColor color for excitement emotion
   */
  public void setExcitementColor(Color excitementColor) {
    this.excitementColor = excitementColor;
  }

  /**
   * Gets the color for excitement emotion.
   *
   * @return color for excitement emotion
   */
  public Color getExcitementColor() {
    return excitementColor;
  }

  /**
   * Sets the color for focus emotion.
   *
   * @param focusColor color for focus emotion
   */
  public void setFocusColor(Color focusColor) {
    this.focusColor = focusColor;
  }

  /**
   * Gets the color for focus emotion.
   *
   * @return color for focus emotion
   */
  public Color getFocusColor() {
    return focusColor;
  }

  /**
   * Sets the display length for the x axis.
   *
   * @param displayLength the display length for the x axis
   */
  public void setDisplayLength(int displayLength) {
    this.displayLength = displayLength;
  }

  /**
   * Gets the display length for the x axis.
   *
   * @return the display length for the x axis
   */
  public int getDisplayLength() {
    return displayLength;
  }
}
