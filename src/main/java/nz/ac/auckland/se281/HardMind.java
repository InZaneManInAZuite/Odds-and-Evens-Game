package nz.ac.auckland.se281;

/** This class a hard mind system for the robot enemy of a player */
public class HardMind implements MindSystem {

  private Strategy stratRand = new RandomStrategy();
  private Strategy stratSmart = new SmartStrategy();
  private Strategy strategy = stratRand;

  /**
   * This method is used to set the strategy of the mind system
   *
   * @param strategy the strategy to be set
   */
  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /** This method is used to switch the strategy of the mind system */
  private void switchStrategy() {
    if (strategy == stratRand) {
      setStrategy(stratSmart);
    } else {
      setStrategy(stratRand);
    }
  }

  /**
   * This method is used to produce an action for the robot enemy of a player
   *
   * @param tracker contains all the information tracked by the game
   * @return the action produced by the mind system
   */
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
