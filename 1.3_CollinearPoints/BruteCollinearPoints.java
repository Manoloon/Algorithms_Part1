/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class BruteCollinearPoints {
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
			if(points == null){
				throw new IllegalArgumentException();
			}
			for(point : points){
				if(point == null) throw new IllegalArgumentException();
				}
    }

    public int numberOfSegments() {
        return -1;
    }

    public LineSegment[] segments() {
        return null;
    }

    public static void main(String[] args) {

    }
}
