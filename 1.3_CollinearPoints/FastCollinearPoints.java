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
        int n = points.length;

        Point[] pointsCopyS = points.clone();
        Point[] pointsCopyN = pointsCopyS.clone();
        Arrays.sort(pointsCopyN);

        for (int i = 1; i < n; i++) {
            if (pointsCopyN[i].compareTo(pointsCopyN[i - 1]) == 0) {
                throw new IllegalArgumentException("Points duplicates");
            }
        }
        //
        for (int i = 0; i < pointsCopyN.length; ++i) {
            Point origin = pointsCopyN[i];
            Arrays.sort(pointsCopyS);
            Arrays.sort(pointsCopyS, origin.slopeOrder());
            int count = 1;
            Point lineBeginning = null;
            for (int j = 0; j < pointsCopyS.length - 1; ++j) {
                if (pointsCopyS[j].slopeTo(origin) == pointsCopyS[j + 1].slopeTo(origin)) {
                    count++;
                    if (count == 2) {
                        lineBeginning = pointsCopyS[j];
                        count++;
                    }
                    else if (count >= 4 && j + 1 == pointsCopyS.length - 1) {
                        if (lineBeginning.compareTo(origin) > 0) {
                            segments.add(new LineSegment(origin, pointsCopyS[j + 1]));
                        }
                        count = 1;
                    }
                }
                else if (count >= 4) {
                    if (lineBeginning.compareTo(origin) > 0) {
                        segments.add(new LineSegment(origin, pointsCopyS[j]));
                    }
                    count = 1;
                }
                else {
                    count = 1;
                }
            }
        }
        ///
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
