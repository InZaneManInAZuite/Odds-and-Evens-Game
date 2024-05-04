package nz.ac.auckland.se281;

public class MediumMind implements MindSystem {

  private Strategy stratRand = new RandomStrategy();
  private Strategy stratSmart = new SmartStrategy();
  private Strategy strategy = new RandomStrategy();

  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play(GameTracker tracker) {
    if (tracker.getRound() <= 3) {
      setStrategy(stratRand);
    } else {
      setStrategy(stratSmart);
    }
    return strategy.play(tracker);
  }
}
