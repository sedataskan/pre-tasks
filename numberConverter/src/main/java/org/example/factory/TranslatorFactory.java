package org.example.factory;

import org.example.enums.Language;
import org.example.product.NumberTranslator;
import org.example.product.NumberTranslatorEn;
import org.example.product.NumberTranslatorTr;

import java.util.HashMap;
import java.util.Map;

public class TranslatorFactory {
    private static final Map<Language, NumberTranslator> translators = new HashMap<>();

    static {
        translators.put(Language.e, new NumberTranslatorEn());
        translators.put(Language.t, new NumberTranslatorTr());
    }

    public static NumberTranslator create(Language code) {
        if (translators.containsKey(code)) {
            return translators.get(code);
        } else {
            throw new IllegalArgumentException("Unsupported language: " + code);
        }
    }
}
