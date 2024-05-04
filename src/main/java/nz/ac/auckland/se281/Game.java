package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // The player is asked to input the number of fingers
    boolean inputIsValid = false;
    while (!inputIsValid) {
      MessageCli.ASK_INPUT.printMessage();
      // The player inputs the number of fingers
      String input = Utils.scanner.nextLine();
      // The input is validated
      if (input.matches("[0-5]")) {
        inputIsValid = true;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
      // If the input is invalid, the player is asked to input again
      // If the input is valid, the game continues
    }
  }

  public void endGame() {}

  public void showStats() {}
}
