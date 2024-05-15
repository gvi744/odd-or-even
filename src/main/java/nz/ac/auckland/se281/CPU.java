package nz.ac.auckland.se281;

public class CPU {
  private DifficultyLevel difficultyLevel;

  public CPU(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public void setDifficulty(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public Integer play() {
    return difficultyLevel.getFingers();
  }
}
