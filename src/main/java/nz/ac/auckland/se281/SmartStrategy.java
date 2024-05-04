package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class SmartStrategy implements Strategy {
  @Override
  public int play(GameTracker tracker) {
    if (tracker.getEveness() > 0) {
      if (tracker.getChoice() == Choice.ODD) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    } else if (tracker.getEveness() < 0) {
      if (tracker.getChoice() == Choice.ODD) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
