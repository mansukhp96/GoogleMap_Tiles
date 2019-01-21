import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

  private Rectangle rec;

  @Test
  public void testInit() {
    rec = new Rectangle(0, 0, 0, 0);
    assertEquals("f", rec.overlap(new Rectangle(1, 0, 0, 0)));
  }
}