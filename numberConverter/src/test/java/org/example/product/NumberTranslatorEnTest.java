package org.example.product;

import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTranslatorEnTest {
    @Test
    void testTranslateEnglishForZero() {

        String expected = "Zero";
        String result = TranslatorFactory.create("e").translate("0");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForOneDigit() {

        String expected = "Two";
        String result = TranslatorFactory.create("e").translate("2");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigitsTen() {

        String expected = "Fifteen";
        String result = TranslatorFactory.create("e").translate("15");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTwoDigits() {

        String expected = "SixtySeven";
        String result = TranslatorFactory.create("e").translate("67");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigits() {

        String expected = "OneHundredThirtySeven";
        String result = TranslatorFactory.create("e").translate("137");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForThreeDigitsTen() {

        String expected = "TwoHundredNineteen";
        String result = TranslatorFactory.create("e").translate("219");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigitsTen() {

        String expected = "TwoThousandSixHundredFourteen";
        String result = TranslatorFactory.create("e").translate("2614");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFourDigits() {

        String expected = "OneThousandNineHundredSeven";
        String result = TranslatorFactory.create("e").translate("1907");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForFiveDigits() {

        String expected = "TenThousandTen";
        String result = TranslatorFactory.create("e").translate("10010");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForBigger() {

        String expected = "FiveBillionFiveHundredTwentyThreeMillionFourHundredFiftySevenThousandSixHundredThirtyFour";
        String result = TranslatorFactory.create("e").translate("5523457634");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForTooLongNumber() {

        String expected = "I cannot translate these numbers. Please enter a smaller number.";
        String result = TranslatorFactory.create("e").translate("5523457634777777");

        assertEquals(expected, result);
    }

    @Test
    void testTranslateEnglishForNegative() {

        String expected = "Minus(-)OneHundredFiftyNine";
        String result = TranslatorFactory.create("e").translate("-159");

        assertEquals(expected, result);
    }
}
