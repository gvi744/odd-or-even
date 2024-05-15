package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private Integer roundNumber = 0;
  private Integer fingersGiven = 6;
  private Integer cpuGiven = 0;
  private String playerName;
  private Integer humanEven = 0;
  private Integer humanOdd = 0;
  private DifficultyLevel difficultyLevel;
  private Choice choice;
  private Boolean lostLastRound = false;
  private Integer roundsWon = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
    this.difficultyLevel = DifficultyFactory.chooseDifficulty(difficulty);
    this.humanEven = 0;
    this.humanOdd = 0;
    this.choice = choice;
    this.roundNumber = 1;
    this.roundsWon = 0;
  }

  public void play() {

    if (roundNumber == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    fingersGiven = 6;
    CPU cpu = new CPU(difficultyLevel, roundNumber, humanEven, humanOdd, choice, lostLastRound);

    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    while (fingersGiven < 0 || fingersGiven > 5) {
      String input = Utils.scanner.nextLine();
      fingersGiven = Integer.parseInt(input);
      if (fingersGiven < 0 || fingersGiven > 5) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    if (Utils.isEven(fingersGiven)) {
      humanEven++;
    } else {
      humanOdd++;
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingersGiven));
    cpuGiven = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(cpuGiven));

    if (choice == Main.Choice.EVEN) {
      if (Utils.isEven(cpuGiven + fingersGiven)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(cpuGiven + fingersGiven), "EVEN", playerName);
        lostLastRound = true;
        roundsWon++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(cpuGiven + fingersGiven), "ODD", "HAL-9000");
        lostLastRound = false;
      }
    } else if (choice == Main.Choice.ODD) {
      if (Utils.isEven(cpuGiven + fingersGiven)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(cpuGiven + fingersGiven), "EVEN", "HAL-9000");
        lostLastRound = false;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(cpuGiven + fingersGiven), "ODD", playerName);
        lostLastRound = true;
        roundsWon++;
      }
    }

    roundNumber++;
  }

  public void endGame() {

    if (roundNumber == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    String roundsLost = Integer.toString(roundNumber - roundsWon - 1);
    MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, Integer.toString(roundsWon), roundsLost);
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", roundsLost, Integer.toString(roundsWon));

    if (roundsWon == (roundNumber - roundsWon - 1)) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else if (roundsWon > (roundNumber - roundsWon - 1)) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (roundsWon < (roundNumber - roundsWon - 1)) {
      System.out.println(roundsWon);
      System.out.println(roundNumber);
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }
    this.humanEven = 0;
    this.humanOdd = 0;
    this.roundNumber = 0;
    this.roundsWon = 0;
  }

  public void showStats() {
    if (roundNumber == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    String roundsLost = Integer.toString(roundNumber - roundsWon - 1);
    MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, Integer.toString(roundsWon), roundsLost);
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", roundsLost, Integer.toString(roundsWon));
  }
}
