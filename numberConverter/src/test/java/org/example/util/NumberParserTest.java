package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberParserTest {

    @Test
    void parseAsTripleWithOneDigit() {
        var actual =NumberParser.parseAsTriple("1");
        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals("001", actual.getFirst());
    }

    @Test
    void parseAsTripleWithNegativeOneDigit() {
        var actual =NumberParser.parseAsTriple("-1");
        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals("001", actual.getFirst());
    }
    @Test
    void parseAsTripleWith4Digit() {
        var actual =NumberParser.parseAsTriple("1234");
        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals("001", actual.getFirst());
        assertEquals("234", actual.get(1));
    }
}