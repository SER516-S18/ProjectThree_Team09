package ser516.project3.model;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

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
        message.setBlink(expressionAttributes.getBoolean("Blink"));
        message.setRightWink(expressionAttributes.getBoolean("RightWink"));
        message.setLeftWink(expressionAttributes.getBoolean("LeftWink"));
        message.setLookingRight(expressionAttributes.getBoolean("LookingRight"));
        message.setLookingLeft(expressionAttributes.getBoolean("LookingLeft"));
        message.setFurrowBrow(expressionAttributes.getJsonNumber("FurrowBrow").doubleValue());
        message.setRaiseBrow(expressionAttributes.getJsonNumber("RaiseBrow").doubleValue());
        message.setSmile(expressionAttributes.getJsonNumber("Smile").doubleValue());
        message.setClench(expressionAttributes.getJsonNumber("Clench").doubleValue());
        message.setLeftSmirk(expressionAttributes.getJsonNumber("LeftSmirk").doubleValue());
        message.setRightSmirk(expressionAttributes.getJsonNumber("RightSmirk").doubleValue());
        message.setLaugh(expressionAttributes.getJsonNumber("Laugh").doubleValue());

        // Unmarshal the emotion attributes.
        message.setInterest(emotionAttributes.getJsonNumber("Interest").doubleValue());
        message.setEngagement(emotionAttributes.getJsonNumber("Engagement").doubleValue());
        message.setStress(emotionAttributes.getJsonNumber("Stress").doubleValue());
        message.setRelaxation(emotionAttributes.getJsonNumber("Relaxation").doubleValue());
        message.setExcitement(emotionAttributes.getJsonNumber("Excitement").doubleValue());
        message.setFocus(emotionAttributes.getJsonNumber("Focus").doubleValue());

        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

}