public class Rectangle implements GoogleMapsTiles {
  private int x;
  private int y;
  private int w;
  private int h;

  public Rectangle(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  public boolean overlap(Rectangle other) {
    return true;
  }

  public Rectangle intersect(Rectangle other) {
    return other;
  }

  public Rectangle union(Rectangle other) {
    return other;
  }

  public String toString() {
    String str = String.format("x:" + "%d" + ", " + "y:" + "%d" + ", " + "w:" + "%d" + ", " + "h:" + "%d", x, y, w, h);
    return str;
  }

//  public static void main(String[] args) {
//    Rectangle rec = new Rectangle(0,0,0,0);
//    System.out.println(rec.toString());
//  }
}
