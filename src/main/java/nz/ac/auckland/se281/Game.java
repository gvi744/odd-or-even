package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private Integer roundNumber = 0;
  private Integer fingersGiven = 6;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundNumber = 1;
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    while (fingersGiven < 0 || fingersGiven > 5) {
      String input = Utils.scanner.nextLine();
      fingersGiven = Integer.parseInt(input);
      if (fingersGiven < 0 || fingersGiven > 5) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
