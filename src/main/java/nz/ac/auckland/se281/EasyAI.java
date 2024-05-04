package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAI implements AISystem {

  private Strategy strategy = new RandomStrategy();

  @Override
  public int play(int eveness, int round, Choice choice, String lastWinner) {
    return strategy.play(eveness, choice);
  }
}
