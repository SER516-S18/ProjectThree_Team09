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

	public double getInterval() {
		return interval;
	}

	public void setInterval(double interval) {
		this.interval = interval;
	}

	public double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setEmotion(String em, Double val) {
		this.emotionMap.put(em.toLowerCase(), val);
	}

	public double getEmotion(String em) {
		if (em == null || this.emotionMap.get(em.toLowerCase()) == null) {
			return 0.0;
		}
		return this.emotionMap.get(em.toLowerCase());
	}

	public void setAbstractExpression(String aex, Double val) {
		this.abstractExpressionMap.put(aex, val);
	}

	public double getAbstractExpression(String aex) {
		if (aex == null || this.abstractExpressionMap.get(aex) == null) {
			return 0.0;
		}
		return this.abstractExpressionMap.get(aex);
	}

	public void setConcreteExpression(String cex, Boolean val) {
		this.concreteExpressionMap.put(cex, val);
	}

	public Boolean getConcreteExpression(String cex) {
		if (cex == null || this.concreteExpressionMap.get(cex) == null) {
			return false;
		}
		return this.concreteExpressionMap.get(cex);
	}

	public String getSelectionFlag(String selectionFlag) {
		if (selectionFlag == null || this.selectionFlagMap.get(selectionFlag) == null) {
			return "";
		}
		return this.selectionFlagMap.get(selectionFlag);
	}

	public void setSelectionFlag(String selectionKey, String selectionValue) {
		this.selectionFlagMap.put(selectionKey, selectionValue);
	}

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

	public enum Emotion {
		interest, engagement, stress, relaxation, excitement, focus
	}

	public enum AbstractExpression {
		smile, clench, leftSmirk, rightSmirk, laugh, furrowBrow, raiseBrow
	}

	public enum ConcreteExpression {
		blink, rightWink, leftWink, lookingRight, lookingLeft
	}

	public enum SelectedCriteria {
		upperFace, lowerFace, eye
	}
}
