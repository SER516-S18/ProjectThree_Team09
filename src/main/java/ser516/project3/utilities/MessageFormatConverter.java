package ser516.project3.utilities;

import java.util.ArrayList;

import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.Message;
import ser516.project3.model.Message.AbstractExpression;
import ser516.project3.model.Message.ConcreteExpression;
import ser516.project3.model.Message.Emotion;

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

		for(Emotion em : Emotion.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageObject.getTimeStamp(),
				messageObject.getEmotion(em.name()));
			resultCoordinateModel.add(currentCoordModel);
		}
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
		for(ConcreteExpression cex : ConcreteExpression.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageObject.getTimeStamp(),
					(messageObject.getConcreteExpression(cex.name()) ? 1 : 0));
			resultExpressionsCoordinateModel.add(currentCoordModel);

		}
		for(AbstractExpression aex : AbstractExpression.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageObject.getTimeStamp(),
					messageObject.getAbstractExpression(aex.name()));
			resultExpressionsCoordinateModel.add(currentCoordModel);

		}
		return resultExpressionsCoordinateModel;
	}

}
