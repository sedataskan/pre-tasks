package org.example.language;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] ten = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] power = {"", "ten", "hundred", "thousand", "million", "billion", "trillion"};

        List<String> numberAsStr = new ArrayList<>();

        int digitNumber = (int)Math.log10(input) + 1;

        switch(digitNumber){
            case 1:
                numberAsStr.add(ones[input]);
                break;
            case 2:
                if (input >= 10 && input < 20) {
                    numberAsStr.add(ten[input%10]);
                } else {
                    numberAsStr.add(tens[input/10] + " " + ones[input % 10]);
                }
                break;
            case 3:
                if (input%100 >= 10 && input%100 < 20) {
                    numberAsStr.add(ones[(input/100)] + " " + power[2] + " " + ten[input%10]);
                }
                else {
                    numberAsStr.add(ones[(input/100)] + " " + power[2] + " " + tens[(input/10)%10] + " " + ones[input%10]);
                }
                break;
            case 4:
                if (input%100 >= 10 && input%100 < 20) {
                    numberAsStr.add(ones[(input/1000)] + " " + power[3] + " " + ten[input%10]);
                }
                else{
                    numberAsStr.add(ones[(input/1000)] + " " + power[3] + " " + ones[(input/100)%10] + " " + power[2] + " " + tens[(input/10)%10] + " " + ones[input%10]);
                }
                break;
            default:
                if (input == 0){
                    numberAsStr.add("zero");
                } else{
                    numberAsStr.add("Something went wrong");
                }
                break;
        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch).append(" ");
        }

        return translatedNumber.toString().replaceAll("\\s+"," ").trim();
    }
}
