package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadderTest {

    @Test
    void leftPaddingWithOneDigit() {
        assertEquals("001", Padder.leftPadding("1", 1));
    }

    @Test
    void leftPaddingWithTwoDigits() {
        assertEquals("012", Padder.leftPadding("12", 2));
    }

    @Test
    void leftPaddingWithThreeDigits() {
        assertEquals("123", Padder.leftPadding("123", 3));
    }
}