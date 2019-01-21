import java.util.NoSuchElementException;

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

  public Rectangle(int x, int y, int w, int h) throws IllegalArgumentException {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("Negative height or width not allowed");
    }
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
  public Rectangle intersect(Rectangle other) throws NoSuchElementException { //return a rect. that is

    if (overlap(other) == true) {
      int a = Math.max(x, other.x);
      int b = Math.max(y, other.y);
      int c = Math.min(x + w, other.x + other.w);
      int d = Math.min(y + h, other.y + other.h);
      int cw = Math.abs(c - a);
      int dh = Math.abs(d - b);
      Rectangle intRec = new Rectangle(a, b, cw, dh);
      System.out.println(a + "/" + b + "/" + cw + "/" + dh);
      return intRec;
    } else if (overlap(other) == false) {
      throw new NoSuchElementException("Rectangles don't intersect!");
    }
    return null;
  }

  @Override
  public Rectangle union(Rectangle other) {
    int a = Math.min(x, other.x);
    int b = Math.min(y, other.y);
    int c = Math.max(x + w, other.x + other.w);
    int d = Math.max(y + h, other.y + other.h);
    int cw = Math.abs(c - a);
    int dh = Math.abs(d - b);
    Rectangle uniRec = new Rectangle(a, b, cw, dh);
    System.out.println(a + "/" + b + "/" + cw + "/" + dh);
    return uniRec;
  }

  @Override
  public String toString() {
    String str = ("x:" + x + ", " + "y:" + y + ", " + "w:" + w + ", " + "h:" + h);
    return str;
  }

//  public static void main(String[] args) {
//    Rectangle rec = new Rectangle(6, 6, 3, 3);
//    Rectangle other = new Rectangle(5, 5, 3, 3);
//    System.out.println(rec.overlap(other));
//    System.out.println(rec.intersect(other));
//    System.out.println(rec.union(other));
//  }
}