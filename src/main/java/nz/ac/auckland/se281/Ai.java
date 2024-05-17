package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Ai {
  private DifficultyLevel difficultyLevel;
  private Integer roundNumber;
  private Integer humanEven;
  private Integer humanOdd;
  private Choice choice;
  private Boolean lostLastRound;
  private Strategy lastStrategy;

  public Ai(
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
    // Ai has special processing for MediumDifficulty etc. so casting required
    if (difficultyLevel instanceof MediumDifficulty) {
      ((MediumDifficulty) difficultyLevel).playMedium(roundNumber, humanEven, humanOdd, choice);
    } else if (difficultyLevel instanceof HardDifficulty) {
      ((HardDifficulty) difficultyLevel)
          .playHard(roundNumber, humanEven, humanOdd, choice, lostLastRound, lastStrategy);
    }

    return difficultyLevel.getFingers();
  }
}
