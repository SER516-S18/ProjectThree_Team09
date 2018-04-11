package ser516.project3.interfaces;
/**
 * The interface for initializing views for the application
 * @author vsriva12
 *
 */
public interface ControllerInterface{
	/**
	 * Initializes the UI JFrame
	 */
	void initializeView();

	/**
	 * Gets the View for this controller.
	 * @return view for this controller
	 */
	ViewInterface getView();

	/**
	 * Gets the array of sub controllers for this controller.
	 * @return array of sub controllers for this controller
	 */
	ControllerInterface[] getSubControllers();
}
