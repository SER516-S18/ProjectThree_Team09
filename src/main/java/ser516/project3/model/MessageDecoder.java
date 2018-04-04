package ser516.project3.model;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import ser516.project3.model.Message.AbstractExpression;
import ser516.project3.model.Message.ConcreteExpression;
import ser516.project3.model.Message.Emotion;



public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public void init(EndpointConfig config) {
        // Intentionally empty.
    }

    @Override
    public void destroy() {
        // Intentionally empty.
    }

    @Override
    public Message decode(String payload) throws DecodeException {

        Message message = new Message();

        // Read the payload.
        JsonObject root = Json.createReader(new StringReader(payload)).readObject();
        JsonObject timeAttributes= root.getJsonObject("Time-Attributes");
        JsonObject expressionAttributes = root.getJsonObject("Expression");
        JsonObject emotionAttributes = root.getJsonObject("Emotion");
        
        //Unmarshal the time attributes
        message.setInterval(timeAttributes.getJsonNumber("Interval").doubleValue());
        message.setTimeStamp(timeAttributes.getJsonNumber("TimeStamp").doubleValue());

        // Unmarshal the expression attributes.
        for(AbstractExpression aex : AbstractExpression.values()) {
        	message.setAbstractExpression(aex.name(), expressionAttributes.getJsonNumber(aex.name()).doubleValue());
        }
        for(ConcreteExpression cex : ConcreteExpression.values()) {
        	message.setConcreteExpression(cex.name(), expressionAttributes.getBoolean(cex.name()));
        }
        // Unmarshal the emotion attributes.
        for(Emotion em : Emotion.values()) {
        	message.setEmotion(em.name(), emotionAttributes.getJsonNumber(em.name()).doubleValue());
        }

        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

}