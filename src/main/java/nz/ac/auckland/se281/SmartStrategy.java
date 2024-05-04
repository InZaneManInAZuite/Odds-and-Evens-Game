package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class SmartStrategy implements Strategy {
  @Override
  public int play(GameTracker tracker) {
    if (tracker.getEveness() > 0) {
      if (tracker.getChoice() == Choice.ODD) {
        // When player usually chooses even,
        // and odd is needed by player to win, return even
        return Utils.getRandomEvenNumber();
      } else {
        // When player usually chooses even,
        // and even is needed by player to win, return odd
        return Utils.getRandomOddNumber();
      }
    } else if (tracker.getEveness() < 0) {
      if (tracker.getChoice() == Choice.ODD) {
        // When player usually chooses odd,
        // and odd is needed by player to win, return odd
        return Utils.getRandomOddNumber();
      } else {
        // When player usually chooses odd,
        // and even is needed by player to win, return even
        return Utils.getRandomEvenNumber();
      }
    } else {
      // When player chooses both even and odd equally, return random number
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
