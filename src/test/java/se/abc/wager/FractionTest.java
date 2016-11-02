package se.abc.wager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    @Test
    void testParsing() {
        assertEquals(2, new Fraction("1/2").getDenominator());
    }
}
