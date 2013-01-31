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
  }

  public Player nextPlayer() {
    return roundIterator.next();
  }

  public Square square(int i) {
    return null;
  }

  public void newRound() {
    this.roundIterator = players.iterator();
  }

  public Square position(Player player) {
    // TODO Auto-generated method stub
    return null;
  }

  public int size() {
    return this.board.size();
  }


}
