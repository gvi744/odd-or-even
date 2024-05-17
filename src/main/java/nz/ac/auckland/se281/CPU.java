package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Cpu {
  private DifficultyLevel difficultyLevel;
  private Strategy strategy;
  private Integer roundNumber;
  private Integer humanEven;
  private Integer humanOdd;
  private Choice choice;
  private Boolean lostLastRound;
  private Strategy lastStrategy;

  public Cpu(
      DifficultyLevel difficultyLevel,
      Integer roundNumber,
      Integer humanEven,
      Integer humanOdd,
      Choice choice,
      Boolean lostLastRound) {
    this.difficultyLevel = difficultyLevel;
    this.roundNumber = roundNumber;
    this.humanEven = humanEven;
    this.humanOdd = humanOdd;
    this.choice = choice;
    this.lostLastRound = lostLastRound;
  }

  public void setDifficulty(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public Integer play() {
    if (difficultyLevel instanceof EasyDifficulty) {
      this.strategy = new RandomStrategy();
    } else if (difficultyLevel instanceof MediumDifficulty) {
      if (roundNumber <= 3) {
        this.strategy = new RandomStrategy();
      } else {
        this.strategy = new TopStrategy(humanEven, humanOdd, choice);
      }
    } else if (difficultyLevel instanceof HardDifficulty) {

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
    return strategy.getFingers();
  }
}
