package org.example.util;

import org.example.enums.EngNumberWords;
import org.example.enums.Language;
import org.example.enums.TrNumberWords;

import java.util.ArrayList;
import java.util.List;

public class TranslatorLogic {
    public static String logic(Language lang, int input){

        String[] ones;
        String[] ten = null;
        String[] tens;
        String[] postfix;

        if(lang == Language.e){
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

        int digitNumber = (int)Math.log10(input) + 1;

        if (digitNumber % 3 == 1){
            numberAsString = "00" + numberAsString;
        }else if (digitNumber % 3 == 2){
            numberAsString = "0" + numberAsString;
        }

        List<String> coupleOfDigits = List.of(numberAsString.split("(?<=\\G.{" + 3 + "})"));

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

            if(digitTen == 1 && lang == Language.e){
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
