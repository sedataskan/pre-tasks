package org.example.enums;

import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

public enum Language {
    ENGLISH("e"),
    TURKISH("t");
    private final String code;

    Language(String code) {
        this.code = code;
    }


}
