package nz.ac.auckland.se281;

/** This class is used to define a random strategy for the robot enemy of a player. */
public class RandomStrategy implements Strategy {

  /**
   * This method is used to produce a random action for the robot enemy of a player.
   *
   * @param tracker contains all the information tracked by the game
   * @return the action produced by the random strategy
   */
  @Override
  public int play(GameTracker tracker) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
