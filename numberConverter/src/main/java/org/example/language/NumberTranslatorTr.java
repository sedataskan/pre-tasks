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
        String[] tens = {"on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] postfix = {"", "yüz", "bin", "milyon", "milyar", "trilyon"};

        String numberAsString = String.valueOf(input);

        int digitNumber = (int)Math.log10(input) + 1;

        if (digitNumber % 3 == 1){
            numberAsString = "00" + numberAsString;
        }else if (digitNumber % 3 == 2){
            numberAsString = "0" + numberAsString;
        }

        String[] coupleOfDigits =  numberAsString.split("(?<=\\G.{"+3+"})");
        System.out.println("coupleOfDigits: " + Arrays.toString(coupleOfDigits));

        List<String> numberAsStr = new ArrayList<>();

        int hundred = 0;
        int ten = 0;
        int one = 0;

        for (int i = 0; i<coupleOfDigits.length ; i++){
            System.out.println(coupleOfDigits[i]);
            hundred = Character.getNumericValue(coupleOfDigits[i].charAt(0));
            System.out.println(hundred);
            ten = Character.getNumericValue(coupleOfDigits[i].charAt(1));
            one = Character.getNumericValue(coupleOfDigits[i].charAt(2));
            String power = postfix[i];

            numberAsStr.add(ones[hundred] + " " + power + " " + tens[ten] + " " + ones[one]);
        }


        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch.trim()).append(" ");
        }

        return translatedNumber.toString().replaceAll("\\s+"," ").trim();
    }
}
