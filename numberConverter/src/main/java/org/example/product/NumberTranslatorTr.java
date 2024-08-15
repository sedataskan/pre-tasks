package org.example.product;

import org.example.util.NumberParser;
import java.util.Objects;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(String input) {

        if (Objects.equals(input, "0")) {
            return "Sıfır";
        }

        String[] ones = {"", "Bir", "İki", "Üç", "Dört", "Beş", "Altı", "Yedi", "Sekiz", "Dokuz"};
        String[] tens = {"", "On", "Yirmi", "Otuz", "Kırk", "Elli", "Altmış", "Yetmiş", "Seksen", "Doksan"};
        String[] postfix = {"", "Bin", "Milyon", "Milyar", "Trilyon"};

        var sb = new StringBuilder();

        if(input.contains("-")){
            input = input.replace("-", "");
            sb.append("Eksi(-)");
        }

        var triples = NumberParser.parseAsTriple(input);

        if (triples.size() > postfix.length) {
            return "Bu sayıları çeviremiyorum. Lütfen daha küçük bir sayı giriniz.";
        }
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
                if (i != 0 || digitOne != 1) {
                    sb.append(ones[digitOne]);
                }
            }
            sb.append(postfix[triples.size() - i - 1]);
        }
        return sb.toString();
    }
}
