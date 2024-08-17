package org.example.factory;

import org.example.enums.Language;
import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

public class TranslatorFactory {
    public static NumberTranslator create(Language language) {
        switch (language) {
            case ENGLISH -> {
                return new NumberTranslatorEn();
            }
            case TURKISH -> {
                return new NumberTranslatorTr();
            }
            default -> {
                throw new IllegalArgumentException("Unsupported language: " + language);
            }
        }
    }
}
