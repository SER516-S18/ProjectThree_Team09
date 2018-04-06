package ser516.project3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import ser516.project3.utilities.MessageEncoder;

public class MessageModelEncoderTest {

    @Test
    public void testEncodeMessage() {
        try {
            MessageModel messageModel = new MessageModel();
            MessageEncoder encoder = new MessageEncoder();

            String actual = encoder.encode(messageModel);
            String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("default.json"),
                "UTF-8"
            );

            assertEquals(actual, expected);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}