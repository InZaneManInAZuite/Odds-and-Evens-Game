package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;
  private String player;
  private Difficulty difficulty;
  private Choice choice;
  private int eveness = 0;
  private AISystem aiSystem;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // The difficulty and choice (Odd or Even) are set for this new game
    this.difficulty = difficulty;
    this.choice = choice;

    // the first element of options[0]; is the name of the player
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);

    // Create the AI system
    this.aiSystem = new AIFactory().createAI(difficulty);
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

    // The eveness is updated
    if (Utils.isEven(Integer.parseInt(input))) {
      eveness++;
    } else {
      eveness--;
    }

    // The computer's play is confirmed to the player
    int aiFinger = aiSystem.play(eveness, round);

    // The computer's play is confirmed to the player
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFinger));
  }

  public void endGame() {}

  public void showStats() {}
}
