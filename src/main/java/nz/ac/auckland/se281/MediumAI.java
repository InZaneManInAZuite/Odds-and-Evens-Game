package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AISystem {

  Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play(int eveness, int round, Choice choice) {
    if (round <= 3) {
      setStrategy(new RandomStrategy());
      return strategy.play(eveness, choice);
    } else {
      setStrategy(new SmartStrategy());
      return strategy.play(eveness, choice);
    }
  }
}
