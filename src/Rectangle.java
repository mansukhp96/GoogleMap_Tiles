public class Rectangle implements GoogleMapsTiles {

  private int x;
  private int y;
  private int len;
  private int wid;

  public Rectangle(int x, int y, int len, int wid) {

    this.x = x;
    this.y = y;
    this.len = len;
    this.wid = wid;

  }

  public boolean overlap(Rectangle other) {
    return true;
  }

  public Rectangle intersect(Rectangle other){
    return other;
  }

  public Rectangle union(Rectangle other){
    return other;
  }
}
