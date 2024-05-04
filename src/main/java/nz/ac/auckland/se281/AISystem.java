package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AISystem {

  int play(int eveness, int round, Choice choice, String lastWinner);
}
