package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;
  private String player;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // the first element of options[0]; is the name of the player
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);
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

    MessageCli.PRINT_INFO_HAND.printMessage(player, input);
  }

  public void endGame() {}

  public void showStats() {}
}
