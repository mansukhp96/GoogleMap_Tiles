import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

  private Rectangle rec;

  @Before
  public void setRec() {
    rec = new Rectangle(0,0,0,0);
  }

  @Test
  public void testInit() {
      assertEquals("x:X, y:Y, w:W, h:H",rec.overlap());
  }

  @Test
  public void testInit() {
    assertEquals("x:X, y:Y, w:W, h:H",rec.intersect());
  }

  @Test
  public void testInit() {
    assertEquals("x:X, y:Y, w:W, h:H",rec.union());
  }
}