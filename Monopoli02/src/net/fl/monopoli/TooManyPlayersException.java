package net.fl.monopoli;

public class TooManyPlayersException extends RuntimeException {
  @Override
  public String toString() {
    return "Too many players";
  }
}
