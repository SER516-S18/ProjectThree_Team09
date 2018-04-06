package ser516.project3.client.view;

import ser516.project3.client.controller.ClientControllerImpl;
import ser516.project3.client.controller.HeaderController;
import ser516.project3.model.HeaderObservable;

import java.util.Observable;
import java.util.Observer;

public class HeaderObserver implements Observer{

  public void update(Observable observable, Object observerObj) {
    HeaderObservable headerObservable = (HeaderObservable) observable;
    HeaderController headerController = ClientControllerImpl.getInstance().getHeaderController();
    headerController.setHeaderTimeStamp(headerObservable.getHeaderTimeStamp() - headerObservable.getInterval());
  }
}
