package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Class stores the data for the emotions tab in the client
 *
 * @author Adhiraj Tikku
 */
public class EmotionsModel implements ModelInterface {
    private double interest;
    private double engagement;
    private double stress;
    private double relaxation;
    private double excitement;
    private double focus;

    /**
     * Constructor to initialize all the values to a default value
     */
    public EmotionsModel() {
        interest = 0;
        engagement = 0;
        stress = 0;
        relaxation = 0;
        excitement = 0;
        focus = 0;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the engagement
     */
    public double getEngagement() {
        return engagement;
    }

    /**
     * @param engagement the engagement to set
     */
    public void setEngagement(double engagement) {
        this.engagement = engagement;
    }

    /**
     * @return the stress
     */
    public double getStress() {
        return stress;
    }

    /**
     * @param stress the stress to set
     */
    public void setStress(double stress) {
        this.stress = stress;
    }

    /**
     * @return the relaxation
     */
    public double getRelaxation() {
        return relaxation;
    }

    /**
     * @param relaxation the relaxation to set
     */
    public void setRelaxation(double relaxation) {
        this.relaxation = relaxation;
    }

    /**
     * @return the excitement
     */
    public double getExcitement() {
        return excitement;
    }

    /**
     * @param excitement the excitement to set
     */
    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

    /**
     * @return the focus
     */
    public double getFocus() {
        return focus;
    }

    /**
     * @param focus the focus to set
     */
    public void setFocus(double focus) {
        this.focus = focus;
    }


}
