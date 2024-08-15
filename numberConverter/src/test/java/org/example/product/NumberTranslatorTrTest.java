package org.example.product;

import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTranslatorTrTest {

    @Test
    void testTranslateTurkishForZero() {

        String expected = "Sıfır";
        String result = TranslatorFactory.create("t").translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForOneDigit() {
        String expected = "Üç";
        String result = TranslatorFactory.create("t").translate(3);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForTwoDigits() {
        String expected = "OtuzBeş";
        String result = TranslatorFactory.create("t").translate(35);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForThreeDigits() {

        String expected = "ÜçYüzYirmiDört";
        String result = TranslatorFactory.create("t").translate(324);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits() {

        String expected = "İkiBinBir";
        String result = TranslatorFactory.create("t").translate(2001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits1001() {

        String expected = "BinBir";
        String result = TranslatorFactory.create("t").translate(1001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFiveDigits() {

        String expected = "YirmiBinOnBeş";
        String result = TranslatorFactory.create("t").translate(20015);

        assertEquals(expected, result);
    }
}