package se.abc.wager;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.DoubleStream;

final class BettingOdds {

    /* This class is a function bundle. It should not be instantiated. */
    private BettingOdds() {
    }

    /**
     * Fractional odds, a/b, quote the net total, a, that will be paid
     * out to the bettor, should he or she win, relative to the stake, b.
     * <p>
     * The implied probability, P, is calculated using the following
     * formula:
     * <p>
     * P = b/(a+b)
     */
    static double implied(Fraction fraction) {
        return (double) fraction.getDenominator()
                / (fraction.getNumerator() + fraction.getDenominator());
    }

    /**
     * The amount by which the sum of the implied probabilities exceeds 1
     * is known as the 'over-round'. In order to compensate for the
     * over-round and obtain fair probabilities, we normalize the implied
     * probabilities by dividing them by the total.
     */
    static DoubleStream normalize(double[] implied) {
        double sum = Arrays.stream(implied).sum();
        return Arrays.stream(implied).map(d -> d / sum);
    }

    static Function<String, Double> converter(String odds) throws IllegalArgumentException {
        if (odds.contains("/"))
            return s -> implied(new Fraction(s)); /* Fractional odds. */
        if (odds.contains("."))
            return s -> 1 / Double.parseDouble(s); /* Decimal odds. */
        throw new IllegalArgumentException(String.format("Unsupported odds type: %s.", odds));
    }
}
