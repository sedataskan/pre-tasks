package org.example.factory;

import org.example.language.NumberTranslator;
import org.example.language.NumberTranslatorEn;
import org.example.language.NumberTranslatorTr;

public class TranslatorFactory {
    public static NumberTranslator create(String langCode) {
        return switch (langCode) {
            case "e" -> new NumberTranslatorEn();
            case "t" -> new NumberTranslatorTr();
            default -> throw new IllegalArgumentException("Language not recognized");
        };
    }
}
