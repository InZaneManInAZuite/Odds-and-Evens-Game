package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AISystem {

  Strategy strategy;

  @Override
  public int play(int eveness, int round, Choice choice) {
    if (round <= 3) {
      strategy = new RandomStrategy();
      return strategy.play(eveness, choice);
    } else {
      strategy = new SmartStrategy();
      return strategy.play(eveness, choice);
    }
  }
}
