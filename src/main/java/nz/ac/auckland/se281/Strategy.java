package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  int play(int eveness, Choice choice);
}
