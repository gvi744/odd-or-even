package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Top Strategy takes into account the amount of times the human has played an EVEN or ODD number
 * and predicts accordingly.
 */
public class TopStrategy implements Strategy {

  // Need way to update from Game to CPU to TopStrategy
  private Integer humanOdd;
  private Integer humanEven;
  private Choice choice;

  /**
   * Updates local instances with information of amount of times human played EVEN or ODD and if
   * they win with which.
   *
   * @param humanEven Amount of times human played EVEN
   * @param humanOdd Amount of times human played ODD
   * @param choice Human wins with either ODD or EVEN outcome
   */
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
