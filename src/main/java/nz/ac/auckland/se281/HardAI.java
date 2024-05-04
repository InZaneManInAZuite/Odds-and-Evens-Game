package nz.ac.auckland.se281;

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
  public int play(GameTracker tracker) {
    if (tracker.getRound() <= 3) {
      setStrategy(stratRand);
    } else if (!tracker.getLastWinner().equals("HAL-9000")) {
      switchStrategy();
    }
    return strategy.play(tracker);
  }
}
