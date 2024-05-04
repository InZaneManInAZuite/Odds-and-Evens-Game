package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AISystem {

  Strategy stratRand = new RandomStrategy();
  Strategy stratSmart = new SmartStrategy();
  Strategy strategy = new RandomStrategy();

  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play(int eveness, int round, Choice choice, String lastWinner) {
    if (round <= 3) {
      setStrategy(stratRand);
    } else {
      setStrategy(stratSmart);
    }
    return strategy.play(eveness, choice);
  }
}