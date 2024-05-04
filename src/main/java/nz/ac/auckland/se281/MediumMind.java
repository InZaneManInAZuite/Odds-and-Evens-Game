package nz.ac.auckland.se281;

/**
 * MediumMind class that implements the MindSystem interface. This class is used to create a medium
 * difficulty mind system.
 */
public class MediumMind implements MindSystem {

  private Strategy stratRand = new RandomStrategy();
  private Strategy stratSmart = new SmartStrategy();
  private Strategy strategy = new RandomStrategy();

  /**
   * This method is used to set the strategy of the mind system
   *
   * @param strategy the strategy to be set
   */
  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
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
    } else {
      setStrategy(stratSmart);
    }
    return strategy.play(tracker);
  }
}
