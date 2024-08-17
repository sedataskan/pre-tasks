package org.example.product;

import org.example.util.NumberParser;
import java.util.Objects;

public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (Objects.equals(input, "0")){
            return "Zero";
        }

        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] ten = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] postfix = {"", "Thousand", "Million", "Billion", "Trillion"};

        var sb = new StringBuilder();

        if(input.contains("-")){
            input = input.replace("-", "");
            sb.append("Minus(-)");
        }

        var triples = NumberParser.parseAsTriple(input);
        if (triples.size() > postfix.length) {
            return "I cannot translate these numbers. Please enter a smaller number.";
        }

        for (int i = 0; i < triples.size(); i++) {
            var digitHundred = Character.getNumericValue(triples.get(i).charAt(0));
            var digitTen = Character.getNumericValue(triples.get(i).charAt(1));
            var digitOne = Character.getNumericValue(triples.get(i).charAt(2));

            if (digitHundred > 0) {
                sb.append(ones[digitHundred]);
                sb.append("Hundred");
            }
            if (digitTen > 1) {
                sb.append(tens[digitTen]);
            }
            if (digitTen == 1) {
                sb.append(ten[digitOne]);
            }
            if (digitOne > 0 && digitTen != 1) {
                sb.append(ones[digitOne]);
            }
            sb.append(postfix[triples.size() - i - 1]);
        }
        return sb.toString();
    }
}
