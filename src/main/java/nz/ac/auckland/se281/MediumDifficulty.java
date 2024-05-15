package nz.ac.auckland.se281;

public class MediumDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public MediumDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Integer getFingers() {
    return strategy.getFingers();
  }
}
