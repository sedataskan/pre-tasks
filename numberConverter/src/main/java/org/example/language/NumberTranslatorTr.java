package org.example.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] postfix = {"", "yüz", "bin", "milyon", "milyar", "trilyon"};

        String numberAsString = String.valueOf(input);

        if (input == 0){
            return "sıfır";
        }

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
        };

        coupleOfDigits = reversed;

        List<String> numberAsStr = new ArrayList<>();

        int hundred = 0;
        int ten = 0;
        int one = 0;
        String power = "";

        for (int i = 0; i<coupleOfDigits.size() ; i++){
            hundred = Character.getNumericValue(coupleOfDigits.get(i).charAt(0));
            ten = Character.getNumericValue(coupleOfDigits.get(i).charAt(1));
            one = Character.getNumericValue(coupleOfDigits.get(i).charAt(2));

            if(i == 1){
                power = postfix[2];
            } else if (i == 2) {
                power = postfix[3];
            } else if (i == 3) {
                power = postfix[4];
            } else if (i == 4) {
                power = postfix[5];
            }

            String hund = "";
            if(hundred == 0){
                hund = "";
            }else {
                hund = postfix[1];
            }

            numberAsStr.addFirst(ones[hundred] + " " + hund + " " + tens[ten] + " " + ones[one] + " " + power);
        }


        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch.trim()).append(" ");
        }

        return translatedNumber.toString()
                .replaceAll("\\s+"," ")
                .trim()
                .replace("bir yüz", "yüz")
                .replace("bir bin", "bin");
    }
}
