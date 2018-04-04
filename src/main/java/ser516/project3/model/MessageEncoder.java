package ser516.project3.model;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import ser516.project3.model.Message.AbstractExpression;
import ser516.project3.model.Message.ConcreteExpression;
import ser516.project3.model.Message.Emotion;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public void init(EndpointConfig config) {
        // Intentionally empty.
    }

    @Override
    public void destroy() {
        // Intentionally empty.
    }

    @Override
    public String encode(Message message) throws EncodeException {
        Map<String, Object> config = new HashMap<String, Object>();
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        
        
        //Build Time attributes
        JsonObject timeAttributes=factory.createObjectBuilder()
        								 .add("Interval", message.getInterval())
        								 .add("TimeStamp", message.getTimeStamp()).build();
        
        // Build "Expression" object.
        JsonObjectBuilder expressionBuilder = factory.createObjectBuilder();   	
        for(AbstractExpression aex : AbstractExpression.values()) {
        	expressionBuilder.add(aex.name(), message.getAbstractExpression(aex.name()));
        }
        for(ConcreteExpression cex : ConcreteExpression.values()) {
        	expressionBuilder.add(cex.name(), message.getConcreteExpression(cex.name()));
        }        
        // Build "Emotion" object.
        JsonObjectBuilder emotionBuilder = factory.createObjectBuilder();
        for(Emotion em : Emotion.values()) {
        	emotionBuilder.add(em.name(), message.getEmotion(em.name()));
        }
        return Json
            .createObjectBuilder()
            .add("Time-Attributes", timeAttributes)
            .add("Expression", expressionBuilder.build())
            .add("Emotion", emotionBuilder.build())
            .build()
            .toString();
    }

}