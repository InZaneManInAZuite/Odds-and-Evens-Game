package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AISystem {

  Strategy strategy = new RandomStrategy();

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play(int eveness, int round, Choice choice) {
    if (round <= 3) {
      return strategy.play(eveness, choice);
    } else {
      setStrategy(new SmartStrategy());
      return strategy.play(eveness, choice);
    }
  }
}
