package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class CPU {
  private DifficultyLevel difficultyLevel;
  private Strategy strategy;
  private Integer roundNumber;
  private Integer humanEven;
  private Integer humanOdd;
  private Choice choice;

  public CPU(
      DifficultyLevel difficultyLevel,
      Integer roundNumber,
      Integer humanEven,
      Integer humanOdd,
      Choice choice) {
    this.difficultyLevel = difficultyLevel;
    this.roundNumber = roundNumber;
    this.humanEven = humanEven;
    this.humanOdd = humanOdd;
    this.choice = choice;
  }

  public void setDifficulty(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public Integer play() {
    if (difficultyLevel instanceof EasyDifficulty) {
      this.strategy = new RandomStrategy();
    } else if (difficultyLevel instanceof MediumDifficulty) {
      if (roundNumber < 4) {
        this.strategy = new RandomStrategy();
      } else {
        this.strategy = new TopStrategy(humanEven, humanOdd, choice);
      }
    } else if (difficultyLevel instanceof HardDifficulty) {
      this.strategy = new RandomStrategy();
    }
    return strategy.getFingers();
  }
}
