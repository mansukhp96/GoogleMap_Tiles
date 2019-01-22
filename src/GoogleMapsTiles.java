/**
 * This interface represents a set of operations on rectangles. It is a scaled down functionality of
 * google maps tiles.
 */

public interface GoogleMapsTiles {
  /**
   * The method returns true or false, if the rectangles overlap each other or not. Touching
   * rectangles are not a case of overlap.
   *
   * @param other the other rectangle object.
   * @return true or false based on if the rectangles overlap.
   */
  boolean overlap(Rectangle other);

  /**
   * Returns a new rectangle that is the intersection of the two rectangles.  If no intersection
   * exists, it throws a NoSuchElementException.
   *
   * @param other the other rectangle object.
   * @return the new intersected rectangle object.
   */
  Rectangle intersect(Rectangle other);

  /**
   * The method returns the new rectangle object that is the smallest rectangle that contains both
   * the rectangles provided as input. Union always exists.
   *
   * @param other the other rectangle object.
   * @return the new union rectangle object.
   */
  Rectangle union(Rectangle other);
}