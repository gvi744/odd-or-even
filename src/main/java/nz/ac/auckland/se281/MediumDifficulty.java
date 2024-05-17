package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * MediumDifficulty changes strategy to Top Strategy after Round 3 otherwise uses Rnadom Strategy
 * before Round 3
 */
public class MediumDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public MediumDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * playMedium takes into account the round number and if less than 3 plays a random number,
   * otherwise uses top strategy
   *
   * @param roundNumber The round number
   * @param humanEven Amount of times human chose even number
   * @param humanOdd Amount of times human chose odd number
   * @param choice Human wins with EVEN or ODD
   */
  public void playMedium(Integer roundNumber, Integer humanEven, Integer humanOdd, Choice choice) {
    if (roundNumber <= 3) {
      this.strategy = new RandomStrategy();
    } else {
      this.strategy = new TopStrategy(humanEven, humanOdd, choice);
    }
  }

  public Integer getFingers() {
    return strategy.getFingers();
  }
}
