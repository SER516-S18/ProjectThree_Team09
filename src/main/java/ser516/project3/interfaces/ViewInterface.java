package ser516.project3.interfaces;

/**
 * Interface for standardizing the initialization of all the views
 *
 * @author Adhiraj Tikku
 */
public interface ViewInterface {

  /**
   * Initializes the view from all the controllers
   *
   * @param subViews gives array of all the subviews to be initialized
   */
  void initializeView(ViewInterface subViews[]);
}
