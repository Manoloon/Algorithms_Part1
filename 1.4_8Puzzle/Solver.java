/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private boolean isSolvable;
    private int moves;
    private Stack<Board> solutionSteps;

    private class TargetNode implements Comparable<TargetNode> {
        private final TargetNode previous;
        private final Board currentBoard;
        private final int moves;

        // constructor
        public TargetNode(Board first, int m, TargetNode prev) {
            this.currentBoard = first;
            this.moves = m;
            this.previous = prev;
        }

        public int compareTo(TargetNode that) {
            int thisPriority = this.currentBoard.manhattan() + this.moves;
            int thatPriority = that.currentBoard.manhattan() + that.moves;
            return thisPriority - thatPriority;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
    
        MinPQ<TargetNode> mainPQ = new MinPQ<>();
        MinPQ<TargetNode> twinPQ = new MinPQ<>();

        mainPQ.insert(new TargetNode(initial, 0, null));
        twinPQ.insert(new TargetNode(initial.twin(), 0, null));

        while (true) {
            TargetNode mainMin = mainPQ.delMin();
            TargetNode twinMin = twinPQ.delMin();

            if (mainMin.currentBoard.isGoal()) {
                isSolvable = true;
                moves = mainMin.moves;
                solutionSteps = new Stack<>();
                while (mainMin != null) {
                    solutionSteps.push(mainMin.currentBoard);
                    mainMin = mainMin.previous;
                }
                break;
            }

            if (twinMin.currentBoard.isGoal()) {
                isSolvable = false;
                moves = -1;
                solutionSteps = null;
                break;
            }

            for (Board neighbor : mainMin.currentBoard.neighbors()) {
                if (mainMin.previous == null || !neighbor.equals(mainMin.previous.currentBoard)) {
                    mainPQ.insert(new TargetNode(neighbor, mainMin.moves + 1, mainMin));
                }
            }

            for (Board neighbor : twinMin.currentBoard.neighbors()) {
                if (twinMin.previous == null || !neighbor.equals(twinMin.previous.currentBoard)) {
                    twinPQ.insert(new TargetNode(neighbor, twinMin.moves + 1, twinMin));
                }
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return (isSolvable()) ? moves : -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solutionSteps;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
