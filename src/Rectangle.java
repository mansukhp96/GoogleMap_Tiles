public class Rectangle implements GoogleMapsTiles {
  private int x;
  private int y;
  private int w;
  private int h;

  /**
   * Constructs a Rectangle object and initializes it to x, y, w and h.
   *
   * @param x Axis X Coordinate
   * @param y Axis Y Coordinate
   * @param w width of the rectangle
   * @param h height of the rectangle
   */

  public Rectangle(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  @Override
  public boolean overlap(Rectangle other) { //If rec and other are overlapping true/false
    if ((x < (other.x + other.w)) &&
            ((x + w) > other.x) &&
            (y < (other.y + other.h)) &&
            ((y + h) > other.y))
      return true;
    else
      return false;
  }

  @Override
  public Rectangle intersect(Rectangle other) { //return a rect. that is
    if (overlap(other) == true){

    }
    return other;
  }

  @Override
  public Rectangle union(Rectangle other) {
    return other;
  }

//  public static void main(String[] args) {
//    Rectangle rec = new Rectangle(4, 1, 2, 2);
//    Rectangle other = new Rectangle(1, 1, 4, 3);
//    System.out.println(rec.overlap(other));
//  }
}