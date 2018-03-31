package ser516.project3.model;

import java.util.Map;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonBuilderFactory;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

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
        JsonObject timeAttributes=factory
        		.createObjectBuilder()
        		.add("Interval", message.getInterval())
        		.add("TimeStamp", message.getTimeStamp()).build();
      
        
        // Build "Expression" object.
        JsonObject expressionObject = factory
            .createObjectBuilder()
            .add("Blink", message.getBlink())
            .add("RightWink", message.getRightWink())
            .add("LeftWink", message.getLeftWink())
            .add("LookingRight", message.getLookingRight())
            .add("LookingLeft", message.getLookingLeft())
            .add("FurrowBrow", message.getFurrowBrow())
            .add("RaiseBrow", message.getRaiseBrow())
            .add("Smile", message.getSmile())
            .add("Clench", message.getClench())
            .add("LeftSmirk", message.getLeftSmirk())
            .add("RightSmirk", message.getRightSmirk())
            .add("Laugh", message.getLaugh())
            .build();
        
        // Build "Emotion" object.
        JsonObject emotionObject = factory
            .createObjectBuilder()
            .add("Interest", message.getInterest())
            .add("Engagement", message.getEngagement())
            .add("Stress", message.getStress())
            .add("Relaxation", message.getRelaxation())
            .add("Excitement", message.getExcitement())
            .add("Focus", message.getFocus())
            .build();

        return Json
            .createObjectBuilder()
            .add("Time-Attributes", timeAttributes)
            .add("Expression", expressionObject)
            .add("Emotion", emotionObject)
            .build()
            .toString();
    }

}