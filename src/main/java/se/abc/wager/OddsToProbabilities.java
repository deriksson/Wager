package se.abc.wager;

import java.util.Arrays;

import static se.abc.wager.BettingOdds.converter;
import static se.abc.wager.BettingOdds.normalize;

/**
 * Calculates true probabilities from fractional or decimal odds.
 */
final class OddsToProbabilities {

    /*
     * This class is a program entry point and will not be instantiated.
     */
    private OddsToProbabilities() {
    }

    public static void main(String[] args) {
        try {
            normalize(Arrays.stream(args).mapToDouble(s -> converter(s).apply(s)).toArray())
                    .forEach(d -> System.out.printf("%.2f%n", d));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Incomplete fraction.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
