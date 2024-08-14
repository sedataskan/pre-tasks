package org.example.product;

import org.example.enums.Language;
import org.example.util.TranslatorLogic;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "sıfır";
        }

        Language lang = Language.t;
        String result = TranslatorLogic.logic(lang, input);

        return result
                .replaceAll("\\s+"," ")
                .trim()
                .replace("bir yüz", "yüz")
                .replace("bir bin", "bin");
    }
}
