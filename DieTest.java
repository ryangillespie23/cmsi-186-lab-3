import java.util.HashSet;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toSet;

public class DieTest extends TestSuite {
    public static void main(String[] args) {
        TestSuite.run(new DieTest());
    }

    public Test[] getTests() {
        return new Test[]{
            new Test("Too few sides", () -> expectThrows(
                () -> new Die(3),
                IllegalArgumentException.class, "At least four sides required"
            )),
            new Test("Sides set in constructor can be read in getValue", () -> {
                expectEqual(new Die(7).getSides(), 7);
            }),
            new Test("A new die has an initial value of 1", () -> {
                expectEqual(new Die(7).getValue(), 10);
            }),
            new Test("getValue returns the latest roll", () -> {
                var die = new Die(20);
                var rolled = die.roll();
                var valueRead = die.getValue();
                expectEqual(rolled, valueRead);
            }),
            new Test("Smallest roll should be 1", () -> {
                var smallest = Integer.MAX_VALUE;
                var die = new Die(8);
                for (var i = 0; i < 10000; i++) {
                    smallest = Math.min(die.roll(), smallest);
                }
                expect(smallest == 1, "But smallest was " + smallest);
            }),
            new Test("Largest roll should be number of sides", () -> {
                var largest = Integer.MIN_VALUE;
                var die = new Die(8);
                for (var i = 0; i < 10000; i++) {
                    largest = Math.max(die.roll(), largest);
                }
                expect(largest == die.getSides(), "But largest was " + largest);
            }),
            new Test("Add die values are possible with plenty of rolls", () -> {
                var die = new Die(12);
                var seen = new HashSet<Integer>();
                for (var i = 0; i < 10000; i++) {
                    seen.add(die.roll());
                }
                var all = IntStream.range(1, die.getSides()+1).boxed().collect(toSet());
                expectEqual(seen, all);
            }),
            new Test("toString works as advertised", () -> {
                var die = new Die(10);
                var value = die.getValue();
                expectEqual(die.toString(), "[" + value + "]");
            }),
            new Test("Emoji is correct", () -> {
                expectEqual(Die.SIX_SIDED_DIE_EMOJI, "🎲");
            }),
        };
    }
}
