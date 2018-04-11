package ser516.project3.utilities;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import ser516.project3.model.MessageModel;
import ser516.project3.model.MessageModel.AbstractExpression;
import ser516.project3.model.MessageModel.ConcreteExpression;
import ser516.project3.model.MessageModel.Emotion;
import ser516.project3.model.MessageModel.SelectedCriteria;

/**
 * The MessageDecoder class implements the web-socket Decoder interface. This
 * class handles the Unmarshalling of JSON into message class object.
 * 
 * @author vsriva12
 *
 */
public class MessageDecoder implements Decoder.Text<MessageModel> {

	/**
	 * Initialization method overridden from the interface
	 *
	 * @param config configuration for the decoding of the model
	 */
	@Override
	public void init(EndpointConfig config) {
		// Intentionally empty.
	}

	/**
	 * Destroys the object, if exists. Overridden from the interface
	 */
	@Override
	public void destroy() {
		// Intentionally empty.
	}

	/**
	 * Decodes the Strings to get a messageModel object
	 *
	 * @param payload JSON string to be decoded
	 * @return Returns the MessageModel object
	 * @throws DecodeException
	 */
	@Override
	public MessageModel decode(String payload) throws DecodeException {

		MessageModel messageModel = new MessageModel();

		// Read the payload.
		JsonObject root = Json.createReader(new StringReader(payload)).readObject();
		JsonObject timeAttributes = root.getJsonObject("Time-Attributes");
		JsonObject selectionAttributes = root.getJsonObject("Selection-Flags");
		JsonObject expressionAttributes = root.getJsonObject("Expression");
		JsonObject emotionAttributes = root.getJsonObject("Emotion");

		// Unmarshal the time attributes
		messageModel.setInterval(timeAttributes.getJsonNumber("Interval").doubleValue());
		messageModel.setTimeStamp(timeAttributes.getJsonNumber("TimeStamp").doubleValue());

		// Unmarshal the selection flag attributes.
		for (SelectedCriteria selectionFlag : SelectedCriteria.values()) {
			messageModel.setSelectionFlag(selectionFlag.name(),
					selectionAttributes.getJsonString(selectionFlag.name()).toString());
		}

		// Unmarshal the expression attributes.
		for (AbstractExpression abstractExpression : AbstractExpression.values()) {
			messageModel.setAbstractExpression(abstractExpression.name(),
					expressionAttributes.getJsonNumber(abstractExpression.name()).doubleValue());
		}
		for (ConcreteExpression concreteExpression : ConcreteExpression.values()) {
			messageModel.setConcreteExpression(concreteExpression.name(), 
					expressionAttributes.getBoolean(concreteExpression.name()));
		}
		// Unmarshal the emotion attributes.
		for (Emotion emotion : Emotion.values()) {
			messageModel.setEmotion(emotion.name(), emotionAttributes.getJsonNumber(emotion.name()).doubleValue());
		}

		return messageModel;
	}
	
	/**
	 * Returns a boolean indicating if a given string 
	 * will be decoded or not
	 * @param - string to check for decoding
	 */
	@Override
	public boolean willDecode(String string) {
		return true;
	}

}