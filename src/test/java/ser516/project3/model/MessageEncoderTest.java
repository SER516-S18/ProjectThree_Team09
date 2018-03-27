package ser516.project3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

public class MessageEncoderTest {

    @Test
    public void testEncodeMessage() {
        try {
            Message message = new Message();
            MessageEncoder encoder = new MessageEncoder();

            String actual = encoder.encode(message);
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