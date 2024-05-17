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

  /**
   * Updates all necessary instances to be passed onto Strategy to determine Ai number of fingers.
   *
   * @param difficultyLevel Chosen difficulty by user
   * @param roundNumber Round number to change strategy if higher than 3
   * @param humanEven Number of times the human picked an even number
   * @param humanOdd Number of times the human picked an odd number
   * @param choice Human's choice to win with either EVEN or ODD
   * @param lostLastRound Did the Ai lose the last round?
   */
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

  /**
   * Ability to manually set the difficulty level of the Ai.
   *
   * @param difficultyLevel Updates the local difficulty level of Ai
   */
  public void setDifficulty(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  /**
   * Ai takes more information depending on how smart it needs to be if Medium or Hard strength, and
   * returns a number based on custom processing per specification.
   *
   * @return Returns the number of fingers Ai has chosen
   */
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
