package net.fl.monopoli;

public class Player {

  private final String name;
  private Board board;

  public Player(String name) {
    this.name = name;
  }

  public void throwDice(Die... dice) {
    int diceResult = 0;
    for (int i = 0; i < dice.length; i++) {
      dice[i].roll();
      diceResult += dice[i].result();
    }
    board.move(this, diceResult);
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  @Override
  public String toString() {
    return name;
  }
}
