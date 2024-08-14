import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestApp {
    @Test
    void testTranslateEnglishForZero() {

        String expected = "zero";
        String result = TranslatorFactory.create("e").translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForOneDigit() {

        String expected = "two";
        String result = TranslatorFactory.create("e").translate(2);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigitsTen() {

        String expected = "fifteen";
        String result = TranslatorFactory.create("e").translate(15);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigits() {

        String expected = "sixty seven";
        String result = TranslatorFactory.create("e").translate(67);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigits() {

        String expected = "one hundred thirty seven";
        String result = TranslatorFactory.create("e").translate(137);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigitsTen() {

        String expected = "two hundred nineteen";
        String result = TranslatorFactory.create("e").translate(219);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigitsTen() {

        String expected = "two thousand fourteen";
        String result = TranslatorFactory.create("e").translate(2014);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigits() {

        String expected = "one thousand nine hundred seven";
        String result = TranslatorFactory.create("e").translate(1907);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForBigger() {

        String expected = "Something went wrong";
        String result = TranslatorFactory.create("e").translate(10010);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForZero() {

        String expected = "sıfır";
        String result = TranslatorFactory.create("t").translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForOneDigit() {
        String expected = "üç";
        String result = TranslatorFactory.create("t").translate(3);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForTwoDigits() {
        String expected = "otuz beş";
        String result = TranslatorFactory.create("t").translate(35);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForThreeDigits() {

        String expected = "üç yüz yirmi dört";
        String result = TranslatorFactory.create("t").translate(324);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits() {

        String expected = "iki bin bir";
        String result = TranslatorFactory.create("t").translate(2001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFiveDigits() {

        String expected = "yirmi bin on beş";
        String result = TranslatorFactory.create("t").translate(20015);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateOnOtherLangInputs() {
        assertThrows(IllegalArgumentException.class, () -> TranslatorFactory.create("f"));
    }
}
