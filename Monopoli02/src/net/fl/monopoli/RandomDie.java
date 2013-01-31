package net.fl.monopoli;

public class RandomDie implements Die {

  private static final int MIN = 1;
  
  private int result;
  private int sides;

  public RandomDie(int sides) {
    this.sides = sides;
  }

  @Override
  public void roll() {
    this.result = MIN + (int)(Math.random() * ((sides - MIN) + 1));
  }

  @Override
  public int result() {
    return result;
  }

}
