package org.example.factory;

import org.example.enums.Language;
import org.example.product.NumberTranslator;

public class TranslatorFactory {
    public static NumberTranslator create(String langCode) {

        return Language.getTranslator(langCode);
    }
}
