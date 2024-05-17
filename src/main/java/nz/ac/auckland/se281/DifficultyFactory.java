package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** Difficulty factory creates the appropriate difficulty level per user input. */
public class DifficultyFactory {

  /**
   * Simply creates the difficulty level per user input in Game.java.
   *
   * @param input Chosen enum difficulty
   * @return Created Difficulty object of strength input
   */
  public static DifficultyLevel chooseDifficulty(Difficulty input) {
    // Simple switch scenario as described in class for choosing correct difficulty by user
    switch (input) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty();
      case HARD:
        return new HardDifficulty();
      default:
        return null;
    }
  }
}
