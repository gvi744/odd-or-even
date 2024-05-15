package nz.ac.auckland.se281;

public class HardDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public HardDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Integer getFingers() {
    return strategy.getFingers();
  }
}
