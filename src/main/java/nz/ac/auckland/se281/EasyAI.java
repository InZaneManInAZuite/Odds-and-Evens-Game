package nz.ac.auckland.se281;

public class EasyAI implements AISystem {

  private Strategy strategy = new RandomStrategy();

  @Override
  public int play(GameTracker tracker) {
    return strategy.play(tracker);
  }
}
