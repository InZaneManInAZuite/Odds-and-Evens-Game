package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // The player's name, difficulty, and choice are stored
  private String player;
  private Difficulty difficulty;
  private Choice choice;

  // Tracker variables are stored
  boolean gameStarted = false;
  private int round = 0;
  private int eveness = 0;
  private String lastWinner = "";
  private int playerWins = 0;
  private int playerLosses = 0;

  // The AI system is made
  private AISystem aiSystem;
  private String aiName = "HAL-9000";

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // Everything is set up for the new game
    this.difficulty = difficulty;
    this.choice = choice;
    round = 0;
    eveness = 0;
    lastWinner = "";
    playerWins = 0;
    playerLosses = 0;

    // the first element of options[0]; is the name of the player
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);

    // Create the AI system
    this.aiSystem = new AIFactory().createAI(this.difficulty);

    // The game is started
    gameStarted = true;
  }

  public void play() {

    // If the game has not started, the player is informed
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // The round is incremented and the player is informed
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // The player is asked to input the number of fingers
    MessageCli.ASK_INPUT.printMessage();

    // The input is obtained from the player
    boolean inputIsValid = false;
    String input = "";
    while (!inputIsValid) {

      input = Utils.scanner.nextLine();

      // The input is validated
      if (input.matches("[0-5]")) {
        inputIsValid = true;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    // Confirms the inputs to the player
    MessageCli.PRINT_INFO_HAND.printMessage(player, input);

    // The computer's play is confirmed to the player
    int aiFinger = aiSystem.play(eveness, round, choice, lastWinner);

    // The computer's play is confirmed to the player
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, Integer.toString(aiFinger));

    // The outcome of the round is determined
    int sum = Integer.parseInt(input) + aiFinger;
    String winner = aiName;
    String sumDiv = "";
    if (Utils.isEven(sum)) {
      sumDiv = "EVEN";
      if (choice == Choice.EVEN) {
        winner = player;
      }
    } else {
      sumDiv = "ODD";
      if (choice == Choice.ODD) {
        winner = player;
      }
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), sumDiv, winner);

    // The eveness is updated
    if (Utils.isEven(Integer.parseInt(input))) {
      eveness++;
    } else {
      eveness--;
    }

    // The last winner is updated
    lastWinner = winner;
  }

  public void endGame() {

    // If the game has not started, the player is informed
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Show stats
    showStats();

    // The winner is printed
    if (playerWins > playerLosses) {
      MessageCli.PRINT_END_GAME.printMessage(player);
    } else if (playerWins < playerLosses) {
      MessageCli.PRINT_END_GAME.printMessage(aiName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // The game is ended
    gameStarted = false;
  }

  public void showStats() {

    // If the game has not started, the player is informed
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // The player's and robot's wins and losses are printed
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player, Integer.toString(playerWins), Integer.toString(playerLosses));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        aiName, Integer.toString(playerLosses), Integer.toString(playerWins));
  }
}
