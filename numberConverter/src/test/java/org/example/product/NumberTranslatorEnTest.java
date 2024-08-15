package org.example.product;

import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTranslatorEnTest {
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

        String expected = "ten thousand ten";
        String result = TranslatorFactory.create("e").translate(10010);

        assertEquals(expected, result);
    }
}
