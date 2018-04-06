package ser516.project3.client.view;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.GraphControllerInterface;
import ser516.project3.constants.ClientConstants;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.ExpressionsDataObservable;
import ser516.project3.model.PerformanceMetricDataObservable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * 
 * On receiving new data in ExpressionsDataObservable object update function of
 * this class can be used to update corresponding UI elements
 * 
 * @author Manish Tandon
 *
 */
public class ExpressionsGraphObserver implements Observer{

	@Override
	public void update(Observable observable, Object observerObj) {
		ExpressionsDataObservable expressionsDataObservable = (ExpressionsDataObservable) observable;

		GraphControllerInterface graphControllerInterface = ClientControllerImpl.getInstance()
				.getExpressionsController().getGraphController();

		graphControllerInterface.setGraphData(expressionsDataObservable.getExpressionsData());
		graphControllerInterface.setNoOfChannels(12);
		graphControllerInterface.setXLength(ClientConstants.DEFAULT_DISPLAY_LENGTH);
		graphControllerInterface.updateGraphView();

		ClientControllerImpl.getInstance().getExpressionsController().getExpressionsView().revalidate();
		ClientControllerImpl.getInstance().getExpressionsController().getExpressionsView().repaint();
	}

}
