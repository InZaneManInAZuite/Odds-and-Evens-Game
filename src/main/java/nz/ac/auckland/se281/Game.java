package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // The game tracker and AI system is made
  GameTracker tracker = new GameTracker();
  private AISystem aiSystem;
  private String aiName = "HAL-9000";

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // Set up everything  for the new game
    tracker.newGameTracker(difficulty, choice, options[0]);

    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(tracker.getPlayer());

    // Create the AI system
    this.aiSystem = new AIFactory().createAI(tracker.getDifficulty());
  }

  public void play() {

    // If the game has not started, the player is informed
    if (!tracker.gameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // The round is incremented and the player is informed
    tracker.incrementRound();
    MessageCli.START_ROUND.printMessage(tracker.getRoundString());

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
    MessageCli.PRINT_INFO_HAND.printMessage(tracker.getPlayer(), input);

    // The computer's play is confirmed to the player
    int aiFinger = aiSystem.play(tracker);

    // The computer's play is confirmed to the player
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, Integer.toString(aiFinger));

    // The outcome of the round is determined
    int sum = Integer.parseInt(input) + aiFinger;
    String winner = aiName;
    String sumDiv = "";
    if (Utils.isEven(sum)) {
      sumDiv = "EVEN";
      if (tracker.getChoice() == Choice.EVEN) {
        winner = tracker.getPlayer();
      }
    } else {
      sumDiv = "ODD";
      if (tracker.getChoice() == Choice.ODD) {
        winner = tracker.getPlayer();
      }
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), sumDiv, winner);

    // The eveness is updated
    tracker.updateEveness(input);

    // The game tracker is updated
    tracker.updateWinTracker(winner);
  }

  public void endGame() {

    // If the game has not started, the player is informed
    if (!tracker.gameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Show stats
    showStats();

    // The winner is printed
    if (tracker.getPlayerWins() > tracker.getPlayerLosses()) {
      MessageCli.PRINT_END_GAME.printMessage(tracker.getPlayer());
    } else if (tracker.getPlayerWins() < tracker.getPlayerLosses()) {
      MessageCli.PRINT_END_GAME.printMessage(aiName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // The game is ended
    tracker.clearGameTracker();
  }

  public void showStats() {

    // If the game has not started, the player is informed
    if (!tracker.gameStarted()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // The player's and robot's wins and losses are printed
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        tracker.getPlayer(), tracker.getPlayerWinsString(), tracker.getPlayerLossesString());
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        aiName, tracker.getPlayerLossesString(), tracker.getPlayerWinsString());
  }
}
