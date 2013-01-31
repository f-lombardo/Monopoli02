package net.fl.monopoli;
import java.util.*;


public class Monopoli {

  private List<Player> players;
  private Iterator<Player> roundIterator;
  private Board board;

  public Monopoli() {
    this.players = new ArrayList<Player>();
    this.board = new Board(40);
  }
  
  public void addPlayer(Player player) {
    this.players.add(player);
    this.board.add(player);
  }

  public Player nextPlayer() {
    return roundIterator.next();
  }

  public Square square(int i) {
    return board.square(i);
  }

  public void newRound() {
    this.roundIterator = players.iterator();
  }

  public Square position(Player player) {
    return board.position(player);
  }

  public int size() {
    return this.board.size();
  }

}
