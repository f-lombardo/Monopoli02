package net.fl.monopoli;

public class FixedResultDie implements Die {

  private int result;

  public FixedResultDie(int result) {
    this.result = result;
  }

  @Override
  public void doThrow() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int result() {
    return result;
  }

}
