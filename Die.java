import java.util.Random;

/**
 * A simple class for representing die objects. A die has a given number of
 * sides (at least) four, set when the die is constructed and which can never
 * be changed. The die's value can be changed, but only by calling its roll()
 * method.
 */
public class Die {
    private static Random random = new Random();

    // TODO: Add fields

    /**
     * Constructs a die with the given number of sides and starting value.
     * @throws IllegalArgumentException if the number of sides is less than 4 or
     * if the starting value is not consistent with the number of sides.
     */
    public Die(int sides, int value) {
        // TODO
    }

    /**
     * Simulates a roll by randomly updating the value of this die. In addition to
     * mutating the die's value, this method also returns the new updated value.
     */
    public int roll() {
        // TODO
    }

    /**
     * Returns the number of sides of this die.
     */
    public int getSides() {
        // TODO
    }

    /**
     * Returns the value of this die.
     */
    public int getValue() {
        // TODO
    }

    /**
     * Returns a description of this die, which is its value enclosed in square
     * brackets, without spaces, for example "[5]".
     */
    @Override public String toString() {
        // TODO
    }
}
