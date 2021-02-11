# GoogleMap_Tiles

Introduction
If you have used Google maps (or any other map application) you have seen how it draws the map using rectangular tiles. As you zoom or pan the map, it loads tiles interactively. It does so smartly so that it is not using the data connection more than it needs to.

In order to do this, it always maintains the current part of the map you are looking at as a rectangle. This rectangle has only horizontal and vertical sides. The rectangle is represented by its lower-left corner (x,y), its width and its height. All of them can be assumed to be integral numbers. When you move the map in any way it determines whether it must load additional map tiles, and if so, which ones. For example:

When you pan the map, it determines if the rectangle for the current screen overlaps with the rectangle for the previous screen.

Given two screen regions represented as rectangles, it wishes to determine which regions are common to both, so that it does not reload those tiles.

When you zoom out, it determines the smallest rectangle that covers both the previous regions and the current regions. It then loads in this as a single tile, which is faster than loading in several smaller tiles.

Although implementing any part of Google Maps seems daunting, all these operations can be implemented on rectangles. The above list corresponds to checking if two rectangles overlap, determine the intersection of two rectangles and the union of two rectangles. The figure below illustrates these operations. Note that the union of two rectangles is always a rectangle. Also the intersection of two rectangles is always a rectangle, if it exists.



What to do
For this assignment, you must write a class Rectangle and a tester RectangleTest. The  Rectangle class should have only the following public methods (you can add private methods if you wish):

Write a constructor that creates a rectangle using the x, y coordinates of its lower left corner, its width and its height in that order. Creating a rectangle with negative width or height should throw an IllegalArgumentException, although x and y are allowed to be negative.

Write a method overlap(Rectangle other). This method should return true if this rectangle overlaps with other, false otherwise. Touching is not overlapping.

Write a method intersect(Rectangle other). This method should return a Rectangle object that represents the intersection of this rectangle and the other rectangle (i.e. the region that overlaps between the two rectangles). If no intersection exists, it should throw a NoSuchElementException with a helpful message.

Write a method union(Rectangle other). This method returns a Rectangle object that represents the union of this rectangle and the other rectangle. The union is the smallest rectangle that contains both rectangles. Note that unlike the intersection, the union always exists.

Write a method toString that returns a String. The string should be formatted exactly as: “x:X, y:Y, w:W, h:H” without the quotation marks and replacing the symbols with their actual values.
