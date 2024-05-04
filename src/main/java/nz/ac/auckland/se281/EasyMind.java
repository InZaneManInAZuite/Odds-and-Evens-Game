package nz.ac.auckland.se281;

/** This class an easy mind system for the robot enemy of a player */
public class EasyMind implements MindSystem {

  private Strategy strategy = new RandomStrategy();

  /**
   * This method is used to produce an action for the robot enemy of a player
   *
   * @param tracker contains all the information tracked by the game
   * @return the action produced by the mind system
   */
  @Override
  public int play(GameTracker tracker) {
    return strategy.play(tracker);
  }
}
