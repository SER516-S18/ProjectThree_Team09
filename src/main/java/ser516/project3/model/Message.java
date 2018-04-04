package ser516.project3.model;

import java.util.HashMap;

/**
 * Message is a data model class that encapsulates the data messages sent
 * between the client and the server. The
 * {@link ser516.project3.model.MessageEncoder} and
 * {@link ser516.project3.model.MessageDecoder} marshal and unmarshal instances
 * of this class, respectively.
 */
public class Message {

	private double interval;
	private double timeStamp;
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
		this.emotionMap.put(em, val);
	}
	
	public double getEmotion(String em) {
		if(em == null || this.emotionMap.get(em) == null) {
			return 0.0;
		}
		return this.emotionMap.get(em);
	}
	
	public void setAbstractExpression(String aex, Double val) {
		this.abstractExpressionMap.put(aex, val);
	}
	
	public double getAbstractExpression(String aex) {
		if(aex == null || this.abstractExpressionMap.get(aex) == null) {
			return 0.0;
		}
		return this.abstractExpressionMap.get(aex);
	}
	
	public void setConcreteExpression(String cex, Boolean val) {
		this.concreteExpressionMap.put(cex, val);
	}
	
	public Boolean getConcreteExpression(String cex) {
		if(cex == null || this.concreteExpressionMap.get(cex) == null) {
			return false;
		}
		return this.concreteExpressionMap.get(cex);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [timeStamp=").append(timeStamp);
		builder.append(", interval=").append(interval);
		for(Emotion em : Emotion.values()) {
			builder.append(", "+ em.name()+"=").append(this.emotionMap.get(em.name()));
		}
		for(AbstractExpression exp : AbstractExpression.values()) {
			builder.append(", "+exp.name()+"=").append(this.abstractExpressionMap.get(exp.name()));
		}
		for(ConcreteExpression exp : ConcreteExpression.values()) {
			builder.append(", "+exp.name()+"=").append(this.concreteExpressionMap.get(exp.name()));
		}
		return builder.toString();
	}
	
	public enum Emotion{
		interest, engagement, excitement, stress, relaxation, focus;
	}

	public enum AbstractExpression{
		smile, clench, leftSmirk, rightSmirk, laugh, furrowBrow, raiseBrow;
	}

	public enum ConcreteExpression{
		blink, rightWink, leftWink, lookingRight, lookingLeft;
	}
}
