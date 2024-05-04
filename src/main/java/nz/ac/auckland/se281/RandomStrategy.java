package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {
  @Override
  public int play(int eveness, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
