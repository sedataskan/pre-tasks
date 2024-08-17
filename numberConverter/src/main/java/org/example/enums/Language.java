package org.example.enums;

import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

public enum Language {
    e("e", new NumberTranslatorEn()),
    t("t", new NumberTranslatorTr());

    private final String code;
    private final NumberTranslator translator;

    Language(String code, NumberTranslator translator) {
        this.code = code;
        this.translator = translator;
    }
}
