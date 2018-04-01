package ser516.project3.client.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ExpressionsDataObservable;
import ser516.project3.client.controller.PerformanceMetricDataObservable;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.Message;
import ser516.project3.model.MessageDecoder;

/**
 * This class acts as an end point of the connection and provides the message
 * bean that is further used to instantiate singleton data objects for
 * performance metrics and expressions.
 * 
 * 
 * @author Varun Srivastava, Manish Tandon
 *
 */
@ClientEndpoint(decoders = { MessageDecoder.class })
public class ClientConnectionEndpoint {

	final static Logger logger = Logger.getLogger(ClientConnectionEndpoint.class);

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected to endpoint: " + session.getBasicRemote());
		try {
			session.getBasicRemote().sendText("Test Text");
		} catch (IOException ex) {
			logger.error("Exception in onOpen method::::" + ex.getStackTrace());
		}
	}

	@OnMessage
	public void processMessage(Message messageBean, Session session) {
		PerformanceMetricDataObservable.getInstance().addToListValues(convertMessageToPeformanceMetrics(messageBean));
		ExpressionsDataObservable.getInstance().addToListValues(convertMessageToExpressionsData(messageBean));
	}

	@OnError
	public void processError(Throwable t) {
		logger.error("Error occurred in Client End Point");
	}

	/**
	 * 
	 * Converts message bean into list of coordinate object with time stamp and
	 * emotion attributes
	 * 
	 * @param messageObject
	 * @return ArrayList of coordinates for populating performance metrics graph
	 */
	private ArrayList<CoordinatesModel> convertMessageToPeformanceMetrics(Message messageObject) {
		ArrayList<CoordinatesModel> resultCoordinateModel = new ArrayList<CoordinatesModel>();

		CoordinatesModel currentCoordModelInterest = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getInterest());
		CoordinatesModel currentCoordModelEngagement = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getEngagement());
		CoordinatesModel currentCoordModelStress = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getStress());
		CoordinatesModel currentCoordModelRelaxation = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getRelaxation());
		CoordinatesModel currentCoordModelExcitement = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getExcitement());
		CoordinatesModel currentCoordModelFocus = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getFocus());
		resultCoordinateModel.add(currentCoordModelInterest);
		resultCoordinateModel.add(currentCoordModelEngagement);
		resultCoordinateModel.add(currentCoordModelStress);
		resultCoordinateModel.add(currentCoordModelRelaxation);
		resultCoordinateModel.add(currentCoordModelExcitement);
		resultCoordinateModel.add(currentCoordModelFocus);

		return resultCoordinateModel;

	}

	/**
	 * Converts message bean into list of coordinate object with time stamp and
	 * expressions
	 * 
	 * @param messageObject
	 * @return ArrayList of coordinates for populating expressions graph
	 */
	private ArrayList<CoordinatesModel> convertMessageToExpressionsData(Message messageObject) {
		ArrayList<CoordinatesModel> resultExpressionsCoordinateModel = new ArrayList<CoordinatesModel>();
		CoordinatesModel currentCoordModelBlink = new CoordinatesModel(messageObject.getTimeStamp(),
				(messageObject.getBlink()) ? 1 : 0);
		CoordinatesModel currentCoordModelRightWink = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getRightWink() ? 1 : 0);
		CoordinatesModel currentCoordModelLeftWink = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getLeftWink() ? 1 : 0);
		CoordinatesModel currentCoordModelLookingRight = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getLookingRight() ? 1 : 0);
		CoordinatesModel currentCoordModelLookingLeft = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getLookingLeft() ? 1 : 0);
		CoordinatesModel currentCoordModelFurrowBrow = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getFurrowBrow());
		CoordinatesModel currentCoordModelRaiseBrow = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getRaiseBrow());
		CoordinatesModel currentCoordModelSmile = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getSmile());
		CoordinatesModel currentCoordModelClench = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getClench());
		CoordinatesModel currentCoordModelLeftSmirk = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getLeftSmirk());
		CoordinatesModel currentCoordModelRightSmirk = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getRightSmirk());

		resultExpressionsCoordinateModel.add(currentCoordModelBlink);
		resultExpressionsCoordinateModel.add(currentCoordModelRightWink);
		resultExpressionsCoordinateModel.add(currentCoordModelLeftWink);
		resultExpressionsCoordinateModel.add(currentCoordModelLookingRight);
		resultExpressionsCoordinateModel.add(currentCoordModelLookingLeft);

		resultExpressionsCoordinateModel.add(currentCoordModelFurrowBrow);
		resultExpressionsCoordinateModel.add(currentCoordModelRaiseBrow);
		resultExpressionsCoordinateModel.add(currentCoordModelSmile);
		resultExpressionsCoordinateModel.add(currentCoordModelClench);
		resultExpressionsCoordinateModel.add(currentCoordModelLeftSmirk);
		resultExpressionsCoordinateModel.add(currentCoordModelRightSmirk);

		return resultExpressionsCoordinateModel;
	}

}
