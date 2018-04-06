package ser516.project3.utilities;

import java.util.ArrayList;

import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.MessageModel;
import ser516.project3.model.MessageModel.AbstractExpression;
import ser516.project3.model.MessageModel.ConcreteExpression;
import ser516.project3.model.MessageModel.Emotion;

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
	 * @param messageModelObject
	 * @return ArrayList of coordinates for populating performance metrics graph
	 */
	public static ArrayList<CoordinatesModel> convertMessageToPeformanceMetrics(MessageModel messageModelObject) {
		ArrayList<CoordinatesModel> resultCoordinateModel = new ArrayList<CoordinatesModel>();

		for(Emotion em : Emotion.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageModelObject.getTimeStamp(),
				messageModelObject.getEmotion(em.name()));
			resultCoordinateModel.add(currentCoordModel);
		}
		return resultCoordinateModel;

	}

	/**
	 * Converts message bean into list of coordinate object with time stamp and
	 * expressions
	 * 
	 * @param messageModelObject
	 * @return ArrayList of coordinates for populating expressions graph
	 */
	public static ArrayList<CoordinatesModel> convertMessageToExpressionsData(MessageModel messageModelObject) {
		ArrayList<CoordinatesModel> resultExpressionsCoordinateModel = new ArrayList<CoordinatesModel>();
		for(ConcreteExpression cex : ConcreteExpression.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageModelObject.getTimeStamp(),
					(messageModelObject.getConcreteExpression(cex.name()) ? 1 : 0));
			resultExpressionsCoordinateModel.add(currentCoordModel);

		}
		for(AbstractExpression aex : AbstractExpression.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageModelObject.getTimeStamp(),
					messageModelObject.getAbstractExpression(aex.name()));
			resultExpressionsCoordinateModel.add(currentCoordModel);

		}
		return resultExpressionsCoordinateModel;
	}

}
