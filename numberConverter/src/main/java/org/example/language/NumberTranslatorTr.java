package org.example.language;

import java.util.ArrayList;
import java.util.List;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        String[] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        String[] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
        String[] power = {"", "on", "yüz", "bin", "milyon", "milyar", "trilyon"};

        int digitNumber = (int)Math.log10(input) + 1;

        List<String> numberAsStr = new ArrayList<>();

        switch(digitNumber){
            case 1:
                numberAsStr.add(ones[input]);
                break;
            case 2:
                numberAsStr.add(tens[input/10] + " " + ones[input % 10]);
                break;
            case 3:
                numberAsStr.add(ones[(input/100)] + " " + power[2] + " " + tens[(input/10)%10] + " " + ones[input%10]);
                break;
            case 4:
                numberAsStr.add(ones[(input/1000)] + " " + power[3] + " " + ones[(input/100)%10] + " " + power[(input/100)%10] + " " + tens[(input/10)%10] + " " + ones[input%10]);
                break;
            default:
                if (input == 0){
                    numberAsStr.add("sıfır");
                } else{
                    numberAsStr.add("Bir şeyler ters gitti");
                }
                break;
        }

        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : numberAsStr) {
            translatedNumber.append(ch.trim()).append(" ");
        }

        return translatedNumber.toString().replaceAll("\\s+"," ").trim();
    }
}
