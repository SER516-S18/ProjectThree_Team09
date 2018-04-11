package ser516.project3.model;

import ser516.project3.interfaces.ModelInterface;

/**
 * Stores the values for face to be updated
 *
 * @author manishtandon
 */
public class FaceModel implements ModelInterface{
  private int width;
  private int height;

  public FaceModel() {
    this.width = 300;
    this.height = 300;
  }

  /**
   * @return width of face
   */
  public int getWidth() {
    return width;
  }

  /**
   * @param width width of face
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * @return height of face
   */
  public int getHeight() {
    return height;
  }

  /**
   * @param height height of face
   */
  public void setHeight(int height) {
    this.height = height;
  }
}
