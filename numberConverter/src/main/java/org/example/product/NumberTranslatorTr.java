package org.example.product;

import org.example.util.TranslatorLogic;

public class NumberTranslatorTr implements NumberTranslator {

    @Override
    public String translate(int input) {

        if (input == 0){
            return "sıfır";
        }

        String result = TranslatorLogic.logic("t", input);

        return result
                .replaceAll("\\s+"," ")
                .trim()
                .replace("bir yüz", "yüz")
                .replace("bir bin", "bin");
    }
}
