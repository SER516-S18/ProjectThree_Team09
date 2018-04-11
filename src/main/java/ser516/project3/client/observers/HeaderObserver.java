package ser516.project3.client.observers;

import ser516.project3.client.controller.ClientControllerFactory;
import ser516.project3.client.controller.HeaderController;
import ser516.project3.model.HeaderObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * The HeaderOvserver class implements the Observer interface to update the
 * header time stamp value.
 * 
 * @author vsriva12
 *
 */
public class HeaderObserver implements Observer {

	public void update(Observable observable, Object observerObj) {
		HeaderObservable headerObservable = (HeaderObservable) observable;
		HeaderController headerController = ClientControllerFactory.getInstance().getHeaderController();
		double currentTimeStampFromServer = headerObservable.getHeaderTimeStamp();
		if (currentTimeStampFromServer == 0) {
			headerController.setHeaderTimeStamp((int)currentTimeStampFromServer);
		} else {
			headerController.setHeaderTimeStamp((int)currentTimeStampFromServer - headerObservable.getInterval());
		}
	}
}
