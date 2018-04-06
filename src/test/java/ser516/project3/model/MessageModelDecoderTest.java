package ser516.project3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import ser516.project3.model.MessageModel.AbstractExpression;
import ser516.project3.model.MessageModel.ConcreteExpression;
import ser516.project3.model.MessageModel.Emotion;
import ser516.project3.utilities.MessageDecoder;

public class MessageModelDecoderTest {

    @Test
    public void testDecodeMessage() {
        try {
            String payload = IOUtils.toString(
                this.getClass().getResourceAsStream("default.json"),
                "UTF-8"
            );

            MessageDecoder decoder = new MessageDecoder();
            MessageModel messageModel = decoder.decode(payload);

            assertEquals(messageModel.getAbstractExpression(ConcreteExpression.blink.name()), false);
            assertEquals(messageModel.getAbstractExpression(AbstractExpression.clench.name()), false);
            assertEquals(messageModel.getEmotion(Emotion.engagement.name()), 0.0);
            assertEquals(messageModel.getEmotion(Emotion.excitement.name()), 0.0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}