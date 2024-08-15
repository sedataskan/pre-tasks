package org.example.product;

import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTranslatorTrTest {

    @Test
    void testTranslateTurkishForZero() {

        String expected = "Sıfır";
        String result = TranslatorFactory.create("t").translate("0");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForOneDigit() {
        String expected = "Üç";
        String result = TranslatorFactory.create("t").translate("3");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForTwoDigits() {
        String expected = "OtuzBeş";
        String result = TranslatorFactory.create("t").translate("35");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForThreeDigits() {

        String expected = "ÜçYüzYirmiDört";
        String result = TranslatorFactory.create("t").translate("324");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits() {

        String expected = "İkiBinAltıYüzOnDört";
        String result = TranslatorFactory.create("t").translate("2614");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits1001() {

        String expected = "BinBir";
        String result = TranslatorFactory.create("t").translate("1001");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFiveDigits() {

        String expected = "YirmiBinOnBeş";
        String result = TranslatorFactory.create("t").translate("20015");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForBigger() {

        String expected = "BeşMilyarBeşYüzYirmiÜçMilyonDörtYüzElliYediBinAltıYüzOtuzDört";
        String result = TranslatorFactory.create("t").translate("5523457634");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForTooLongNumber() {

        String expected = "Bu sayıları çeviremiyorum. Lütfen daha küçük bir sayı giriniz.";
        String result = TranslatorFactory.create("t").translate("5523457634777777");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForNegative() {

        String expected = "Eksi(-)BeşBinKırkDokuz";
        String result = TranslatorFactory.create("t").translate("-5049");

        assertEquals(expected, result);
        }
}