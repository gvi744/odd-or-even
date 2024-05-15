package nz.ac.auckland.se281;

public class EasyDifficulty implements DifficultyLevel {
  private Strategy strategy;

  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Integer getFingers() {
    return strategy.getFingers();
  }
}
