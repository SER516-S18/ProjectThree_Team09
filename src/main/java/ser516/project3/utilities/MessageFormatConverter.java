package ser516.project3.utilities;

import java.util.ArrayList;

import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.Message;

/**
 * This class converts message bean in to a format that can be understood by
 * various UI elements like graph
 * 
 * 
 * @author Manish Tandon
 *
 */
public class MessageFormatConverter {

	/**
	 * 
	 * Converts message bean into list of coordinate object with time stamp and
	 * emotion attributes
	 * 
	 * @param messageObject
	 * @return ArrayList of coordinates for populating performance metrics graph
	 */
	public static ArrayList<CoordinatesModel> convertMessageToPeformanceMetrics(Message messageObject) {
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
	public static ArrayList<CoordinatesModel> convertMessageToExpressionsData(Message messageObject) {
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
