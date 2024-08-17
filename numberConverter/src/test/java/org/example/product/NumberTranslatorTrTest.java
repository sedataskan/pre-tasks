package org.example.product;

import org.example.enums.Language;
import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTranslatorTrTest {

    @Test
    void testTranslateTurkishForZero() {

        String expected = "Sıfır";
        String result = TranslatorFactory.create(Language.t).translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForOneDigit() {
        String expected = "Üç";
        String result = TranslatorFactory.create(Language.t).translate(3);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForTwoDigits() {
        String expected = "OtuzBeş";
        String result = TranslatorFactory.create(Language.t).translate(35);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForThreeDigits() {

        String expected = "ÜçYüzYirmiDört";
        String result = TranslatorFactory.create(Language.t).translate(324);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits() {

        String expected = "İkiBinAltıYüzOnDört";
        String result = TranslatorFactory.create(Language.t).translate(2614);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFourDigits1001() {

        String expected = "BinBir";
        String result = TranslatorFactory.create(Language.t).translate(1001);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFiveDigits() {

        String expected = "YirmiBinOnBeş";
        String result = TranslatorFactory.create(Language.t).translate(20015);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForBigger() {

        String expected = "İkiMilyarYüzKırkYediMilyonDörtYüzSeksenÜçBinAltıYüzKırkYedi";
        String result = TranslatorFactory.create(Language.t).translate(2147483647);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForNegative() {

        String expected = "Eksi(-) BeşBinKırkDokuz";
        String result = TranslatorFactory.create(Language.t).translate(-5049);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFraction() {

        String expected = "Bir Nokta İki";
        String result = TranslatorFactory.create(Language.t).translate(1.2);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFractionZero() {

        String expected = "Bir";
        String result = TranslatorFactory.create(Language.t).translate(1.0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFractionTen() {

        String expected = "Bir Nokta On";
        String result = TranslatorFactory.create(Language.t).translate(1.10);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFractionTwoDigits() {

        String expected = "Bir Nokta YirmiÜç";
        String result = TranslatorFactory.create(Language.t).translate(1.23);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFractionThreeDigits() {

        String expected = "Bir Nokta YirmiDört";
        String result = TranslatorFactory.create(Language.t).translate(1.235);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateTurkishForFractionAndNegative() {

        String expected = "Eksi(-) Bir Nokta YirmiÜç";
        String result = TranslatorFactory.create(Language.t).translate(-1.234);

        assertEquals(expected, result);
    }
}