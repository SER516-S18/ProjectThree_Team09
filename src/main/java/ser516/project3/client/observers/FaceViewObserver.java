package ser516.project3.client.observers;

import java.util.Observable;
import java.util.Observer;

import ser516.project3.client.controller.ClientControllerFactory;
import ser516.project3.client.controller.FaceController;
import ser516.project3.model.FaceExpressionsObservable;

/**
 * 
 * On receiving new data in ExpressionsDataObservable object update function of
 * this class can be used to update corresponding UI elements
 * 
 * @author Manish Tandon
 *
 */
public class FaceViewObserver implements Observer {
	/**
	 * Overridden method that updates the face elements.
	 */
	@Override
	public void update(Observable dataObject, Object observerObj) {
		FaceExpressionsObservable faceExpressionObject=(FaceExpressionsObservable) dataObject;

		FaceController faceController = ClientControllerFactory.getInstance().getFaceController();
		faceController.updateFaceElements(faceExpressionObject.getMessageBean());
	}

}
