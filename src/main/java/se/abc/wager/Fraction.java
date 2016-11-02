package se.abc.wager;

final class Fraction {

    private final int numerator;
    private final int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private Fraction(String[] fraction) {
        this(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));
    }

    Fraction(String fraction) {
        this(fraction.split("/"));
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
