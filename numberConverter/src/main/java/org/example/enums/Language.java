package org.example.enums;

import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

public enum Language {
    ENGLISH("e", new NumberTranslatorEn()),
    TURKISH("t", new NumberTranslatorTr());

    private final String code;
    private final NumberTranslator translator;

    Language(String code, NumberTranslator translator) {
        this.code = code;
        this.translator = translator;
    }

    public static NumberTranslator getTranslator(String code) {
        for (Language lang : values()) {
            if (lang.code.equals(code)) {
                return lang.translator;
            }
        }
        throw new IllegalArgumentException("Unsupported language: " + code);
    }
}
