package org.example.factory;

import org.example.enums.Language;
import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

public class TranslatorFactory {
    public static NumberTranslator create(String langCode) {

        Language lang = Language.valueOf(langCode);
        return switch (lang) {
            case e -> new NumberTranslatorEn();
            case t -> new NumberTranslatorTr();
        };
    }
}
