package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  // Need way to update from Game to CPU to TopStrategy
  private Integer humanOdd;
  private Integer humanEven;
  private Choice choice;

  public TopStrategy(Integer humanEven, Integer humanOdd, Choice choice) {
    this.humanEven = humanEven;
    this.humanOdd = humanOdd;
    this.choice = choice;
  }

  @Override
  public Integer getFingers() {

    // Change expected output based on previous encounters with human
    if (humanEven > humanOdd) {
      if (choice == Main.Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else if (humanEven < humanOdd) {
      if (choice == Main.Choice.ODD) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
