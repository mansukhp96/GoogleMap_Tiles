import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

  private Rectangle rec;

  @Test
  public void testInit() {
    rec = new Rectangle(0, 0, 0, 0);
    assertEquals("x:0, y:0, w:0, h:0", rec.toString());
  }
}