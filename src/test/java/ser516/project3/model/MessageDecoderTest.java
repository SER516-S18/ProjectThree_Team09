package ser516.project3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

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

            assertEquals(message.getBlink(), false);
            assertEquals(message.getClench(), false);
            assertEquals(message.getEngagementBoredom(), 0.0);
            assertEquals(message.getExcitementShortTerm(), 0.0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}