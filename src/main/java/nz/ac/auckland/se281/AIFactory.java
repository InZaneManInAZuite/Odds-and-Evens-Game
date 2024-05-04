package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  public AISystem createAI(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        return new EasyAI();
      case MEDIUM:
        return new MediumAI();
      case HARD:
        return new EasyAI();
      default:
        return null;
    }
  }
}
