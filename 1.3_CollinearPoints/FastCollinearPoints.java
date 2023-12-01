/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> segments = new ArrayList<LineSegment>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        for (Point point : points) {
            if (point == null) throw new IllegalArgumentException();
        }

        Point[] pointsSlopes = points.clone();
        Arrays.sort(points);

        for (int i = 1; i < points.length; i++) {
            if (points[i].compareTo(points[i - 1]) == 0) {
                throw new IllegalArgumentException("Points duplicates");
            }
        }

        for (int i = 0; i < pointsSlopes.length; ++i) {
            Point origin = points[i];
            Arrays.sort(pointsSlopes);
            Arrays.sort(pointsSlopes, origin.slopeOrder());
            int count = 1;
            Point lineP0 = null;
            for (int j = 0; j < pointsSlopes.length - 1; ++j) {
                if (pointsSlopes[j].slopeTo(origin) == pointsSlopes[j + 1].slopeTo(origin)) {
                    count++;
                    if (count == 2) {
                        lineP0 = pointsSlopes[j];
                        count++;
                    }
                    else if (count >= 4 && j + 1 == pointsSlopes.length - 1) {
                        if (lineP0.compareTo(origin) > 0) {
                            segments.add(new LineSegment(origin, pointsSlopes[j + 1]));
                        }
                        count = 1;
                    }
                }
                else if (count >= 4) {
                    if (lineP0.compareTo(origin) > 0) {
                        segments.add(new LineSegment(origin, pointsSlopes[j]));
                    }
                    count = 1;
                }
                else {
                    count = 1;
                }
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {

    }
}
