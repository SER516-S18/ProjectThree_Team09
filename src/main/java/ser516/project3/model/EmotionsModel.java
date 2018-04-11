package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

public class EmotionsModel implements ModelInterface {
  private double interest;
  private double engagement;
  private double stress;
  private double relaxation;
  private double excitement;
  private double focus;

  public EmotionsModel() {
    interest = 0;
    engagement = 0;
    stress = 0;
    relaxation = 0;
    excitement = 0;
    focus = 0;
  }

  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  public double getEngagement() {
    return engagement;
  }

  public void setEngagement(double engagement) {
    this.engagement = engagement;
  }

  public double getStress() {
    return stress;
  }

  public void setStress(double stress) {
    this.stress = stress;
  }

  public double getRelaxation() {
    return relaxation;
  }

  public void setRelaxation(double relaxation) {
    this.relaxation = relaxation;
  }

  public double getExcitement() {
    return excitement;
  }

  public void setExcitement(double excitement) {
    this.excitement = excitement;
  }

  public double getFocus() {
    return focus;
  }

  public void setFocus(double focus) {
    this.focus = focus;
  }
}
