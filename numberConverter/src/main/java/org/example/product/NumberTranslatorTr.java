package org.example.product;

import org.example.util.GetStringFromInput;
import org.example.util.GetStringFromList;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "sıfır";
        }

        String[] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] postfix = {"", "yüz", "bin", "milyon", "milyar", "trilyon"};

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
            
            stringNumbers.add(ones[digitHundred] + " " + hund + " " + tens[digitTen] + " " + ones[digitOne] + " " + power);
        }

        String translatedNumber = GetStringFromList.getStringFromList(stringNumbers);

        return translatedNumber
                .replaceAll("\\s+"," ")
                .trim()
                .replace("bir yüz", "yüz")
                .replace("bir bin", "bin");
    }
}
