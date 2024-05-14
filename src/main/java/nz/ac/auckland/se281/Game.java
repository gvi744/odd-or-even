package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private Integer roundNumber = 0;
  private Integer fingersGiven = 6;
  private Integer cpuGiven = 0;
  private String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
  }

  public void play() {

    CPU cpu = new CPU(new RandomStrategy());
    roundNumber++;
    fingersGiven = 6;

    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    while (fingersGiven < 0 || fingersGiven > 5) {
      String input = Utils.scanner.nextLine();
      fingersGiven = Integer.parseInt(input);
      if (fingersGiven < 0 || fingersGiven > 5) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingersGiven));
    cpuGiven = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(cpuGiven));

    // Assume human picked even
    if (Utils.isEven(cpuGiven + fingersGiven)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(cpuGiven + fingersGiven), "EVEN", "HAL-9000");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(cpuGiven + fingersGiven), "ODD", playerName);
    }
  }

  public void endGame() {}

  public void showStats() {}
}
