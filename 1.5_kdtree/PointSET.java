/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
    private SET<Point2D> set;

    public PointSET() {
        set = new SET<>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("p is null");
        set.add(p);
    }

    public boolean contains(Point2D p) {
        return set.contains(p);
    }

    public void draw() {
        for (Point2D point : set) {
            StdDraw.point(point.x(), point.y());
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("Rect is null");
        SET<Point2D> rangeSet = new SET<>();
        for (Point2D point : set) {
            if (rect.contains(point)) {
                rangeSet.add(point);
            }
        }
        return rangeSet;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("Nearest p is null");
        if (this.isEmpty()) return null;
        Point2D nearest = null;
        double minDist = Double.POSITIVE_INFINITY;
        for (Point2D point : set) {
            double dist = p.distanceTo(point);
            if (dist < minDist) {
                minDist = dist;
                nearest = point;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        PointSET set = new PointSET();
        set.insert(new Point2D(0.2, 0.3));
        set.insert(new Point2D(0.4, 0.5));
        set.insert(new Point2D(0.6, 0.1));

        System.out.println("Size of point set: " + set.size());

        Point2D queryPoint = new Point2D(0.3, 0.4);
        Point2D nearestPoint = set.nearest(queryPoint);
        System.out.println("Nearest point to " + queryPoint + " is " + nearestPoint);
        set.draw();
    }
}
