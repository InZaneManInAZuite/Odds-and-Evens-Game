package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** This class is used to create a mind system based on the difficult.y */
public class MindFactory {

  /**
   * This method is used to create a mind system based on the difficulty.
   *
   * @param difficulty the difficulty of the mind system
   * @return the mind system
   */
  public static MindSystem createMind(Difficulty difficulty) {

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
