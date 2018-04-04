package ser516.project3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import ser516.project3.model.Message.AbstractExpression;
import ser516.project3.model.Message.Emotion;

public class MessageDecoderTest {

    @Test
    public void testDecodeMessage() {
        try {
            String payload = IOUtils.toString(
                this.getClass().getResourceAsStream("default.json"),
                "UTF-8"
            );

            MessageDecoder decoder = new MessageDecoder();
            Message message = decoder.decode(payload);

            assertEquals(message.getAbstractExpression(AbstractExpression.blink.name()), false);
            assertEquals(message.getAbstractExpression(AbstractExpression.clench.name()), false);
            assertEquals(message.getEmotion(Emotion.engagement.name()), 0.0);
            assertEquals(message.getEmotion(Emotion.excitement.name()), 0.0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}