package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // The player's name, difficulty, and choice are stored
  private String player;
  private Difficulty difficulty;
  private Choice choice;

  // The round, eveness, and last winner are kept track of
  private int round = 0;
  private int eveness = 0;
  private String lastWinner = "";

  // The AI system is made
  private AISystem aiSystem;
  private String aiName = "HAL-9000";

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // The difficulty and choice (Odd or Even) are set for this new game
    this.difficulty = difficulty;
    this.choice = choice;

    // the first element of options[0]; is the name of the player
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);

    // Create the AI system
    this.aiSystem = new AIFactory().createAI(this.difficulty);
  }

  public void play() {

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

  public void endGame() {}

  public void showStats() {}
}
