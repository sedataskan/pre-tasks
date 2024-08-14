package org.example.product;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] postfix = {"", "yüz", "bin", "milyon", "milyar", "trilyon"};

        if (input == 0){
            return "sıfır";
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

            numberAsStr.addFirst(ones[digitHundred] + " " + hund + " " + tens[digitTen] + " " + ones[digitOne] + " " + power);

        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch.trim()).append(" ");
        }

        return translatedNumber
                .toString()
                .replaceAll("\\s+"," ")
                .trim()
                .replace("bir yüz", "yüz")
                .replace("bir bin", "bin");
    }
}
