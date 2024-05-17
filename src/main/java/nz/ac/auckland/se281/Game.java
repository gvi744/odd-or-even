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

  /**
   * Updates all local instances with user input as well as clearing roundnumber and other necessary
   * components.
   *
   * @param difficulty Chosen difficulty of the level to play against
   * @param choice Want to win with even or odd
   * @param options User input name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Appends all user input to local instances to be sent for processing
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
    this.difficultyLevel = DifficultyFactory.chooseDifficulty(difficulty);
    this.humanEven = 0;
    this.humanOdd = 0;
    this.choice = choice;
    this.roundNumber = 1;
    this.roundsWon = 0;
  }

  /**
   * Checks if newgame has been run, then asks for user input (name, fingers, difficulty, ODD/EVEN)
   * Increments roundNumber, and number of times even or odd has been chosen for Ai And prints
   * winner after round calculations.
   */
  public void play() {

    /* Asks for associated input. Plays the game by running all functional processing.
    Examples include calling StrategyFactory and Ai class to handle difference between Difficulty classes.
    */
    if (roundNumber == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    fingersGiven = 6;
    Ai cpu = new Ai(difficultyLevel, roundNumber, humanEven, humanOdd, choice, lostLastRound);

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

  /**
   * Ends the game by printing out the stats of who won the most rounds and prints out total winner
   * by comparing aforementioned stats.
   */
  public void endGame() {

    // Run showStats as described in specification before printing outcome of game
    this.showStats();

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

  /**
   * Prints to the terminal the statistics of every round so far and associated winners with the
   * amount of times each person or robot has won.
   */
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
