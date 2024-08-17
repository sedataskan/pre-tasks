package org.example.product;

import org.example.util.NumberParser;
import java.util.Objects;

public class NumberTranslatorTr implements NumberTranslator {

    public String[] translate() {
        return new String[]{" Nokta ", "Eksi(-) "};
    }
    public String translate(int intInput) {

        String input = String.valueOf(intInput);

        String[] ones = {"", "Bir", "İki", "Üç", "Dört", "Beş", "Altı", "Yedi", "Sekiz", "Dokuz"};
        String[] tens = {"", "On", "Yirmi", "Otuz", "Kırk", "Elli", "Altmış", "Yetmiş", "Seksen", "Doksan"};
        String[] postfix = {"", "Bin", "Milyon", "Milyar"};

        var sb = new StringBuilder();

        if(input.contains("-")){
            input = input.replace("-", "");
            sb.append(translate()[1]);
        }

        if (Objects.equals(input, "0")){
            return "Sıfır";
        } else if (input.equals("1")) {
            return sb + "Bir";
        }

        var triples = NumberParser.parseAsTriple(input);

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
                //TODO: ingilizcede de olan bir durum var
                //TODO: 1.2 -> one point two gibi okunuyor ama biz şu an 1.20 -> one point twenty gibi okuyoruz
                //TODO: bu durumu düzeltmek için bir kontrol yapılmalı -> nedeni 100 ile çarpmak
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
