package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  // Simple switch scenario as described in class for choosing correct difficulty by user
  public static DifficultyLevel chooseDifficulty(Difficulty input) {
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
