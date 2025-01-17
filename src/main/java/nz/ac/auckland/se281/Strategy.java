package nz.ac.auckland.se281;

/** This interface is used to define the strategy for the robot enemy of a player. */
public interface Strategy {

  /**
   * This method is used to produce an action for the robot enemy of a player.
   *
   * @param tracker contains all the information tracked by the game
   * @return the action produced by the strategy
   */
  int play(GameTracker tracker);
}
