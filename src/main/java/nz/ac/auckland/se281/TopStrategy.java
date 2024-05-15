package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  // Need way to update from Game to CPU to TopStrategy
  private Integer humanOdd;
  private Integer humanEven;

  @Override
  public Integer getFingers() {
    if (humanEven > humanOdd) {
      return Utils.getRandomOddNumber();
    } else if (humanEven < humanOdd) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
