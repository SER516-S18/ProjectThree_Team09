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
        JsonObject expressiveAttributes = root.getJsonObject("Expressive");
        JsonObject affectiveAttributes = root.getJsonObject("Affective");

        // Unmarshal the expressive attributes.
        message.setLookingRight(expressiveAttributes.getBoolean("LookingRight"));
        message.setLookingLeft(expressiveAttributes.getBoolean("LookingLeft"));
        message.setLookingDown(expressiveAttributes.getBoolean("LookingDown"));
        message.setLookingUp(expressiveAttributes.getBoolean("LookingUp"));
        message.setEyebrowRaise(expressiveAttributes.getBoolean("EyebrowRaise"));
        message.setRightWink(expressiveAttributes.getBoolean("RightWink"));
        message.setLeftWink(expressiveAttributes.getBoolean("LeftWink"));
        message.setBlink(expressiveAttributes.getBoolean("Blink"));
        message.setEyesOpen(expressiveAttributes.getBoolean("EyesOpen"));
        message.setSmile(expressiveAttributes.getBoolean("Smile"));
        message.setClench(expressiveAttributes.getBoolean("Clench"));

        // Unmarshal the affective attributes.
        message.setMeditation(affectiveAttributes.getJsonNumber("Meditation").doubleValue());
        message.setFrustration(affectiveAttributes.getJsonNumber("Frustration").doubleValue());
        message.setEngagementBoredom(affectiveAttributes.getJsonNumber("EngagementBoredom").doubleValue());
        message.setExcitementShortTerm(affectiveAttributes.getJsonNumber("ExcitementShortTerm").doubleValue());
        message.setExcitementLongTerm(affectiveAttributes.getJsonNumber("ExcitementLongTerm").doubleValue());

        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

}