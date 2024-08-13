import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestApp {
    @Test
    void testTranslateEnglish() {

        String expected = "one hundred twenty three ";
        String result = TranslatorFactory.create("e").translate(123);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForZero() {

        String expected = "zero ";
        String result = TranslatorFactory.create("e").translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForBigger() {

        String expected = "one thousand one ";
        String result = TranslatorFactory.create("e").translate(1001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkish() {

        String expected = "yüz yirmi üç ";
        String result = TranslatorFactory.create("t").translate(123);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForZero() {

        String expected = "sıfır";
        String result = TranslatorFactory.create("t").translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForBigger() {

        String expected = "bin bir ";
        String result = TranslatorFactory.create("t").translate(1001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateOnOtherLangInputs() {
        assertThrows(IllegalArgumentException.class, () -> TranslatorFactory.create("f"));
    }
}
