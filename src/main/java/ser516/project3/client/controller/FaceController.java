package ser516.project3.client.controller;

import ser516.project3.client.view.FaceView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.FaceModel;
import ser516.project3.model.MessageModel;

/**
 * Class to handle the face view and model for
 * controlling the expressions on face on UI
 *
 * @author Adhiraj Tikku
 */

public class FaceController implements ControllerInterface{
  private FaceModel faceModel;
  private FaceView faceView;

    /**
     * Contructor to initialize the controller with instances of view and model
     *
     * @param faceModel Model containing the eligible set of data for the Face View
     * @param faceView  View class which renders the view for fae on screen
     */
  public FaceController(FaceModel faceModel, FaceView faceView) {
    this.faceModel = faceModel;
    this.faceView = faceView;
  }

    /**
     * Initializes the face view class whenever the view is opened
     */
  @Override
  public void initializeView() {
    faceView.initializeView(null);
  }

    /**
     * returns the instance of FaceView
     *
     * @return FaceView object rendered on the screen returned
     */
  @Override
  public FaceView getView() {
    return faceView;
  }

    /**
     * Overriden method from Interface. Does not have any specific
     * functionality in this class as there are no sub controllers
     *
     * @return returns null in this case
     */
  @Override
  public ControllerInterface[] getSubControllers() {
    return null;
  }

    /**
     * Updates the elements on teh face view on basis of the message
     * received from the client
     *
     * @param messageModel Contains the set of face expression values
     *                    sent from the server
     */
  public void updateFaceElements(MessageModel messageModel) {
    faceView.updateFaceElements(messageModel);
  }

    /**
     * Verifies if the tab for the expressions is selected, if yes
     * then only update the view
     *
     * @param selected true if the expressions tab is selected
     */

  public void setSelected(boolean selected) {
    faceView.setSelected(selected);
  }
}
