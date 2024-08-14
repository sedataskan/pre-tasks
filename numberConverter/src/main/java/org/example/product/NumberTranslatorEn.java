package org.example.product;

import org.example.util.GetStringFromInput;
import org.example.util.GetStringFromList;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "zero";
        }

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] ten = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] postfix = {"", "hundred", "thousand", "million", "billion", "trillion"};

        List<String> coupleOfDigit = GetStringFromInput.getStringFromInput(input);

        int len = coupleOfDigit.size();
        int digitHundred;
        int digitTen;
        int digitOne;
        String hund;
        String power;

        List<String> stringNumbers = new ArrayList<>();

        for (int i = 0; i < coupleOfDigit.size(); i++, len--) {
            digitHundred = Character.getNumericValue(coupleOfDigit.get(i).charAt(0));
            digitTen = Character.getNumericValue(coupleOfDigit.get(i).charAt(1));
            digitOne = Character.getNumericValue(coupleOfDigit.get(i).charAt(2));

            hund = digitHundred == 0 ? " " : postfix[1];
            power = len > 1 ? postfix[len] : "";

            if (digitTen == 1) {
                stringNumbers.add(ones[digitHundred] + " " + hund + " " + ten[digitOne] + " " + power);
            } else {
                stringNumbers.add(ones[digitHundred] + " " + hund + " " + tens[digitTen] + " " + ones[digitOne] + " " + power);
            }
        }

        String translatedNumber = GetStringFromList.getStringFromList(stringNumbers);

        return translatedNumber
                .replaceAll("\\s+"," ")
                .trim();
    }
}
