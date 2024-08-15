package org.example.product;

import org.example.util.NumberParser;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0) {
            return "Sıfır";
        }

        String[] ones = {"", "Bir", "İki", "Üç", "Dört", "Beş", "Altı", "Yedi", "Sekiz", "Dokuz"};
        String[] tens = {"", "On", "Yirmi", "Otuz", "Kırk", "Elli", "Altmış", "Yetmiş", "Seksen", "Doksan"};
        String[] postfix = {"Bin", "Milyon", "Milyar", "Trilyon"};

        var triples = NumberParser.parseAsTriple(input);

        var sb = new StringBuilder();

        System.out.println(triples);

        for (int i = 0; i < triples.size(); i++) {
            var digitHundred = Character.getNumericValue(triples.get(i).charAt(0));
            var digitTen = Character.getNumericValue(triples.get(i).charAt(1));
            var digitOne = Character.getNumericValue(triples.get(i).charAt(2));

            if (digitHundred > 0) {
                if (digitHundred > 1)
                    sb.append(ones[digitHundred]);
                sb.append("Yüz");
            }
            if (digitTen > 0) {
                sb.append(tens[digitTen]);
            }
            if (digitOne > 0) {
                if (digitOne == 1 && digitHundred == 0 && digitTen == 0 && i<1){
                    sb.append("Bir");
                } else {
                    sb.append(ones[digitOne]);
                }
            }
            if (i > 0) {
                sb.append(postfix[i-1]);
            }
        }
        return sb.toString();
    }
}
