import java.util.NoSuchElementException;
import java.util.Objects;

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
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException(" height or width cannot be zero or negative");
    }
  }

  @Override
  public boolean overlap(Rectangle other) { //If rec and other are overlapping true/false
    return ((x < (other.x + other.w))
            && ((x + w) > other.x)
            && (y < (other.y + other.h))
            && ((y + h) > other.y));
  }

  @Override
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    //return a rect. that is the intersection of the two rectangles.

    if (overlap(other)) {
      int a = Math.max(x, other.x);
      int b = Math.max(y, other.y);
      int cw = Math.abs(Math.min(x + w, other.x + other.w) - a);
      int dh = Math.abs(Math.min(y + h, other.y + other.h) - b);
      Rectangle intRec = new Rectangle(a, b, cw, dh);
      return intRec;
    } else if (!overlap(other)) {
      throw new NoSuchElementException("Rectangles don't intersect!");
    }
    return null;
  }

  @Override
  public Rectangle union(Rectangle other) {
    int a = Math.min(x, other.x);
    int b = Math.min(y, other.y);
    int cw = Math.abs(Math.max(x + w, other.x + other.w) - a);
    int dh = Math.abs(Math.max(y + h, other.y + other.h) - b);
    Rectangle uniRec = new Rectangle(a, b, cw, dh);
    return uniRec;
  }

  @Override
  public String toString() {
    String str = ("x:" + x + ", " + "y:" + y + ", " + "w:" + w + ", " + "h:" + h);
    return str;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Rectangle)) {
      return false;
    }
    Rectangle other = (Rectangle) obj;
    return (x == other.x && y == other.y && w == other.w && h == other.h);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, w, h);
  }
}