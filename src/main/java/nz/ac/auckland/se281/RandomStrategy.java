package nz.ac.auckland.se281;

/** Strategy class for returning a random number */
public class RandomStrategy implements Strategy {

  @Override
  public Integer getFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
