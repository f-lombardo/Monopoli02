package net.fl.monopoli;

public class TooFewPlayersException extends RuntimeException {

  @Override
  public String toString() {
    return "Too few players";
  }
}
