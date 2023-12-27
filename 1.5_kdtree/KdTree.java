/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private Node root;
    private int size;

    private static class Node {
        private Point2D point;
        private Node left;
        private Node right;
        private boolean vertical;

        public Node(Point2D p) {
            if (p == null) throw new IllegalArgumentException("Node p is null");
            this.point = p;
            this.left = null;
            this.right = null;
        }
    }

    public KdTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("insert failed , p is null");
        root = insert(root, p, true);
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("contains failed,p is null");
        return contains(root, p);
    }

    private boolean contains(Node n, Point2D p) {
        if (n == null) return false;
        if (n.point.equals(p)) return true;
        int compare;
        if (n.vertical) {
            compare = Double.compare(p.x(), n.point.x());
        }
        else {
            compare = Double.compare(p.y(), n.point.y());
        }
        if (compare < 0) {
            return contains(n.left, p);
        }
        else {
            return contains(n.right, p);
        }
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.01);
        root.point.draw();
        if (root.vertical) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            RectHV rect = new RectHV(root.point.x(), 0.0, root.point.x(), 1.0);
            rect.draw();
        }
        else {
            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.setPenRadius();
            RectHV rect = new RectHV(0.0, root.point.y(), 1.0, root.point.y());
            rect.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("range is null");
        Stack<Point2D> pointsInRect = new Stack<>();
        range(root, rect, pointsInRect);
        return pointsInRect;
    }

    private void range(Node n, RectHV queryRect, Stack<Point2D> pointsInrect) {
        if (n == null) return;

        if (queryRect.contains(n.point)) pointsInrect.push(n.point);

        if (n.vertical) {
            if (queryRect.xmin() < n.point.x())
                range(n.left, queryRect, pointsInrect);
            if (queryRect.xmax() >= n.point.x())
                range(n.right, queryRect, pointsInrect);
        }
        else {
            if (queryRect.ymin() < n.point.y())
                range(n.left, queryRect, pointsInrect);
            if (queryRect.ymax() >= n.point.y())
                range(n.right, queryRect, pointsInrect);
        }
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("nearest failed , p is null");
        if (isEmpty()) return null;
        return nearest(root, root.point, p).point;
    }

    private Node nearest(Node currentNode, Point2D currentNearest, Point2D queryPoint) {
        if (currentNode == null) return new Node(currentNearest);

        double closestDist = queryPoint.distanceSquaredTo(currentNearest);
        double nodeDist = currentNode.point.distanceSquaredTo(queryPoint);

        if (nodeDist < closestDist) {
            currentNearest = currentNode.point;
            closestDist = nodeDist;
        }

        Node firstNode = currentNode.left;
        Node secondNode = currentNode.right;

        if ((currentNode.vertical && queryPoint.x() < currentNode.point.x()) || (
                !currentNode.vertical && queryPoint.y() < currentNode.point.y())) {
            firstNode = currentNode.right;
            secondNode = currentNode.left;
        }

        Node candidateNode = nearest(firstNode, currentNearest, queryPoint);
        double candidateDist = queryPoint.distanceSquaredTo(candidateNode.point);

        if (candidateDist < closestDist) {
            currentNearest = candidateNode.point;
            closestDist = candidateDist;
        }

        if (secondNode != null && secondNode.point.distanceSquaredTo(queryPoint) < closestDist) {
            Node localCandidateNode = nearest(secondNode, currentNearest, queryPoint);
            double localCandidateDist = queryPoint.distanceSquaredTo(localCandidateNode.point);
            
            if (localCandidateDist < closestDist) {
                currentNearest = localCandidateNode.point;
            }
        }

        return new Node(currentNearest);
    }

    public static void main(String[] args) {

    }


    private Node insert(Node n, Point2D p, boolean isVertical) {
        if (n == null) {
            Node temp = new Node(p);
            temp.vertical = isVertical;
            size++;
            return temp;
        }
        // avoid duplicates
        if (n.point.equals(p)) {
            return n;
        }
        double x = p.x();
        double y = p.y();
        double nX = n.point.x();
        double nY = n.point.y();
        if ((n.vertical && x < nX) || (!n.vertical && y < nY)) {
            n.left = insert(n.left, p, !n.vertical);
        }
        else {
            n.right = insert(n.right, p, !n.vertical);
        }
        return n;
    }
}
