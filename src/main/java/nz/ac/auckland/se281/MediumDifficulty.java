package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public MediumDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

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
