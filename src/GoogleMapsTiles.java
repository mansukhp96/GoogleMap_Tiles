public interface GoogleMapsTiles {
  boolean overlap(Rectangle other);
  Rectangle intersect(Rectangle other);
  Rectangle union(Rectangle other);
}