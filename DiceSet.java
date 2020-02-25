import java.util.ArrayList;
import java.util.List;

public class DiceSet {

    private Die[] dice;
    
    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        this.dice = new Die[numberOfDice];
        for (int i = 0; i < dice.length; i++) {
            this.dice[i] = new Die(sidesOnEachDie, 1);
        }
        if (numberOfDice < 2) {
            throw new IllegalArgumentException("At least two dice required");
        }
        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
        }
    }

    public DiceSet(int sidesOnEachDie, int... values) {
        if (values.length < 2) {
            throw new IllegalArgumentException("At least two dice required");
          }
          if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
          }
    
          this.dice = new Die[values.length];
          for(int i = 0; i < values.length; i++){
              this.dice[i] = new Die(sidesOnEachDie,values[i]);
          }
    }

    public String descriptor() {
        return this.dice.length + "d" + this.dice[0].getSides();
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i <this.dice.length; i ++) {
            sum += this.dice[i].getValue();
        }
        return sum;
    }

    public void rollAll() {
        for (int i = 0; i < this.dice.length; i++){
            this.dice[i].roll();
        }
        
    }

    public void rollIndividual(int i) {
        this.dice[i].roll();
    }

    public int getIndividual(int i) {
        return this.dice[i].getValue();
    
    }

    public List<Integer> values() {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i <this.dice.length; i++) {
            values.add(dice[i].getValue());
        }
        return values;
    }

    public boolean isIdenticalTo(DiceSet diceSet) {
        return true;
    }

    @Override public String toString() {
        var connect = "";
        for (var d: this.dice){
            connect += "[" +d.getValue() + "]";
        }
        return connect;
    }
}
