package org.example.product;

import org.example.enums.Language;
import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTranslatorEnTest {
    @Test
    void testTranslateEnglishForZero() {

        String expected = "Zero";
        String result = TranslatorFactory.create(Language.e).translate(0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForOneDigit() {

        String expected = "Two";
        String result = TranslatorFactory.create(Language.e).translate(2);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigitsTen() {

        String expected = "Fifteen";
        String result = TranslatorFactory.create(Language.e).translate(15);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigits() {

        String expected = "SixtySeven";
        String result = TranslatorFactory.create(Language.e).translate(67);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigits() {

        String expected = "OneHundredThirtySeven";
        String result = TranslatorFactory.create(Language.e).translate(137);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigitsTen() {

        String expected = "TwoHundredNineteen";
        String result = TranslatorFactory.create(Language.e).translate(219);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigitsTen() {

        String expected = "TwoThousandSixHundredFourteen";
        String result = TranslatorFactory.create(Language.e).translate(2614);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigits() {

        String expected = "OneThousandNineHundredSeven";
        String result = TranslatorFactory.create(Language.e).translate(1907);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFiveDigits() {

        String expected = "TenThousandTen";
        String result = TranslatorFactory.create(Language.e).translate(10010);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForBigger() {

        String expected = "TwoBillionOneHundredFortySevenMillionFourHundredEightyThreeThousandSixHundredFortySeven";
        String result = TranslatorFactory.create(Language.e).translate(2147483647);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForNegative() {

        String expected = "Minus(-) OneHundredFiftyNine";
        String result = TranslatorFactory.create(Language.e).translate(-159);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFraction() {

        String expected = "One Point Two";
        String result = TranslatorFactory.create(Language.e).translate(1.2);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFractionZero() {

        String expected = "One";
        String result = TranslatorFactory.create(Language.e).translate(1.0);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFractionTen() {

        String expected = "One Point Ten";
        String result = TranslatorFactory.create(Language.e).translate(1.10);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFractionTwoDigits() {

        String expected = "One Point TwentyThree";
        String result = TranslatorFactory.create(Language.e).translate(1.23);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFractionThreeDigits() {

        String expected = "One Point TwentyFour";
        String result = TranslatorFactory.create(Language.e).translate(1.235);

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFractionAndNegative() {

        String expected = "Minus(-) One Point TwentyThree";
        String result = TranslatorFactory.create(Language.e).translate(-1.234);

        assertEquals(expected, result);
    }
}
