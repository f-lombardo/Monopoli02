package net.fl.monopoli;

public class Square {

  private String squareName;

  public Square(String squareName) {
    this.squareName = squareName;
  }

  @Override
  public String toString() {
    return squareName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
             + ((squareName == null) ? 0 : squareName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Square other = (Square) obj;
    if (squareName == null) {
      if (other.squareName != null)
        return false;
    } else if (!squareName.equals(other.squareName))
      return false;
    return true;
  }

  
}
