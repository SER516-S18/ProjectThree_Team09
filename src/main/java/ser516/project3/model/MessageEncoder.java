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
        
        // Build "Expressive" object.
        JsonObject expressiveObject = factory
            .createObjectBuilder()
            .add("LookingRight", message.getLookingRight())
            .add("LookingLeft", message.getLookingLeft())
            .add("LookingDown", message.getLookingDown())
            .add("LookingUp", message.getLookingUp())
            .add("EyebrowRaise", message.getEyebrowRaise())
            .add("RightWink", message.getRightWink())
            .add("LeftWink", message.getLeftWink())
            .add("Blink", message.getBlink())
            .add("EyesOpen", message.getEyesOpen())
            .add("Smile", message.getSmile())
            .add("Clench", message.getClench())
            .build();
        
        // Build "Affective" object.
        JsonObject affectiveObject = factory
            .createObjectBuilder()
            .add("Meditation", message.getMeditation())
            .add("Frustration", message.getFrustration())
            .add("EngagementBoredom", message.getEngagementBoredom())
            .add("ExcitementShortTerm", message.getExcitementShortTerm())
            .add("ExcitementLongTerm", message.getExcitementLongTerm())
            .build();

        return Json
            .createObjectBuilder()
            .add("Expressive", expressiveObject)
            .add("Affective", affectiveObject)
            .build()
            .toString();
    }

}