package net.fl.monopoli;

import java.util.*;


public class Board {

  private Square[] squares;
  private Map<Player, Integer> positions;
  
  public Board(int nrOfSquares)  {
    this.squares = new Square[nrOfSquares];
    this.squares[0] = new Square("Go");
    for (int i = 1; i < nrOfSquares; i++) {
      this.squares[i] = new Square("Square " + i); 
    }
    this.positions = new HashMap<Player, Integer>();
  }

  public int size() {
    return squares.length;
  }

  public Square position(Player player) {
    return this.squares[positions.get(player)];
  }

  public Square square(int i) {
    return this.squares[i];
  }

  public void add(Player player) {
    this.positions.put(player, 0);
    player.setBoard(this);
  }

  public void move(Player player, int diceResult) {
    int newPosition = (positions.get(player) + diceResult) % squares.length;
    positions.put(player, newPosition);
  }

}
