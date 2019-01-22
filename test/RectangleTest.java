import com.sun.org.apache.xpath.internal.operations.Bool;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RectangleTest {

  private Rectangle rec;

  @Test //check if object is initialised with given input
  public void testInitRecInitialise() {
    rec = new Rectangle(0, 0, 1, 1);
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test //check toString method returns in the right format
  public void testToString() {
    rec = new Rectangle(1, 1, 1, 1);
    assertEquals("x:1, y:1, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check Neg width
  public void testToStringNegWidth() {
    rec = new Rectangle(1, 1, -1, 1); //throws exception neg width
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check Zero width
  public void testToStringZerWidth() {
    rec = new Rectangle(1, 1, 0, 1); //throws exception
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check Zero height
  public void testToStringZerHeight() {
    rec = new Rectangle(1, 1, 1, 0); //throws exception
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check neg height
  public void testToStringNegHeight() {
    rec = new Rectangle(-1, 1, 1, -1); //throws exception neg height
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check neg height and neg width
  public void testToStringNegHeightNegWidth() {
    rec = new Rectangle(1, -1, -1, -1); //throws exception neg height
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test(expected = IllegalArgumentException.class) //check zero height and zero width
  public void testToStringZerHeightZerWidth() {
    rec = new Rectangle(-1, 1, 0, 0); //throws exception neg height
    assertEquals("x:0, y:0, w:1, h:1", rec.toString());
  }

  @Test //check if two same rectangles on the same coordinates and w and h, actually overlap
  public void testSameOverlapRectOverlap() {
    rec = new Rectangle(3, 4, 5, 6);
    assertEquals(true, rec.overlap(new Rectangle(3, 4, 5, 6)));
  }

  @Test //check if two same rectangles on the same coordinates and w and h, actually intersect
  public void testSameOverlapRectIntersect() {
    rec = new Rectangle(6, 7, 8, 9);
    //rec.equals(new Rectangle(6,7,8,9));
    assertEquals("x:6, y:7, w:8, h:9",
            rec.intersect(new Rectangle(6, 7, 8, 9)).toString());
  }

  @Test //check if two same rectangles on the same coordinates and w and h, actually have union
  public void testSameOverlapRectUnion() {
    rec = new Rectangle(-1, -7, 8, 9);
    //rec.equals(new Rectangle(6,7,8,9));
    assertEquals("x:-1, y:-7, w:8, h:9", rec.union(new Rectangle(-1, -7, 8, 9)).toString());
  }

  @Test //check if two rectangles are equal testing equals method
  public void testSameRectEquals() {
    rec = new Rectangle(0, -5, 6, 7);
    assertEquals(true, rec.equals(new Rectangle(0, -5, 6, 7)));
  }

  @Test //check for neg x
  public void testNegX() {
    rec = new Rectangle(-7, 0, 6, 8);
    assertEquals("x:-7, y:0, w:6, h:8", rec.toString());
  }

  @Test //check for neg y
  public void testNegY() {
    rec = new Rectangle(7, -10, 6, 8);
    assertEquals("x:7, y:-10, w:6, h:8", rec.toString());
  }

  @Test //check for neg x and y
  public void testNegXY() {
    rec = new Rectangle(-17, -110, 6, 8);
    assertEquals("x:-17, y:-110, w:6, h:8", rec.toString());
  }

  @Test(expected = NoSuchElementException.class)
  public void testNoIntersection() { //no intersection exception
    rec = new Rectangle(-2, -3, 5, 1);
    assertEquals("Rectangles don't intersect!",
            rec.intersect(new Rectangle(0, 0, 2, 6)));
  }

  @Test//check if two touchiing rectangles overlap
  public void testTouchingRectOverlap() {
    rec = new Rectangle(4, -1, 3, 3);
    assertEquals(false, rec.overlap(new Rectangle(3, 0, 1, 1)));
  }

  @Test(expected = NoSuchElementException.class)
  public void testTouchingRectIntersect() { //throws exception as touching isnt intersecting
    rec = new Rectangle(5, 0, 2, 2);
    assertEquals("", rec.intersect(new Rectangle(4, 1, 1, 1)));
  }

  @Test
  public void testTouchingRectUnion() { //union always exists
    rec = new Rectangle(1, 1, 2, 2);
    assertEquals("x:1, y:1, w:3, h:4", rec.union(new Rectangle(2, 3, 2, 2)).toString());
  }

  @Test
  public void testNoOverlap() { //no overlap
    rec = new Rectangle(10, 1, 3, 4);
    assertEquals(false, rec.overlap(new Rectangle(200, 4, 5, 6)));
  }

  @Test
  public void testOverlap() { //overlap
    rec = new Rectangle(-1, 2, 5, 6);
    assertEquals(true, rec.overlap(new Rectangle(0, 0, 3, 4)));
  }

  @Test
  public void testRandUnion() { //Random rectangles union
    int x = (int) (Math.random() * 10000);
    int y = (int) (Math.random() * 10000);
    int w = (int) (Math.random() * 10000);
    int h = (int) (Math.random() * 10000);
    int x1 = (int) (Math.random() * 10000);
    int y1 = (int) (Math.random() * 10000);
    int w1 = (int) (Math.random() * 10000);
    int h1 = (int) (Math.random() * 10000);
    rec = new Rectangle(x, y, w + 1, h + 1);
    Rectangle rec2 = new Rectangle(x1, y1, w1 + 1, h1 + 1);
    int a = Math.min(x, x1);
    int b = Math.min(y, y1);
    int cw = Math.abs(Math.max(x + w + 1, x1 + w1 + 1) - a);
    int dh = Math.abs(Math.max(y + h + 1, y1 + h1 + 1) - b);
    assertEquals("x:" + a + ", y:" + b + ", w:" + cw + ", h:" + dh, rec.union(rec2).toString());
  }

  @Test
  public void testRandIntersection() { //Random rectangles Intersection
    int x = (int) (Math.random() * 10000);
    int y = (int) (Math.random() * 10000);
    int w = (int) (Math.random() * 10000);
    int h = (int) (Math.random() * 10000);
    int x1 = (int) (Math.random() * 10000);
    int y1 = (int) (Math.random() * 10000);
    int w1 = (int) (Math.random() * 10000);
    int h1 = (int) (Math.random() * 10000);

    rec = new Rectangle(x, y, w + 1, h + 1);
    Rectangle rec2 = new Rectangle(x1, y1, w1 + 1, h1 + 1);
    int a = Math.max(x, x1);
    int b = Math.max(y, y1);
    int cw = Math.abs(Math.min(x + w + 1, x1 + w1 + 1) - a);
    int dh = Math.abs(Math.min(y + h + 1, y1 + h1 + 1) - b);
    assertEquals("x:" + a + ", y:" + b + ", w:" + cw + ", h:" + dh, rec.intersect(rec2).toString());
  }

  @Test
  public void testRandOverlap() { //Random rectangles overlap

    int x = (int) (Math.random() * 10000);
    int y = (int) (Math.random() * 10000);
    int w = (int) (Math.random() * 10000);
    int h = (int) (Math.random() * 10000);
    int x1 = (int) (Math.random() * 10000);
    int y1 = (int) (Math.random() * 10000);
    int w1 = (int) (Math.random() * 10000);
    int h1 = (int) (Math.random() * 10000);

    rec = new Rectangle(x, y, w + 1, h + 1);
    Rectangle rec2 = new Rectangle(x1, y1, w1 + 1, h1 + 1);

    if ((x < (x1 + w1 + 1))
            && ((x + w + 1) > x1)
            && (y < (y1 + h1 + 1))
            && ((y + h + 1) > y1)) {
      Boolean str = true;
      assertEquals(str, rec.overlap(rec2));
    }
  }

  @Test //check if one rect is inside another overlap
  public void testInsideRectOverlap() {
    rec = new Rectangle(2, 2, 5, 5);
    assertEquals(true, rec.overlap(new Rectangle(3, 3, 1, 1)));
  }

  @Test //check if one rect is inside another intersect
  public void testInsideRectIntersect() {
    rec = new Rectangle(2, 2, 5, 5);
    assertEquals("x:3, y:3, w:1, h:1", rec.intersect(new Rectangle(3, 3, 1, 1)).toString());
  }

  @Test //check if one rect is inside another union
  public void testInsideRectUnion() {
    rec = new Rectangle(2, 2, 5, 5);
    assertEquals("x:2, y:2, w:5, h:5", rec.union(new Rectangle(3, 3, 1, 1)).toString());
  }
}