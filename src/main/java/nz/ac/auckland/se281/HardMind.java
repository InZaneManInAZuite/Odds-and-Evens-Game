package nz.ac.auckland.se281;

public class HardMind implements MindSystem {

  private Strategy stratRand = new RandomStrategy();
  private Strategy stratSmart = new SmartStrategy();
  private Strategy strategy = stratRand;

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
