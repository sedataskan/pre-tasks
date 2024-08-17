package org.example.factory;

import org.example.enums.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorFactoryTest {

    @Test
    void testTranslateOnOtherLangInputs() {
        assertThrows(IllegalArgumentException.class, () -> TranslatorFactory.create(Language.valueOf("f")));
    }
}