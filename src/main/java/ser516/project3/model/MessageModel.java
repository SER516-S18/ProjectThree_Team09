package ser516.project3.model;

import ser516.project3.utilities.MessageDecoder;
import ser516.project3.utilities.MessageEncoder;

import java.util.HashMap;

/**
 * MessageModel is a data model class that encapsulates the data messages sent
 * between the client and the server. The {@link MessageEncoder} and
 * {@link MessageDecoder} marshal and unmarshal instances of this class,
 * respectively.
 */
public class MessageModel {

	private double interval;
	private double timeStamp;
	// Selection flag contains the value that is currently selected in the slection
	// dropdown on server
	private HashMap<String, String> selectionFlagMap = new HashMap<String, String>();
	private HashMap<String, Double> emotionMap = new HashMap<String, Double>();
	private HashMap<String, Double> abstractExpressionMap = new HashMap<String, Double>();
	private HashMap<String, Boolean> concreteExpressionMap = new HashMap<String, Boolean>();

	

	/**
	 * @return the interval
	 */
	public double getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(double interval) {
		this.interval = interval;
	}

	/**
	 * @return the timeStamp
	 */
	public double getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Adds the passed double value to the corresponding string in the hashmap
	 * 
	 * @param emotionKey key for the emotion type 
	 * @param val value for the emotion key
	 */
	public void setEmotion(String emotionKey, Double val) {
		this.emotionMap.put(emotionKey.toLowerCase(), val);
	}

	/**
	 * Returns the value for the respective key
	 * 
	 * @param emotionKey emotion key for which the value has to be received
	 * @return returns the value for the respective emotion key
	 */
	public double getEmotion(String emotionKey) {
		if (emotionKey == null || this.emotionMap.get(emotionKey.toLowerCase()) == null) {
			return 0.0;
		}
		return this.emotionMap.get(emotionKey.toLowerCase());
	}

	/**
	 * Adds the passed double value to the corresponding string in the hashmap
	 * 
	 * @param aex key for the abstract expression type 
	 * @param val value for the abstract expression key
	 */
	public void setAbstractExpression(String abstractExpression, Double val) {
		this.abstractExpressionMap.put(abstractExpression, val);
	}

	/**
	 * Returns the value for the respective key
	 *
	 * @param abstractExpression abstract expression key for which the value has to be received
	 * @return returns the value for the respective abstract expression key
	 */
	public double getAbstractExpression(String abstractExpression) {
		if (abstractExpression == null || this.abstractExpressionMap.get(abstractExpression) == null) {
			return 0.0;
		}
		return this.abstractExpressionMap.get(abstractExpression);
	}

	/**
	 * Adds the passed double value to the corresponding string in the hashmap
	 *
	 * @param concreteExpression key for the concrete expression type
	 * @param val value for the concrete expression key
	 */
	public void setConcreteExpression(String concreteExpression, Boolean val) {
		this.concreteExpressionMap.put(concreteExpression, val);
	}

	/**
	 * Returns the value for the respective key
	 *
	 * @param concreteExpression concrete expression key for which the value has to be received
	 * @return returns the value for the respective concrete expression key
	 */
	public Boolean getConcreteExpression(String concreteExpression) {
		if (concreteExpression == null || this.concreteExpressionMap.get(concreteExpression) == null) {
			return false;
		}
		return this.concreteExpressionMap.get(concreteExpression);
	}

	/**
	 * Returns the value for the respective key
	 *
	 * @param selectionFlag selection  key for which the value has to be received
	 * @return returns the value for the respective concrete expression key
	 */
	public String getSelectionFlag(String selectionFlag) {
		if (selectionFlag == null || this.selectionFlagMap.get(selectionFlag) == null) {
			return "";
		}
		return this.selectionFlagMap.get(selectionFlag);
	}

	/**
	 * Maps the value for the respective key for which the upper, lower and eye
	 * has been currently selected
	 *
	 * @param selectionKey  key for which the value has to be set
	 * @param selectionValue Value of the corresponding key
	 */
	public void setSelectionFlag(String selectionKey, String selectionValue) {
		selectionValue = selectionValue.replaceAll("\"", "");
		this.selectionFlagMap.put(selectionKey, selectionValue);
	}

	/**
	 * Overridden method to convert the model into string in the specified format
	 *
	 * @return returns the string conversion of the class
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageModel [timeStamp=").append(timeStamp);
		builder.append(", interval=").append(interval);
		for (SelectedCriteria selectionflag : SelectedCriteria.values()) {
			builder.append(", " + selectionflag.name() + "=").append(this.selectionFlagMap.get(selectionflag.name()));
		}
		for (Emotion em : Emotion.values()) {
			builder.append(", " + em.name() + "=").append(this.emotionMap.get(em.name()));
		}
		for (AbstractExpression exp : AbstractExpression.values()) {
			builder.append(", " + exp.name() + "=").append(this.abstractExpressionMap.get(exp.name()));
		}
		for (ConcreteExpression exp : ConcreteExpression.values()) {
			builder.append(", " + exp.name() + "=").append(this.concreteExpressionMap.get(exp.name()));
		}
		return builder.toString();
	}

	/**
	 * Enum to standardize the kind of emotion
	 */
	public enum Emotion {
		interest, engagement, stress, relaxation, excitement, focus
	}

	/**
	 * Enum to standardize the kind of abstract expression
	 */
	public enum AbstractExpression {
		smile, clench, leftSmirk, rightSmirk, laugh, furrowBrow, raiseBrow
	}

	/**
	 * Enum ro standardize the kind of Concrete expression
	 */
	public enum ConcreteExpression {
		blink, rightWink, leftWink, lookingRight, lookingLeft
	}

	/**
	 * Enum to standardize the selection type of the expressions
	 */
	public enum SelectedCriteria {
		upperFace, lowerFace, eye
	}
}
