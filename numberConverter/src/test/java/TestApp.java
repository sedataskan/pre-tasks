import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestApp {

    @Test
    void testTranslateOnOtherLangInputs() {
        assertThrows(IllegalArgumentException.class, () -> TranslatorFactory.create("f"));
    }
}
