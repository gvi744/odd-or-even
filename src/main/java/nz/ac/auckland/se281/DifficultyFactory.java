package nz.ac.auckland.se281;

public class DifficultyFactory {
  public static Difficulty chooseDifficulty(String input) {
    switch (input) {
      case "EASY":
        return new EasyDifficulty();
      case "MEDIUM":
        return new MediumDifficulty();
      case "HARD":
        return new HardDifficulty();
      default:
        return null;
    }
  }
}
