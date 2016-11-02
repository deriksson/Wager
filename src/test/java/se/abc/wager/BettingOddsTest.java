package se.abc.wager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.abc.wager.BettingOdds.*;

public class BettingOddsTest {

    @Test
    void testNormalization() {
        assertEquals(1.0, normalize(new double[]{0.6, 0.6}).sum());
    }

    @Test
    void testImpliedOdds() {
        assertEquals(.75, implied(new Fraction("1/3")));
    }

    @Test
    void testDecimalOdds() {
        assertEquals(new Double(.2), converter("5.0").apply("5.0"));
    }
}
