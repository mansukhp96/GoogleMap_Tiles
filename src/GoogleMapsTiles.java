/**
 * This interface represents a set of operations on rectangles. It is a scaled down functionality of
 * google maps tiles.
 */

public interface GoogleMapsTiles {

  /**
   * @param other the other rectangle object.
   * @return true or false based on if the rectangles overlap.
   */

  boolean overlap(Rectangle other);

  /**
   * This method returns true if this rectangle overlaps with other, false otherwise. However
   * touching rectangles are not considered as overlapping.
   *
   * @param other the other rectangle object.
   * @return the new intersected rectangle object.
   */

  Rectangle intersect(Rectangle other);

  /**
   * Returns a new rectangle that is the intersection of the two rectangles.  If no intersection
   * exists, it throws a NoSuchElementException.
   *
   * @param other the other rectangle object.
   * @return the new union rectangle object.
   */

  Rectangle union(Rectangle other);

  /** This method returns a Rectangle object that represents the union of this rectangle and the
   * other rectangle. The union is the smallest rectangle that contains both rectangles. Note that
   * unlike the intersection, the union always exists.
   */
}