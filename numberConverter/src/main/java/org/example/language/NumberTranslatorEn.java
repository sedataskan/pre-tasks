package org.example.language;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] ten = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] power = {"", "", "hundred", "thousand", "million", "billion", "trillion"};

        List<String> numberAsStr = new ArrayList<>();
        int digitNum = 0;

        if (input == 0) {
            numberAsStr.add("zero");
        }

        while (input > 0) {
            int digit = input % 10;

            if (digitNum == 0) {
                numberAsStr.addFirst(ones[digit]);
            } else if (digitNum == 1) {
                numberAsStr.addFirst(tens[digit]);
            } else if (digitNum > 1) {
                numberAsStr.addFirst(ones[digit] +  " " + power[digitNum]);
            }

            digitNum = digitNum + 1;
            input /= 10;
        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch).append(" ");
        }

        return translatedNumber.toString();
    }
}
