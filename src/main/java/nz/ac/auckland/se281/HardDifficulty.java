package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public HardDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void playHard(
      Integer roundNumber,
      Integer humanEven,
      Integer humanOdd,
      Choice choice,
      Boolean lostLastRound,
      Strategy lastStrategy) {
    if (roundNumber <= 3) {
      this.strategy = new RandomStrategy();
    } else if (lostLastRound) {
      if (lastStrategy instanceof RandomStrategy) {
        this.strategy = new TopStrategy(humanEven, humanOdd, choice);
      } else {
        this.strategy = new RandomStrategy();
      }
    } else {
      if (lastStrategy instanceof RandomStrategy) {
        this.strategy = new RandomStrategy();
      } else {
        this.strategy = new TopStrategy(humanEven, humanOdd, choice);
      }
    }
    lastStrategy = this.strategy;
  }

  public Integer getFingers() {
    return strategy.getFingers();
  }
}
