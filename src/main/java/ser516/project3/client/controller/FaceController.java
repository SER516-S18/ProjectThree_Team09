package ser516.project3.client.controller;

import ser516.project3.client.view.FaceView;
import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.FaceModel;
import ser516.project3.model.MessageModel;

public class FaceController implements ControllerInterface{
  private FaceModel faceModel;
  private FaceView faceView;

  public FaceController(FaceModel faceModel, FaceView faceView) {
    this.faceModel = faceModel;
    this.faceView = faceView;
  }

  @Override
  public void initializeView() {
    faceView.initializeView(null);
  }

  public FaceView getFaceView() {
    return faceView;
  }

  public void updateFaceElements(MessageModel messageModel) {
    faceView.updateFaceElements(messageModel);
  }

  public void setSelected(boolean selected) {
    faceView.setSelected(selected);
  }
}
