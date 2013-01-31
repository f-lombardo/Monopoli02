package net.fl.monopoli;
import java.util.*;


public class Monopoli {

  public static final int MAX_PLAYERS = 8;
  public static final int MIN_PLAYERS = 2;
  
  private List<Player> players;
  private Iterator<Player> roundIterator;
  private Board board;

  public Monopoli() {
    this.players = new ArrayList<Player>();
    this.board = new Board(40);
  }
  
  public void addPlayer(Player player) {
    if (players.size() >= MAX_PLAYERS) {
      throw new TooManyPlayersException();
    }
    this.players.add(player);
    this.board.add(player);
  }

  public Player nextPlayer() {
    if (roundIterator.hasNext()) {
      return roundIterator.next();
    }
    return null;
  }

  public Square square(int i) {
    return board.square(i);
  }

  public void newRound() {
    if (players.size() < MIN_PLAYERS) {
      throw new TooFewPlayersException();
    }
    this.roundIterator = players.iterator();
  }

  public Square position(Player player) {
    return board.position(player);
  }

  public int size() {
    return this.board.size();
  }

}
