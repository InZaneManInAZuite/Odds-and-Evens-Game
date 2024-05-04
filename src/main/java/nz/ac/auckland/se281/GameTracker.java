package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class GameTracker {

  // Attributes to be tracked in game
  private String player;
  private Difficulty difficulty;
  private Choice choice;
  private boolean gameStarted = false;
  private int round = 0;
  private int eveness = 0;
  private String lastWinner = "";
  private int playerWins = 0;
  private int playerLosses = 0;

  public GameTracker() {}

  // Methods to update the game tracker
  public void newGameTracker(Difficulty difficulty, Choice choice, String player) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.player = player;

    this.gameStarted = true;

    this.round = 0;
    this.eveness = 0;
    this.lastWinner = "";
    this.playerWins = 0;
    this.playerLosses = 0;
  }

  public void updateWinTracker(String winner) {
    if (winner.equals(player)) {
      playerWins++;
    } else {
      playerLosses++;
    }

    if (winner.equals("HAL-9000")) {
      lastWinner = "HAL-9000";
    } else {
      lastWinner = player;
    }
  }

  public void updateEveness(String input) {
    if (Utils.isEven(Integer.parseInt(input))) {
      eveness++;
    } else {
      eveness--;
    }
  }

  public void clearGameTracker() {
    this.gameStarted = false;
    this.round = 0;
    this.eveness = 0;
    this.lastWinner = "";
    this.playerWins = 0;
    this.playerLosses = 0;
  }

  public void incrementRound() {
    round++;
  }

  // Getters for the game tracker
  public int getRound() {
    return round;
  }

  public boolean gameStarted() {
    return gameStarted;
  }

  public int getEveness() {
    return eveness;
  }

  public String getLastWinner() {
    return lastWinner;
  }

  public int getPlayerWins() {
    return playerWins;
  }

  public int getPlayerLosses() {
    return playerLosses;
  }

  public String getPlayer() {
    return player;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public Choice getChoice() {
    return choice;
  }

  // Get alternative versions of game tracker getters
  public String getRoundString() {
    return Integer.toString(round);
  }

  public String getPlayerWinsString() {
    return Integer.toString(playerWins);
  }

  public String getPlayerLossesString() {
    return Integer.toString(playerLosses);
  }
}
