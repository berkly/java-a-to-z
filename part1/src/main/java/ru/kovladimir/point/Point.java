package ru.kovladimir.point;

public class Point {
   public double x;
   public double y;

   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }
   
  public double distanceTo(Point point) {
      //calculate distance between two points
	  return Math.sqrt(Math.pow(point.y - y, 2) + Math.pow(point.x - x, 2));
   }
}