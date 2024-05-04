package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAI implements AISystem {

  Strategy stratRand = new RandomStrategy();
  Strategy stratSmart = new SmartStrategy();
  Strategy strategy = stratRand;

  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  private void switchStrategy() {
    if (strategy == stratRand) {
      setStrategy(stratSmart);
    } else {
      setStrategy(stratRand);
    }
  }

  @Override
  public int play(int eveness, int round, Choice choice, String lastWinner) {
    if (round <= 3) {
      setStrategy(stratRand);
    } else if (!lastWinner.equals("HAL-9000")) {
      switchStrategy();
    }
    return strategy.play(eveness, choice);
  }
}
