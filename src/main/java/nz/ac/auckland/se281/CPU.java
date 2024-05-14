package nz.ac.auckland.se281;

public class CPU {
  private Strategy strategy;

  public CPU(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Integer play() {
    return strategy.getFingers();
  }
}
