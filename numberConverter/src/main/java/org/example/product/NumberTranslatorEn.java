package org.example.product;

import org.example.enums.Language;
import org.example.util.TranslatorLogic;


public class NumberTranslatorEn implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "zero";
        }

        Language lang = Language.e;
        String result = TranslatorLogic.logic(lang, input);

        return result
                .replaceAll("\\s+"," ")
                .trim();
    }
}
