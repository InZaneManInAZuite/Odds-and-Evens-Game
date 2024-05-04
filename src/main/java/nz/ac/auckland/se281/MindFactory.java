package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class MindFactory {

  public MindSystem createMind(Difficulty difficulty) {

    // Create a mind system based on the difficulty
    switch (difficulty) {
      case EASY:
        return new EasyMind();
      case MEDIUM:
        return new MediumMind();
      case HARD:
        return new HardMind();
      default:
        return null;
    }
  }
}
