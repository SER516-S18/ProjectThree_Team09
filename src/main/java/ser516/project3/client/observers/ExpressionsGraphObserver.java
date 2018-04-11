package ser516.project3.client.observers;

import ser516.project3.client.controller.ClientControllerFactory;
import ser516.project3.client.controller.GraphController;
import ser516.project3.model.ExpressionsDataObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * On receiving new data in ExpressionsDataObservable object update function of
 * this class can be used to update corresponding UI elements
 *
 * @author Manish Tandon
 */
public class ExpressionsGraphObserver implements Observer {

    @Override
    public void update(Observable observable, Object observerObj) {
        ExpressionsDataObservable expressionsDataObservable = (ExpressionsDataObservable) observable;

        GraphController graphController = ClientControllerFactory.getInstance().getExpressionsGraphController();

        graphController.setGraphData(expressionsDataObservable.getExpressionsData());
        graphController.setNoOfChannels(12);
        graphController.updateGraphView();
    }

}
