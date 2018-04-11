package ser516.project3.utilities;

import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.MessageModel;
import ser516.project3.model.MessageModel.AbstractExpression;
import ser516.project3.model.MessageModel.ConcreteExpression;
import ser516.project3.model.MessageModel.Emotion;

import java.util.ArrayList;

/**
 * This class converts message bean in to a format that can be understood by
 * various UI elements like graph
 *
 * @author Manish Tandon
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

		for(Emotion emotions : Emotion.values()) {
			CoordinatesModel currentCoordModel = new CoordinatesModel(messageModelObject.getTimeStamp(),
				messageModelObject.getEmotion(emotions.name()));
			resultCoordinateModel.add(currentCoordModel);
		}
		return resultCoordinateModel;

	}

	/**
	 * Converts message bean into list of coordinate object with time stamp and
	 * expressions
	 * 
	 * @param messageModel
	 * @return ArrayList of coordinates for populating expressions graph
	 */
	public static ArrayList<CoordinatesModel> convertMessageToExpressionsData(MessageModel messageModel) {
		ArrayList<CoordinatesModel> resultExpressionsCoordinateModel = new ArrayList<CoordinatesModel>();
		int yAxis = 24;
		for(ConcreteExpression concreteExpression : ConcreteExpression.values()) {
			CoordinatesModel coordinatesModel = new CoordinatesModel(messageModel.getTimeStamp(),
					(messageModel.getConcreteExpression(concreteExpression.name()) ? yAxis : yAxis - 1));
			resultExpressionsCoordinateModel.add(coordinatesModel);
			yAxis = yAxis - 2;
		}
		for(AbstractExpression abstractExpression : AbstractExpression.values()) {
			CoordinatesModel coordinatesModel = new CoordinatesModel(messageModel.getTimeStamp(),
					messageModel.getAbstractExpression(abstractExpression.name()) + yAxis - 1);
			resultExpressionsCoordinateModel.add(coordinatesModel);
			yAxis = yAxis - 2;
		}
		return resultExpressionsCoordinateModel;
	}
}
