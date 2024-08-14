package org.example.product;

import org.example.util.TranslatorLogic;


public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "zero";
        }

        String result = TranslatorLogic.logic("e", input);

        return result
                .replaceAll("\\s+"," ")
                .trim();
    }
}
