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
        while (root != null) {
            if (root.vertical) {
                if (p.x() > root.point.x() || p.y() != root.point.y()) root = root.right;
                else if (p.x() < root.point.x()) root = root.left;
                else return true;
            }
            else {
                if (p.y() > root.point.y() || p.x() != root.point.x()) root = root.right;
                else if (p.y() < root.point.y()) root = root.left;
                else return true;
            }
        }
        return false;
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
        Stack<Point2D> pointsInRect = new Stack<Point2D>();
        RectHV rootRect = new RectHV(0.0, 0.0, 1.0, 1.0);
        range(root, rootRect, rect, pointsInRect);
        return pointsInRect;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("nearest failed , p is null");
        if (isEmpty()) return null;
        Node nearestN = nearest(root, root.point, p);
        return nearestN.point;
    }

    public static void main(String[] args) {

    }

    private Node nearest(Node currentNode, Point2D currentNearest,
                         Point2D queryPoint) {
        if (currentNode == null) return null;
        Node closestNode = new Node(currentNearest);
        double closestDist = queryPoint.distanceSquaredTo(closestNode.point);
        if (currentNode.point.distanceSquaredTo(queryPoint) < closestDist) {
            closestNode = currentNode;
            closestDist = queryPoint.distanceSquaredTo(closestNode.point);
        }
        Node firstNode;
        Node secondNode;
        if ((currentNode.vertical && queryPoint.x() < currentNode.point.x()) ||
                (!currentNode.vertical && queryPoint.y() < currentNode.point.y())) {
            firstNode = currentNode.left;
            secondNode = currentNode.right;
        }
        else {
            firstNode = currentNode.right;
            secondNode = currentNode.left;
        }
        Node candidateNode = nearest(firstNode, closestNode.point, queryPoint);
        if (candidateNode.point.distanceSquaredTo(queryPoint) < closestDist) {
            closestNode = candidateNode;
            closestDist = queryPoint.distanceSquaredTo(closestNode.point);
        }

        if (secondNode != null && secondNode.point.distanceSquaredTo(queryPoint) < closestDist) {
            Node localcandidateNode = nearest(secondNode, closestNode.point, queryPoint);
            if (localcandidateNode.point.distanceSquaredTo(queryPoint) < closestDist) {
                closestNode = localcandidateNode;
            }
        }

        return closestNode;
    }

    private void range(Node n, RectHV nRect, RectHV queryRect, Stack<Point2D> pointsInrect) {
        if (n == null) throw new IllegalArgumentException("in Range, root null");
        if (!nRect.intersects(queryRect)) return;
        if (queryRect.contains(n.point)) pointsInrect.push(n.point);

        RectHV leftRect;
        RectHV rightRect;
        if (n.vertical) {
            leftRect = new RectHV(nRect.xmin(), nRect.ymin(), n.point.x(), nRect.ymax());
            rightRect = new RectHV(n.point.x(), nRect.ymin(), nRect.xmax(), nRect.ymax());
        }
        else {
            leftRect = new RectHV(nRect.xmin(), nRect.ymin(), nRect.xmax(), n.point.y());
            rightRect = new RectHV(nRect.xmin(), n.point.y(), nRect.xmax(), nRect.ymax());
        }

        range(n.left, leftRect, queryRect, pointsInrect);
        range(n.right, rightRect, queryRect, pointsInrect);
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
