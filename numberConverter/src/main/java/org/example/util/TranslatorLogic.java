package org.example.util;

import org.example.enums.EngNumberWords;
import org.example.enums.TrNumberWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TranslatorLogic {
    public static String logic(String lang, int input){

        //get words from languages enum list
        String[] ones;
        String[] ten = null;
        String[] tens;
        String[] postfix;

        if(Objects.equals(lang, "e")){
            ones = EngNumberWords.ONES.getEngNumberWords();
            ten = EngNumberWords.TEN.getEngNumberWords();
            tens = EngNumberWords.TENS.getEngNumberWords();
            postfix = EngNumberWords.POSTFIX.getEngNumberWords();
        } else {
            ones = TrNumberWords.ONES.getTrNumberWords();
            tens = TrNumberWords.TENS.getTrNumberWords();
            postfix = TrNumberWords.POSTFIX.getTrNumberWords();
        }
        String numberAsString = String.valueOf(input);

        //find digit count
        int digitNumber = (int)Math.log10(input) + 1;

        //we will use each three digits as a group like 1.234.567
        //so convert number to divisible by 3
        if (digitNumber % 3 == 1){
            numberAsString = "00" + numberAsString;
        }else if (digitNumber % 3 == 2){
            numberAsString = "0" + numberAsString;
        }
        List<String> coupleOfDigits = List.of(numberAsString.split("(?<=\\G.{" + 3 + "})"));

        // 123456 gets -> 456 123 so we reversed
        List<String> reversed = new ArrayList<>();

        for (int i = coupleOfDigits.size(); i > 0; i--) {
            reversed.add(coupleOfDigits.get(i - 1));
        }

        coupleOfDigits = reversed;

        List<String> numberAsStr = new ArrayList<>();

        int digitHundred;
        int digitTen;
        int digitOne;
        String power = "";

        for (int i = 0; i<coupleOfDigits.size() ; i++){
            digitHundred = Character.getNumericValue(coupleOfDigits.get(i).charAt(0));
            digitTen = Character.getNumericValue(coupleOfDigits.get(i).charAt(1));
            digitOne = Character.getNumericValue(coupleOfDigits.get(i).charAt(2));

            if(i == 1){
                power = postfix[2];
            } else if (i == 2) {
                power = postfix[3];
            } else if (i == 3) {
                power = postfix[4];
            } else if (i == 4) {
                power = postfix[5];
            }

            String hund;
            if(digitHundred == 0){
                hund = "";
            }else {
                hund = postfix[1];
            }

            if(digitTen == 1 && Objects.equals(lang, "e")){
                numberAsStr.addFirst(ones[digitHundred] + " " + hund + " " + ten[digitOne] + " " + power);
            }
            else {
                numberAsStr.addFirst(ones[digitHundred] + " " + hund + " " + tens[digitTen] + " " + ones[digitOne] + " " + power);
            }
        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch.trim()).append(" ");
        }

        return translatedNumber.toString();
    }
}
