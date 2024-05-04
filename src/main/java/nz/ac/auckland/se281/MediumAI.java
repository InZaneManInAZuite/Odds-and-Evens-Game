package nz.ac.auckland.se281;

public class MediumAI implements AISystem {

  Strategy stratRand = new RandomStrategy();
  Strategy stratSmart = new SmartStrategy();
  Strategy strategy = new RandomStrategy();

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
