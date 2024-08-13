package org.example.language;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] power = {"", "on", "yüz", "bin", "milyon", "milyar", "trilyon"};

        List<String> numberAsStr = new ArrayList<>();

        //digit counter
        int digitCount = 0;
        while (input>0) {
            input /= 10;
            ++digitCount;
        }

        if (input == 0) {
            numberAsStr.add("sıfır");
        }

        while (digitCount > 0){
            //TODO need a new logic
        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch).append(" ");
        }

        return translatedNumber.toString();
    }
}
