package org.example;

import org.example.factory.TranslatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testTranslateOnOtherLangInputs() {
        assertThrows(IllegalArgumentException.class, () -> TranslatorFactory.create("f"));
    }
}